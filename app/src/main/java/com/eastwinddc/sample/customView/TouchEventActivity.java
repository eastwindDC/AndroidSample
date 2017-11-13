package com.eastwinddc.sample.customView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.eastwinddc.sample.BaseActivity;
import com.eastwinddc.sample.R;

/**
 * Created by ewinddc on 2017/11/13.
 */

public class TouchEventActivity extends BaseActivity implements View.OnTouchListener{
    private static final String TAG = TouchEventActivity.class.getSimpleName();
    private ViewGroup root;
    private ViewGroup layout;
    private View bt;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_touch_event;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initViews() {
        super.initViews();
        root = (ViewGroup) findViewById(R.id.root_view);
        root.setTag("root");
        layout = (ViewGroup) findViewById(R.id.layout);
        layout.setTag("layout");
        bt = findViewById(R.id.button);
        bt.setTag("button");

        root.setOnTouchListener(this);
        layout.setOnTouchListener(this);
        bt.setOnTouchListener(this);
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

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.v(TAG, "onTouch: "+(String)v.getTag()+event.getAction());
        return false;
    }

}
