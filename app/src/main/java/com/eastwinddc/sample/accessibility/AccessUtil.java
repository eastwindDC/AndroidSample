package com.eastwinddc.sample.accessibility;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

/**
 * Created by eastwinddc on 2017/8/14.
 */

public class AccessUtil {
    public static void startPermission(Context context){
        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
