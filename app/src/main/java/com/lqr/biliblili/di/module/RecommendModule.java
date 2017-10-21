package com.lqr.biliblili.di.module;

import com.jess.arms.di.scope.FragmentScope;
import com.lqr.biliblili.mvp.contract.RecommendContract;
import com.lqr.biliblili.mvp.model.RecommendModel;

import dagger.Module;
import dagger.Provides;

@Module
public class RecommendModule {

    private RecommendContract.View view;

    public RecommendModule(RecommendContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    public RecommendContract.View provideView() {
        return view;
    }

    @FragmentScope
    @Provides
    public RecommendContract.Model provideModel(RecommendModel model) {
        return model;
    }
}
