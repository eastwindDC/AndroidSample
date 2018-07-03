package com.eastwinddc.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.eastwinddc.sample.base.BaseActivity;

/**
 * Created by ewinddc on 2017/10/18.
 */

public class RecylerViewActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recycler_view;
    }

    @Override
    protected void initViews() {
        super.initViews();
        recyclerView = (RecyclerView) findViewById(R.id.feedList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new ItemAdapter();
        adapter.setData(new String[]{
                "i am a good man",
                "he is a handsome boy",
                "The weather is fine today",
                "i am a good man",
                "he is a handsome boy",
                "The weather is fine today",
                "what a day"
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
