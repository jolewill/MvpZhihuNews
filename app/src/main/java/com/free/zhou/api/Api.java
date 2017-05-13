package com.free.zhou.api;

import android.support.constraint.solver.Cache;
import android.util.SparseArray;

import com.google.gson.Gson;
import com.jaydenxiao.common.baseapp.BaseApplication;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zskzh on 2017/5/1.
 */

public class Api {

    //读超时 5000 毫秒
    private static final int READ_TIME_OUT = 5000;

    /*链接超时 时长 5000毫秒*/
    private static final int CONNECT_TIME_OUT = 5000;

    public Retrofit retrofit;

    public ApiService apiService;

    public OkHttpClient okHttpClient;

    // public static SparseArray<Api> sRetrofitManager = new SparseArray<>()
   /*设置缓存有效时间*/
    private static final long CACHE_STATE_SEC = 60 * 60 * 24 * 2;

    private Api() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        File cacheFile = new File(BaseApplication.getAppContext().getCacheDir(), "cache");
        okhttp3.Cache cache = new okhttp3.Cache(cacheFile, 1024 * 1024 * 100);
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("Content-Type", "application/json")
                        .build();
                return chain.proceed(request);
            }
        };

        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache).build();

        Gson gson = new Gson();
        retrofit = new Retrofit.Builder().client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://news-at.zhihu.com/api/")
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static ApiService getDefault() {
        Api retrofitManager = new Api();

        return retrofitManager.apiService;
    }

}
