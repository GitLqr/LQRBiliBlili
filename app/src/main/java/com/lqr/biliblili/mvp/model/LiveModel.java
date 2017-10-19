package com.lqr.biliblili.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.lqr.biliblili.app.data.api.Api;
import com.lqr.biliblili.app.data.api.service.LiveService;
import com.lqr.biliblili.app.data.entity.Result;
import com.lqr.biliblili.app.data.entity.live.GetAllListData;
import com.lqr.biliblili.mvp.contract.LiveContract;

import javax.inject.Inject;

import io.reactivex.Observable;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;

@FragmentScope
public class LiveModel extends BaseModel implements LiveContract.Model {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public LiveModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        mGson = gson;
        mApplication = application;
        RetrofitUrlManager.getInstance().putDomain("live", Api.LIVE_BASE_URL);
    }

    public Observable<Result<GetAllListData>> getLiveList() {
        // TODO: 2017/10/19 加上数据缓存
        return mRepositoryManager.obtainRetrofitService(LiveService.class)
                .getLiveList();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}
