package com.eastwinddc.sample.accessibility;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;

import com.eastwinddc.sample.BaseActivity;
import com.eastwinddc.sample.R;

/**
 * Created by eastwinddc on 2017/8/14.
 */

public class AccessibilityActivity extends BaseActivity{

    private AccessibilityManager accessibilityManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_activity);

        init();
    }

    private void init(){
        accessibilityManager = (AccessibilityManager) getSystemService(Context.ACCESSIBILITY_SERVICE);
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

    public void openPermission(View view){
        AccessUtil.startPermission(this);
    }
    public void isEnable(View view){
        boolean isEnable = accessibilityManager.isEnabled();
        if(isEnable){
            Toast.makeText(this,"access is enabled",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"access is unabled",Toast.LENGTH_LONG).show();
        }
    }
}
