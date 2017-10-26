package com.lqr.biliblili.mvp.presenter;

import android.app.Application;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.RxLifecycleUtils;
import com.lqr.biliblili.app.data.api.Api;
import com.lqr.biliblili.app.data.entity.video.Summary;
import com.lqr.biliblili.mvp.contract.VideoDetailContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;


@ActivityScope
public class VideoDetailPresenter extends BasePresenter<VideoDetailContract.Model, VideoDetailContract.View> {
    private RxErrorHandler mErrorHandler;
    private Application mApplication;
    private ImageLoader mImageLoader;
    private AppManager mAppManager;

    @Inject
    public VideoDetailPresenter(VideoDetailContract.Model model, VideoDetailContract.View rootView
            , RxErrorHandler handler, Application application
            , ImageLoader imageLoader, AppManager appManager) {
        super(model, rootView);
        this.mErrorHandler = handler;
        this.mApplication = application;
        this.mImageLoader = imageLoader;
        this.mAppManager = appManager;
        RetrofitUrlManager.getInstance().putDomain("video_detail_summary", Api.VIDEO_DETAIL_SUMMARY_BASE_URL);
    }

    public void loadData() {
        mModel.getSummaryData()
                .retryWhen(new RetryWithDelay(3, 2))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new ErrorHandleSubscriber<Summary>(mErrorHandler) {
                    @Override
                    public void onNext(@NonNull Summary summary) {
                        setVideoDetail(summary);
                    }
                });
    }

    private void setVideoDetail(Summary summary) {
        if (summary == null || summary.getData() == null)
            return;
        Summary.DataBean data = summary.getData();
        mRootView.setTvAvStr(data.getStat() == null ? "" : String.valueOf(data.getStat().getAid()));
        mImageLoader.loadImage(mAppManager.getCurrentActivity(), ImageConfigImpl.builder().url(data.getPic()).imageView(mRootView.getIvCover()).build());
        mRootView.initViewPager(summary);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }

}
