package com.eastwinddc.sample.lockscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.WindowManager;

import com.eastwinddc.sample.BaseActivity;
import com.eastwinddc.sample.R;

/**
 * Created by ewinddc on 2017/11/6.
 */

public class LockScreenActivity extends BaseActivity{
    private static final String TAG = LockScreenActivity.class.getSimpleName();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_lock_screen;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
    }

    @Override
    protected void initViews() {
        super.initViews();
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
