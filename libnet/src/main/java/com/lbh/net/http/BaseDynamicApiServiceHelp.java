package com.lbh.net.http;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by linbinghuang on 2016/6/19.
 * 网络访问帮助基础类
 * 主要对Retrofit +okhttp的基础封装
 * @param <T>
 */
public abstract class BaseDynamicApiServiceHelp<T> {

    // 网络访问超时时间
    private static final long DEFAULT_TIME_OUT = 10;
    private static final long DEFAULT_READ_TIME_OUT = 10;
    private static final long DEFAULT_WRITE_TIME_OUT = 10;
    protected T mApiService;

    public void init(String url){
        Retrofit mRetrofit = createDefRetrofit(url);
        mApiService = createApiService(mRetrofit);
    }

    /**
     * 创建Retrofit
     * @return
     */
    protected Retrofit createDefRetrofit(String url) {
        return new Retrofit.Builder()
                .client(createOkhttp().build())
                .addConverterFactory(createConverterFactory())
                .addCallAdapterFactory(createCallAdapter())
                .baseUrl(url)
                .build();
    }


    /**
     * 创建api服务
     * @param retrofit
     * @return
     */
    private T createApiService(Retrofit retrofit) {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<T> b = (Class<T>) pt.getActualTypeArguments()[0];
        return retrofit.create(b);
    }

    /**
     * 创建okhttp
     *
     * @return
     */
    protected OkHttpClient.Builder createOkhttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间
        builder.writeTimeout(DEFAULT_WRITE_TIME_OUT, TimeUnit.SECONDS);//写操作 超时时间
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//读操作超时时间
        return builder;
    }

    /**
     * @return json解析器
     */
    protected Converter.Factory createConverterFactory() {
        return GsonConverterFactory.create();
    }

    /**
     * rxjava适配器
     *
     * @return
     */
    protected CallAdapter.Factory createCallAdapter() {
        return RxJava2CallAdapterFactory.create();
    }



    /**
     * 提供api服务
     * @return
     */
    public T getApiService() {
        return mApiService;
    }
}

