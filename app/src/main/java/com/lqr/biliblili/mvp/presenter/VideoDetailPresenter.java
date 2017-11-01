package com.lqr.biliblili.mvp.presenter;

import android.app.Application;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.RxLifecycleUtils;
import com.lqr.biliblili.app.data.api.Api;
import com.lqr.biliblili.app.data.entity.video.PlayUrl;
import com.lqr.biliblili.app.data.entity.video.Summary;
import com.lqr.biliblili.app.data.entity.video.VideoDetail;
import com.lqr.biliblili.mvp.contract.VideoDetailContract;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;


@ActivityScope
public class VideoDetailPresenter extends BasePresenter<VideoDetailContract.Model, VideoDetailContract.View> {

    private int page = 1;
    private int rows = 20;
    private String startInfoStr = "初始化播放器…";

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
        RetrofitUrlManager.getInstance().putDomain("video_detail_reply", Api.VIDEO_DETAIL_REPLY_BASE_URL);
    }

    public void loadData(String aid) {
        Observable.zip(mModel.getSummaryData(aid), mModel.getReplyData(aid, page, rows), (summary, reply) -> new VideoDetail(summary, reply))
                .retryWhen(new RetryWithDelay(3, 2))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new ErrorHandleSubscriber<VideoDetail>(mErrorHandler) {
                    @Override
                    public void onNext(@NonNull VideoDetail videoDetail) {
                        setVideoDetail(videoDetail);
                    }
                });
//        mModel.getSummaryData(aid)
//                .retryWhen(new RetryWithDelay(3, 2))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
//                .subscribe(new ErrorHandleSubscriber<Summary>(mErrorHandler) {
//                    @Override
//                    public void onNext(@NonNull Summary summary) {
//                        setVideoDetail(summary);
//                    }
//                });

    }

    public void loadPlayUrl(String aid) {
        // TODO: 2017/11/1 根据加载情况动态修改提示
        mRootView.setTvVideoStartInfoStr(startInfoStr);
        mModel.getPlayurl(aid)
                .retryWhen(new RetryWithDelay(3, 2))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new ErrorHandleSubscriber<PlayUrl>(mErrorHandler) {
                    @Override
                    public void onNext(PlayUrl playUrl) {
                        mRootView.playVideo(playUrl);
                    }
                });
    }

    private void setVideoDetail(VideoDetail videoDetail) {
        if (videoDetail == null) {
            return;
        }
        // 填充视频详情界面信息
        Summary summary = videoDetail.getSummary();
        if (summary == null || summary.getData() == null)
            return;
        Summary.DataBean data = summary.getData();
        mRootView.setTvAvStr(data.getStat() == null ? "" : String.valueOf(data.getStat().getAid()));
        mImageLoader.loadImage(mAppManager.getCurrentActivity(), ImageConfigImpl.builder().url(data.getPic()).imageView(mRootView.getIvCover()).build());

        // 填充简介、评论Fragment界面信息
        mRootView.initViewPager(videoDetail);
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
