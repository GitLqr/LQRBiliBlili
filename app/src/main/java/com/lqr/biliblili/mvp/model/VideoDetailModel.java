package com.lqr.biliblili.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.lqr.biliblili.app.data.api.service.VideoDetailService;
import com.lqr.biliblili.app.data.entity.video.PlayUrl;
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
    public Observable<Summary> getSummaryData(String aid) {
        return mRepositoryManager.obtainRetrofitService(VideoDetailService.class).getSummaryData(aid);
    }

    @Override
    public Observable<Reply> getReplyData(String oid, int pn, int ps) {
        return mRepositoryManager.obtainRetrofitService(VideoDetailService.class).getReplyData(oid, pn, ps);
    }

    @Override
    public Observable<PlayUrl> getPlayurl(String aid) {
        return mRepositoryManager.obtainRetrofitService(VideoDetailService.class).getPlayurl(aid);
    }
}