package com.example.erickrojasperez.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = this.getAllNames();

        mRecyclerView = findViewById(R.id.my_recycler_view_id);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RecyclerAdapter(names, R.layout.recycler_view_item, new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                Toast.makeText(MainActivity.this, name + " - " + position, Toast.LENGTH_LONG).show();
            }
        });

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

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
}
