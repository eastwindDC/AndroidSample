package com.eastwinddc.sample;

import android.app.Application;
import android.content.Context;

/**
 * Created by ewinddc on 2017/11/3.
 */

public class App extends Application{
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();

        //we call loading method temporarily until loadingActivity is done.
        LoadingManager.init(this);
    }
    public static Context getContext(){
        return context;
    }
}
