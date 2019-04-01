package com.eastwinddc.sample.md.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.eastwinddc.sample.R;
import com.eastwinddc.sample.base.BaseActivity;

/**
 * Created by ewinddc on 2017/10/18.
 */

public class RecylerViewActivity extends BaseActivity {
    private static final String TAG = RecylerViewActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private int space = 10;
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
        recyclerView.setLayoutManager(new GridLayoutManager(this,5));
        recyclerView.setHasFixedSize(true);
        adapter = new ItemAdapter();
        adapter.setData(3);
        recyclerView.setItemAnimator(new MyItemAnimator());
        recyclerView.addItemDecoration(new MyItemDecoration());
        recyclerView.setAdapter(adapter);

    }

    private class MyItemDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.right = space;
            outRect.bottom = space;
        }
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
