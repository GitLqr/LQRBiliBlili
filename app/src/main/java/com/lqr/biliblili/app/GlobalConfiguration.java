package com.lqr.biliblili.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jess.arms.base.delegate.AppLifecycles;
import com.jess.arms.di.module.GlobalConfigModule;
import com.jess.arms.http.GlobalHttpHandler;
import com.jess.arms.integration.ConfigModule;
import com.lqr.biliblili.BuildConfig;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import org.simple.eventbus.EventBus;

import java.util.List;

import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.helper.ExceptionHandler;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

public class GlobalConfiguration implements ConfigModule {

    // LeakCanary观察器
    private RefWatcher mRefWatcher;

    @Override
    public void applyOptions(Context context, GlobalConfigModule.Builder builder) {
        //使用builder可以为框架配置一些配置信息
        builder
//                .baseurl(Api.APP_DOMAIN)
                // 当数据无法加载时，使用过期数据
                .rxCacheConfiguration((context1, builder1) -> builder1.useExpiredDataIfLoaderNotAvailable(true))
                .globalHttpHandler(new GlobalHttpHandler() {
                    @Override
                    public Response onHttpResultResponse(String httpResult, Interceptor.Chain chain, Response response) {
                        // 统一处理http响应。eg:状态码不是200时，根据状态码做相应的处理。
                        return response;
                    }

                    @Override
                    public Request onHttpRequestBefore(Interceptor.Chain chain, Request request) {
                        // 统一处理http请求。eg:给request统一添加token或者header以及参数加密等操作
                        return request;
                    }
                })
                .responseErrorListener((context12, t) -> {
                    /* 用来提供处理所有错误的监听
                       rxjava必要要使用ErrorHandleSubscriber(默认实现Subscriber的onError方法),此监听才生效 */

                });
//                .cacheFile(New File("cache"));
    }

    @Override
    public void injectAppLifecycle(Context context, List<AppLifecycles> lifecycles) {
        //向Application的生命周期中注入一些自定义逻辑
        lifecycles.add(new AppLifecycles() {

            @Override
            public void onCreate(Application application) {
                initTimber();
                initLeakCanary(application);
                initFragmentation();
                initARouter(application);
            }

            @Override
            public void attachBaseContext(Context base) {

            }

            @Override
            public void onTerminate(Application application) {
                mRefWatcher = null;
            }
        });
    }


    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {
        //向Activity的生命周期中注入一些自定义逻辑
        lifecycles.add(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                EventBus.getDefault().register(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                EventBus.getDefault().unregister(activity);
            }
        });
    }


    @Override
    public void injectFragmentLifecycle(Context context, List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {
        //向Fragment的生命周期中注入一些自定义逻辑
    }

    private void initARouter(Application application) {
        if (BuildConfig.LOG_DEBUG) {
            ARouter.openDebug();
            ARouter.openLog();
            ARouter.printStackTrace(); // 打印日志的时候打印线程堆栈
        }
        ARouter.init(application);
    }

    private void initFragmentation() {
        Fragmentation.builder()
                // 设置 栈视图 模式为 悬浮球模式   SHAKE: 摇一摇唤出  默认NONE：隐藏， 仅在Debug环境生效
                .stackViewMode(Fragmentation.BUBBLE)
                // 开发环境：true时，遇到异常："Can not perform this action after onSaveInstanceState!"时，抛出，并Crash;
                // 生产环境：false时，不抛出，不会Crash，会捕获，可以在handleException()里监听到
                .debug(BuildConfig.DEBUG)
                // 生产环境时，捕获上述异常（避免crash），会捕获
                // 建议在回调处上传下面异常到崩溃监控服务器
                .handleException(new ExceptionHandler() {
                    @Override
                    public void onException(Exception e) {
                        // 以Bugtags为例子: 把捕获到的 Exception 传到 Bugtags 后台。
                        // Bugtags.sendException(e);
                    }
                })
                .install();
    }


    private void initLeakCanary(Application application) {
        //leakCanary内存泄露检查
        mRefWatcher = BuildConfig.USE_CANARY ? LeakCanary.install(application) : RefWatcher.DISABLED;
    }

    private void initTimber() {
        if (BuildConfig.LOG_DEBUG) {
            //Timber日志打印
            Timber.plant(new Timber.DebugTree());
        }
    }
}