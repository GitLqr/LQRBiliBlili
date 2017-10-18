package com.lqr.biliblili.mvp.ui.fragment.nav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jess.arms.di.component.AppComponent;
import com.lqr.biliblili.R;
import com.lqr.biliblili.app.base.MySupportFragment;

/**
 * @创建者 CSDN_LQR
 * @描述 免流量服务
 */
public class NavFreeFowFragment extends MySupportFragment {

    public static NavFreeFowFragment newInstance() {
        return new NavFreeFowFragment();
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_free_fow_nav, container, false);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setData(Object data) {

    }
}
