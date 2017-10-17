package com.eastwinddc.sample.customView;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.eastwinddc.sample.BaseActivity;
import com.eastwinddc.sample.R;

/**
 * Created by ewinddc on 2017/10/17.
 */

public class CustomViewActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
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
