package com.eastwinddc.sample.md;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
    private int pxSize;
    private int space;
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
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setHasFixedSize(true);
        adapter = new ItemAdapter();
        pxSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100,getResources().getDisplayMetrics());
        Log.d(TAG, "initViews: pxSize "+pxSize);
        space = 1080 - 3*pxSize;
        Log.d(TAG, "initViews: all space "+space);
        space /= 4;
        adapter.setData(new String[]{
                "i am a good man",
                "he is a handsome boy",
                "he is a handsome boy",
                "The weather is fine today",
                "what a day"
        });
        recyclerView.addItemDecoration(new MyItemDecoration());
        recyclerView.setAdapter(adapter);

    }

    private class MyItemDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            int pos = parent.getChildLayoutPosition(view) % 3;
            switch (pos){
                case 0:
                    Log.d(TAG, "getItemOffsets: 0");
                    outRect.right = space;
                    break;
                case 1:
                    Log.d(TAG, "getItemOffsets: 1");
                    outRect.left = space;
                    outRect.right = space;
//                    outRect.top = 100;
                    break;
                case 2:
                    Log.d(TAG, "getItemOffsets: 2");
                    outRect.left = space;
//                    outRect.top = 150;
                    break;
            }


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
