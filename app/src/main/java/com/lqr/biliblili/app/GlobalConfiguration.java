package com.lqr.biliblili.app;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.jess.arms.base.delegate.AppLifecycles;
import com.jess.arms.di.module.GlobalConfigModule;
import com.jess.arms.integration.ConfigModule;
import com.jess.arms.utils.DataHelper;
import com.lqr.biliblili.app.config.applyOptions.MyGlobalHttpHandler;
import com.lqr.biliblili.app.config.applyOptions.MyGsonConfiguration;
import com.lqr.biliblili.app.config.applyOptions.MyResponseErrorListener;
import com.lqr.biliblili.app.config.applyOptions.MyRetrofitConfiguration;
import com.lqr.biliblili.app.config.applyOptions.MyRxCacheConfiguration;
import com.lqr.biliblili.app.config.lifecyclesOptioins.MyActivityLifecycle;
import com.lqr.biliblili.app.config.lifecyclesOptioins.MyAppLifecycles;

import java.io.File;
import java.util.List;

public class GlobalConfiguration implements ConfigModule {

    @Override
    public void applyOptions(Context context, GlobalConfigModule.Builder builder) {
        //使用builder可以为框架配置一些配置信息
        builder
                //.baseurl(Api.APP_DOMAIN)
                .retrofitConfiguration(new MyRetrofitConfiguration())
                // 使用统一UserAgent
//                .addInterceptor(new UserAgentInterceptor())
                .rxCacheConfiguration(new MyRxCacheConfiguration())
                .globalHttpHandler(new MyGlobalHttpHandler())
                .responseErrorListener(new MyResponseErrorListener())
                .cacheFile(new File(DataHelper.getCacheFile(context), "rxCache"))
                .gsonConfiguration(new MyGsonConfiguration());
    }

    @Override
    public void injectAppLifecycle(Context context, List<AppLifecycles> lifecycles) {
        //向Application的生命周期中注入一些自定义逻辑
        lifecycles.add(new MyAppLifecycles());
    }


    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {
        //向Activity的生命周期中注入一些自定义逻辑
        lifecycles.add(new MyActivityLifecycle());
    }


    @Override
    public void injectFragmentLifecycle(Context context, List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {
        //向Fragment的生命周期中注入一些自定义逻辑
    }


}