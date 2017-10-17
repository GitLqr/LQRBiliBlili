package com.lqr.biliblili.mvp.ui.activity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;

/**
 * @创建者 CSDN_LQR
 * @描述 主题界面
 */
@Route(path = "/app/theme")
public class ThemeActivity extends BaseActivity {

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return 0;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }
}
