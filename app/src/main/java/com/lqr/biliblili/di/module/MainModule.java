package com.lqr.biliblili.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.lqr.biliblili.mvp.contract.MainContract;
import com.lqr.biliblili.mvp.model.MainModel;

import dagger.Module;
import dagger.Provides;


@Module
public class MainModule {
    private MainContract.View view;

    /**
     * 构建MainModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MainContract.View provideMainView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MainContract.Model provideMainModel(MainModel model) {
        return model;
    }
}