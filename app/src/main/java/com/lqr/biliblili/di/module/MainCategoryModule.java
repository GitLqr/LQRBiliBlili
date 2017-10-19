package com.lqr.biliblili.di.module;

import com.jess.arms.di.scope.FragmentScope;
import com.lqr.biliblili.mvp.contract.MainCategoryContract;
import com.lqr.biliblili.mvp.model.MainCategoryModel;

import dagger.Module;
import dagger.Provides;

@Module
public class MainCategoryModule {
    private MainCategoryContract.View view;

    public MainCategoryModule(MainCategoryContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MainCategoryContract.View provideMainCategoryView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    MainCategoryContract.Model provideMainCategoryModel(MainCategoryModel model) {
        return model;
    }
}
