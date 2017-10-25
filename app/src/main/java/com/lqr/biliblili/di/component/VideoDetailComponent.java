package com.lqr.biliblili.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.lqr.biliblili.di.module.VideoDetailModule;
import com.lqr.biliblili.mvp.ui.activity.VideoDetailActivity;

import dagger.Component;

@ActivityScope
@Component(modules = VideoDetailModule.class, dependencies = AppComponent.class)
public interface VideoDetailComponent {
    void inject(VideoDetailActivity activity);
}