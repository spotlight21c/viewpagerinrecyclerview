package com.trend21c.viewpagerinrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Product> items = new ArrayList<>();

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(mLayoutManager);
        ProductCardAdapter mCardAdapter = new ProductCardAdapter(getSupportFragmentManager(), items);
        rv.setAdapter(mCardAdapter);
    }
}
