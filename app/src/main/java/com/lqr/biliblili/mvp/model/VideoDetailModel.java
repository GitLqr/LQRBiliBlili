package com.lqr.biliblili.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.lqr.biliblili.app.data.api.service.VideoDetailService;
import com.lqr.biliblili.app.data.entity.video.Reply;
import com.lqr.biliblili.app.data.entity.video.Summary;
import com.lqr.biliblili.mvp.contract.VideoDetailContract;

import javax.inject.Inject;

import io.reactivex.Observable;


@ActivityScope
public class VideoDetailModel extends BaseModel implements VideoDetailContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public VideoDetailModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<Summary> getSummaryData() {
        return mRepositoryManager.obtainRetrofitService(VideoDetailService.class).getSummaryData();
    }

    @Override
    public Observable<Reply> getReplyData() {
        return mRepositoryManager.obtainRetrofitService(VideoDetailService.class).getReplyData();
    }
}