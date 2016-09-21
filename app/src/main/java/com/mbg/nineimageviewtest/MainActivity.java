package com.mbg.nineimageviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mbg.nineimageviewtest.adapter.RecyclerAdapter;
import com.mbg.nineimageviewtest.bean.Dynamic;
import com.mbg.nineimageviewtest.util.DynamicSources;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private List<Dynamic> dynamicList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dynamicList= DynamicSources.createDynamics();
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new RecyclerAdapter(this,dynamicList);
        recyclerView.setAdapter(adapter);
    }
}
