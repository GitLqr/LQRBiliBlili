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
 * @描述 我的大会员
 */
public class NavMyVipFragment extends MySupportFragment {

    public static NavMyVipFragment newInstance() {
        return new NavMyVipFragment();
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_vip_nav, container, false);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setData(Object data) {

    }
}
