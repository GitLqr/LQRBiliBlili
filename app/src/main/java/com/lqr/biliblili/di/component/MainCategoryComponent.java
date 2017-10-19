package com.lqr.biliblili.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;
import com.lqr.biliblili.di.module.MainCategoryModule;
import com.lqr.biliblili.mvp.ui.fragment.main.MainCategoryFragment;

import dagger.Component;

@FragmentScope
@Component(modules = MainCategoryModule.class, dependencies = AppComponent.class)
public interface MainCategoryComponent {
    void inject(MainCategoryFragment fragment);
}
