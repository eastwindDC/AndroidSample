package com.eastwinddc.sample.http;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 */
public interface ICibaAPI {

    @GET("/dsapi")
    Call<CibaEntity> get();

    @GET("/dsapi")
    Observable<CibaEntity> rxGet();
}
