package com.eastwinddc.sample.http;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.eastwinddc.sample.R;
import com.eastwinddc.sample.base.BaseActivity;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HttpActivity extends BaseActivity {
    private RetrofitService retrofitService = new RetrofitService();
    private OkHttpService okHttpService = new OkHttpService();
    private RxJavaService rxJavaService = new RxJavaService();

    @BindView(R.id.image_view)
    ImageView imageView;
    @BindView(R.id.image_view_1)
    ImageView imageView1;
    @BindView(R.id.content_view)
    TextView contentView;
    @BindView(R.id.translation_view)
    TextView translationView;

    @BindView(R.id.retrofit)
    Button retrofitButton;
    @BindView(R.id.okhttp)
    Button okhttpButton;
    @BindView(R.id.rxjava)
    Button rxjavaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_http;
    }

    @OnClick(R.id.retrofit)
    void requestRetrofit(){
        retrofitService.init("http://open.iciba.com");
        ICibaAPI cibaAPI = retrofitService.createService(ICibaAPI.class);
        Call<CibaEntity> call = cibaAPI.get();
        call.enqueue(new Callback<CibaEntity>() {
            @Override
            public void onResponse(Call<CibaEntity> call, Response<CibaEntity> response) {
                CibaEntity entity = response.body();
                refresh(entity);
            }

            @Override
            public void onFailure(Call<CibaEntity> call, Throwable t) {

            }
        });
    }
    @OnClick(R.id.okhttp)
    void requestOkHttp(){
        okHttpService.init();
        Request request = new Request.Builder()
                            .get()
                            .url("http://open.iciba.com/dsapi")
                            .build();
        okhttp3.Call call = okHttpService.newCall(request);
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                final CibaEntity cibaEntity = new Gson().fromJson(response.body().string(),CibaEntity.class);
                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh(cibaEntity);
                    }
                });

            }
        });
    }

    @OnClick(R.id.rxjava)
    void requestRxjava(){
        rxJavaService.init("http://open.iciba.com");
        ICibaAPI cibaAPI = rxJavaService.createService(ICibaAPI.class);
        cibaAPI.rxGet().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<CibaEntity>() {
                    @Override
                    public void onNext(CibaEntity cibaEntity) {
                        refresh(cibaEntity);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    private void refresh(CibaEntity entity){
        contentView.setText(entity.getContent());
        translationView.setText(entity.getTranslation());
        Picasso.get()
                .load(entity.getPicture())
                .into(imageView);
        Picasso.get()
                .load(entity.getPicture2())
                .into(imageView1);
    }
}
