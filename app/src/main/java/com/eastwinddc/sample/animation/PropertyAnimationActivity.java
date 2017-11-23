package com.eastwinddc.sample.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.eastwinddc.sample.BaseActivity;
import com.eastwinddc.sample.R;

/**
 * Created by ewinddc on 2017/11/23.
 */

public class PropertyAnimationActivity extends BaseActivity implements View.OnClickListener{

    private View view;
    private Animator animator;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_animation;
    }

    @Override
    protected void initViews() {
        super.initViews();
        view = findViewById(R.id.view);
        view.setOnClickListener(this);
        animator = AnimatorInflater.loadAnimator(this,R.animator.property_anim);
        animator.setTarget(view);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view:
                animator.start();
                break;
        }
    }
}
