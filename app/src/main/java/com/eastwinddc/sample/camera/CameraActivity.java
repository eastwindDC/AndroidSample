package com.eastwinddc.sample.camera;

import android.Manifest;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.eastwinddc.sample.R;
import com.eastwinddc.sample.base.BaseActivity;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by baimei on 2019/3/29.
 */
public class CameraActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        permissionRequest();
    }

    @Override
    protected void initViews() {
        super.initViews();
        findViewById(R.id.take).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
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
    protected int getLayoutId() {
        return R.layout.activity_camera;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }

    @AfterPermissionGranted(101)
    private void permissionRequest(){
        if(EasyPermissions.hasPermissions(this,Manifest.permission.CAMERA)){
            startPreview();
        }else {
            EasyPermissions.requestPermissions(this,"需要申请相机",101, Manifest.permission.CAMERA);
        }
    }
    private void startPreview(){
        Camera camera = getCameraInstance();
        CameraPreview cameraPreview = new CameraPreview(this,camera);
        FrameLayout preview = findViewById(R.id.preview);
        preview.addView(cameraPreview);
    }
    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }
}
