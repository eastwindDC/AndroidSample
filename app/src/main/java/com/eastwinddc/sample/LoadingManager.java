package com.eastwinddc.sample;

import android.content.Context;
import android.content.Intent;

import com.eastwinddc.sample.lockscreen.LockScreenService;

/**
 * Created by ewinddc on 2017/11/6.
 */

public class LoadingManager {
    static void init(Context context){
        Intent intent = new Intent(context, LockScreenService.class);
        context.startService(intent);
    }
}
