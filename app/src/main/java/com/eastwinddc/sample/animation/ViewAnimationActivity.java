package com.eastwinddc.sample.animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.eastwinddc.sample.BaseActivity;
import com.eastwinddc.sample.R;

/**
 * Created by ewinddc on 2017/11/23.
 */

public class ViewAnimationActivity extends BaseActivity implements View.OnClickListener{
    private View view;
    private Animation animation;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_animation;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initViews() {
        super.initViews();
        view = findViewById(R.id.view);
        view.setOnClickListener(this);
        animation = AnimationUtils.loadAnimation(this,R.anim.simple_anim);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view:
                view.startAnimation(animation);
                break;
        }
    }
}
