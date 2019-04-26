package com.eastwinddc.sample.md.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

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
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapter = new ItemAdapter();
        adapter.setData(0);
        recyclerView.setItemAnimator(new MyItemAnimator());
        recyclerView.addItemDecoration(new MyItemDecoration());
        recyclerView.setAdapter(adapter);
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = adapter.getInsertPosition();
//                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
//                if(position >= 0){
//                    layoutManager.scrollToPositionWithOffset(position,0);
//                }
//                Toast.makeText(RecylerViewActivity.this, "add", Toast.LENGTH_SHORT).show();
                recyclerView.scrollToPosition(position);
                adapter.localAdd();
            }
        });


        findViewById(R.id.remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.localRemove();
                Toast.makeText(RecylerViewActivity.this,"add",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class MyItemDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
//            int pos = parent.getChildAdapterPosition(view);
//            if(pos == 0){
//                outRect.left = 2*space;
//            }else if(pos == adapter.getItemCount()-1){
//                outRect.left = space;
//                outRect.right = 2*space;
//            }else {
//                outRect.left = space;
//            }
            outRect.left = space;
            outRect.right = space;
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
