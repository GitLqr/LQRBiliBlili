package com.lqr.biliblili.di.module;

import com.jess.arms.di.scope.FragmentScope;
import com.lqr.biliblili.mvp.contract.LiveContract;
import com.lqr.biliblili.mvp.model.LiveModel;

import dagger.Module;
import dagger.Provides;

@Module
public class LiveModule {

    private LiveContract.View view;

    public LiveModule(LiveContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    public LiveContract.View provideView() {
        return view;
    }

    @FragmentScope
    @Provides
    public LiveContract.Model provideModel(LiveModel model) {
        return model;
    }
}
