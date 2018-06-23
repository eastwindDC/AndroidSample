package com.eastwinddc.sample.customView;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.eastwinddc.sample.base.BaseActivity;
import com.eastwinddc.sample.R;

/**
 * Created by ewinddc on 2017/10/17.
 */

public class CustomViewActivity extends BaseActivity {
//    private HydrogenView circleView ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initViews() {
        super.initViews();
//        circleView = (HydrogenView) findViewById(R.id.circle);
//        circleView.setOnTouchListener(circleView);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_custom_view;
    }

    @Override
    protected void onResume() {
        super.onResume();
//        circleView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        circleView.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
