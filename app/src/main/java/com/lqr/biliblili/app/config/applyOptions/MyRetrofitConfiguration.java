package com.lqr.biliblili.app.config.applyOptions;

import android.content.Context;

import com.jess.arms.di.module.ClientModule;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


public class MyRetrofitConfiguration implements ClientModule.RetrofitConfiguration {
    @Override
    public void configRetrofit(Context context, Retrofit.Builder builder) {
        // 配置多BaseUrl支持
        builder.client(RetrofitUrlManager.getInstance().with(new OkHttpClient.Builder())
                .build());
    }
}
