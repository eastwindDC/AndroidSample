package com.eastwinddc.sample;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by eastwinddc on 2017/7/17.
 */

public abstract class BaseActivity extends AppCompatActivity{
    private static final String TAG = BaseActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: "+this);
        super.onCreate(savedInstanceState);
        initViews();
    }
    protected void initViews(){
        setContentView(getLayoutId());
    }
    protected abstract @LayoutRes int getLayoutId();
    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: "+this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: "+this);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: "+this);
        super.onDestroy();
    }
}
