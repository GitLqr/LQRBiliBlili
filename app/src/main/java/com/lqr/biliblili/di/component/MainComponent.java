package com.lqr.biliblili.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.lqr.biliblili.di.module.MainModule;
import com.lqr.biliblili.mvp.ui.activity.MainActivity;

import dagger.Component;

@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}