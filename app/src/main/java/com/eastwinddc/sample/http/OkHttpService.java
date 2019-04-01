package com.eastwinddc.sample.http;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 */
public class OkHttpService {
    private OkHttpClient okHttpClient;

    public void init(){
        okHttpClient = new OkHttpClient.Builder().build();
    }

    public Call newCall(Request request){
        return okHttpClient.newCall(request);
    }
}
