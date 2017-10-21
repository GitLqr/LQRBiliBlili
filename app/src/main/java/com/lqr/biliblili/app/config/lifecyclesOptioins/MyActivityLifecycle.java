package com.lqr.biliblili.app.config.lifecyclesOptioins;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import org.simple.eventbus.EventBus;


public class MyActivityLifecycle implements Application.ActivityLifecycleCallbacks {
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
}
