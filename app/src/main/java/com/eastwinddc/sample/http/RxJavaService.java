package com.eastwinddc.sample.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 */
public class RxJavaService {
    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    public void init(String baseurl){
        okHttpClient = new OkHttpClient.Builder()
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseurl)
                .build();
    }

    public<T> T createService(Class<T> tclss){
        return retrofit.create(tclss);
    }
}
