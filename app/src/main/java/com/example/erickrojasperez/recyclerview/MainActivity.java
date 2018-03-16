package com.example.erickrojasperez.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erickrojasperez on 3/15/18.
 */

public class MainActivity extends AppCompatActivity {

    private List<String> names;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = this.getAllNames();

        mRecyclerView = findViewById(R.id.my_recycler_view_id);
        mLayoutManager = new LinearLayoutManager(this);
        //Constructor para definir el RecyclerView en forma de cuadricula (nota: el entero define numero de columnas)
        //mLayoutManager = new GridLayoutManager(this, 2);
        //mLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        mAdapter = new RecyclerAdapter(names, R.layout.recycler_view_item, new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                //Toast.makeText(MainActivity.this, name + " - " + position, Toast.LENGTH_LONG).show();
                deleteName(position);
            }
        });

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.add_name_id:
                this.addName(0);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<String> getAllNames() {
        return new ArrayList<String>() {{
            add("Erick");
            add("Antonio");
            add("Eduardo");
            add("Jose");
            add("Gamma");
            add("Rodolfo");
            add("Roberto");
            add("Omar");
            add("Sergio");
            add("Circe");
            add("Ana");
            add("Jose");
            add("Brenda");
            add("Noemi");

        }};
    }

    /**
     * Metodo que agrega un nuevo elmento a la lista con position
     * @param position
     */
    private void addName(int position) {
        names.add(position, "newName" + (++counter));
        mAdapter.notifyItemInserted(position);
        mLayoutManager.scrollToPosition(position);
    }

    /**
     * Metodo que elimina un nombre de la lista mediante position
     * @param position
     */
    private void deleteName(int position) {
        names.remove(position);
        mAdapter.notifyItemRemoved(position);
    }
}
