package com.eastwinddc.sample.lockscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.eastwinddc.sample.BaseActivity;
import com.eastwinddc.sample.R;

/**
 * Created by ewinddc on 2017/11/6.
 */

public class LockScreenActivity extends BaseActivity implements View.OnTouchListener{
    private static final String TAG = LockScreenActivity.class.getSimpleName();
    private View rootView;
    private View parentView;
    private boolean isMoving = false;
    int lastX = 0;
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
        super.onBackPressed();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();

        int offsetX = 0;
        switch (action){
            case MotionEvent.ACTION_DOWN:
                lastX = (int) event.getX();
                isMoving = false;
                Log.d(TAG, "onTouch: down "+lastX);
                break;
            case MotionEvent.ACTION_MOVE:
                offsetX = (int) (event.getX() - lastX);

                lastX = (int) event.getX();
                Log.v(TAG, "onTouch: move "+offsetX);
                if(isMoving){
                    parentView.scrollBy(-offsetX,0);
                }else {
                    isMoving = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                lastX = (int) event.getX();
                Log.d(TAG, "onTouch: up "+lastX);
                isMoving = false;
                parentView.scrollTo(0,0);
                break;
        }
        return true;
    }
}
