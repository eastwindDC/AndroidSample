package com.eastwinddc.sample.lockscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.eastwinddc.sample.base.BaseActivity;
import com.eastwinddc.sample.R;

/**
 * Created by ewinddc on 2017/11/6.
 */

public class LockScreenActivity extends BaseActivity implements View.OnTouchListener{
    private static final String TAG = LockScreenActivity.class.getSimpleName();
    private View rootView;
    private View parentView;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_lock_screen;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        KeyguardManager keyguardManager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
//        KeyguardManager.KeyguardLock keyguardLock = keyguardManager.newKeyguardLock("feiyuLockScreen");
//        keyguardLock.disableKeyguard();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenWidth = metrics.widthPixels;
    }

    @Override
    protected void initViews() {
        super.initViews();
        rootView = findViewById(R.id.root_view);
        rootView.setOnTouchListener(this);
        parentView = getWindow().getDecorView();
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
    public void onBackPressed() {
    }

    private int screenWidth = 0;
    private boolean isMoving = false;
    private int lastX = 0;
    private int translate = 0;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        int curX = (int) event.getRawX();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                isMoving = false;
                translate = 0;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = curX - lastX;
                lastX = curX;
                if(isMoving){
                    //we just support swipe to right
                    if(translate + offsetX > 0){
                        translate += offsetX;
                        //parent scrolling -offset which relatively lead to child scroll offset
                        parentView.scrollBy(-offsetX,0);
                    }

                }else {
                    isMoving = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                isMoving = false;
                if(translate > screenWidth * 0.4){
                    Log.d(TAG, "onTouch: up finish");
                    parentView.scrollTo(screenWidth,0);
                    finish();
                }else {
                    Log.d(TAG, "onTouch: up reset");
                    parentView.scrollTo(0,0);
                }
                break;
            default:
                return false;
        }
        return true;
    }
}
