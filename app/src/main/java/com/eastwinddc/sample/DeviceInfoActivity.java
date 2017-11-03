package com.eastwinddc.sample;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by eastwinddc on 2017/7/17.
 */

public class DeviceInfoActivity extends BaseActivity{
    private static final long MB = 1024*1024;
    private ActivityManager activityManager;
    private TelephonyManager telephonyManager;
    private ListView listView;
    private List<String> stringList = new ArrayList<>();
    MyAdapter adapter = new MyAdapter();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestPermission();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_device_info;
    }

    @Override
    protected void initViews() {
        super.initViews();
        listView = (ListView) findViewById(R.id.listview);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this);
    }

    @AfterPermissionGranted(100)
    private void requestPermission(){
        String[] perms = {Manifest.permission.READ_PHONE_STATE};
        if(EasyPermissions.hasPermissions(this,perms)){
            initServices();
            refreshViews();
        }else {
            EasyPermissions.requestPermissions(this,"we really need this permission",100,perms);
        }
    }
    private void initServices(){
        activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
    }
    private void refreshViews(){
        getHeapSize();
        getImei();
        getDeviceId();
        getSearial();
        listView.setAdapter(adapter);
        adapter.setDate(stringList);
    }

    private void getHeapSize(){
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        String text= getString(R.string.kv_text,
                "heapSize",String.valueOf(memoryInfo.totalMem/MB));
        stringList.add(text);
    }
    @SuppressLint("MissingPermission")
    private void getImei(){

    }
    @SuppressLint("MissingPermission")
    private void getDeviceId(){
        String id = telephonyManager.getDeviceId();
        String text = getString(R.string.kv_text,"deviceId",id);
        stringList.add(text);

    }
    private void getSearial(){
        String text = getString(R.string.kv_text,"searial_num",Build.SERIAL);
        stringList.add(text);
    }
    private class MyAdapter extends BaseAdapter{
        private List<String> stringList = new ArrayList<>();
        @Override
        public int getCount() {
            return stringList.size();
        }

        @Override
        public Object getItem(int position) {
            return stringList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = LayoutInflater.from(App.getContext()).inflate(R.layout.item_device_info,null);
            }
            TextView textView = (TextView) convertView;
            textView.setText((String) getItem(position));
            return convertView;
        }

        public void setDate(List<String> stringList){
            this.stringList = stringList;
        }
    }
}
