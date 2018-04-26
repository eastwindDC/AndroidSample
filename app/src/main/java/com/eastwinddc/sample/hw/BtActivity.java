package com.eastwinddc.sample.hw;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.eastwinddc.sample.BaseActivity;
import com.eastwinddc.sample.R;

/**
 * Created by ewinddc on 2018/4/26.
 */

public class BtActivity extends BaseActivity{
    TextView textView;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_bt;
    }

    @Override
    protected void initViews() {
        super.initViews();
        textView = (TextView) findViewById(R.id.text);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BtManager.getInstance().init();
        textView.setText(BtManager.getInstance().getBondedName());
    }
}
