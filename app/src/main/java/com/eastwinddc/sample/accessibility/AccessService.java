package com.eastwinddc.sample.accessibility;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

/**
 * Created by eastwinddc on 2017/8/14.
 */

public class AccessService extends BaseAccessService{
    private static final String TAG = AccessService.class.getSimpleName();

    private static final String WECHAT = "com.tencent.mm";
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.d(TAG, "onAccessibilityEvent: "+event);
        int type = event.getEventType();
        String packageName = String.valueOf(event.getPackageName());
        AccessibilityNodeInfo rootNode ;

        //wechat
        if(packageName.equals(WECHAT)) {
            //notification
            if (type == AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED) {
                Log.i(TAG, "onAccessibilityEvent: " + event.getText());
                Parcelable data = event.getParcelableData();
                if (data == null || !(data instanceof Notification)) {
                    return;
                }
                Notification nf = (Notification) data;
                try {
                    nf.contentIntent.send();
                } catch (PendingIntent.CanceledException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onInterrupt() {
        Log.d(TAG, "onInterrupt: ");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.d(TAG, "onServiceConnected: ");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
