package com.lqr.biliblili.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;
import com.lqr.biliblili.di.module.LiveModule;
import com.lqr.biliblili.mvp.ui.fragment.main.home.LiveFragment;

import dagger.Component;

@FragmentScope
@Component(modules = LiveModule.class, dependencies = AppComponent.class)
public interface LiveComponent {
    void inject(LiveFragment fragment);
}
