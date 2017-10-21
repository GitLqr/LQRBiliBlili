package com.lqr.biliblili.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;
import com.lqr.biliblili.di.module.RecommendModule;
import com.lqr.biliblili.mvp.ui.fragment.main.home.RecommendFragment;

import dagger.Component;

@FragmentScope
@Component(modules = RecommendModule.class, dependencies = AppComponent.class)
public interface RecommendComponent {
    void inject(RecommendFragment fragment);
}
