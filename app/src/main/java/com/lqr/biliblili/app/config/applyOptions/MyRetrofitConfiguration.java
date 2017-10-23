package com.lqr.biliblili.app.config.applyOptions;

import android.content.Context;

import com.jess.arms.di.module.ClientModule;
import com.lqr.biliblili.BuildConfig;
import com.lqr.biliblili.app.config.applyOptions.intercept.LoggingInterceptor;
import com.lqr.biliblili.app.config.applyOptions.intercept.UserAgentInterceptor;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


public class MyRetrofitConfiguration implements ClientModule.RetrofitConfiguration {
    @Override
    public void configRetrofit(Context context, Retrofit.Builder builder) {
        // 配置多BaseUrl支持
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(new LoggingInterceptor());//使用自定义的Log拦截器
        }
        clientBuilder.addInterceptor(new UserAgentInterceptor());//使用自定义User-Agent
        builder.client(RetrofitUrlManager.getInstance().with(clientBuilder)
                .build());
    }
}
