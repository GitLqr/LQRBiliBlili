package com.lqr.biliblili.mvp.model;


import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.lqr.biliblili.mvp.contract.MainCategoryContract;

import javax.inject.Inject;

@FragmentScope
public class MainCategoryModel extends BaseModel implements MainCategoryContract.Model {

    private Gson mGson;
    private Application mApplication;

    @Inject
    public MainCategoryModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        mGson = gson;
        mApplication = application;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}
