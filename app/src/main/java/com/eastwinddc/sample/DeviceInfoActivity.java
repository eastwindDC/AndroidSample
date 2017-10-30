package com.eastwinddc.sample;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by eastwinddc on 2017/7/17.
 */

public class DeviceInfoActivity extends BaseActivity{
    private static final long MB = 1024*1024;
    private ActivityManager activityManager;
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_device_info;
    }

    @Override
    protected void initViews() {
        super.initViews();
        textView = (TextView) findViewById(R.id.heap);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(memoryInfo);
        textView.setText(String.valueOf(memoryInfo.totalMem/MB));
    }
}
