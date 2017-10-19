package com.lqr.biliblili.mvp.presenter;

import android.app.Application;

import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.lqr.biliblili.mvp.contract.LiveContract;

import javax.inject.Inject;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@FragmentScope
public class LivePresenter extends BasePresenter<LiveContract.Model, LiveContract.View> {

    private RxErrorHandler mErrorHandler;
    private Application mApplication;
    private ImageLoader mImageLoader;
    private AppManager mAppManager;

    @Inject
    public LivePresenter(LiveContract.Model model, LiveContract.View rootView, RxErrorHandler errorHandler, Application application, ImageLoader imageLoader, AppManager appManager) {
        super(model, rootView);
        mErrorHandler = errorHandler;
        mApplication = application;
        mImageLoader = imageLoader;
        mAppManager = appManager;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }

    public void loadData() {
        setAdapter();
    }

    public void setAdapter() {
//        new BaseMultiItemQuickAdapter();
    }
}
