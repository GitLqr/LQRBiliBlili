package com.lqr.biliblili.mvp.ui.fragment.nav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.lqr.biliblili.R;
import com.lqr.biliblili.app.base.MySupportFragment;
import com.lqr.biliblili.mvp.ui.widget.TabEntity;

import java.util.ArrayList;

import butterknife.BindView;
import timber.log.Timber;

/**
 * @创建者 CSDN_LQR
 * @描述 首页
 */
public class NavHomeFragment extends MySupportFragment {

    @BindView(R.id.bottom_bar)
    CommonTabLayout mBottomBar;

    public static NavHomeFragment newInstance() {
        return new NavHomeFragment();
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_nav, container, false);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initBottomBar();
    }

    @Override
    public void setData(Object data) {
    }

    private void initBottomBar() {
        ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
        mTabEntities.add(new TabEntity(ArmsUtils.getString(_mActivity, R.string.bottom_bar_home), R.mipmap.ic_home_selected, R.mipmap.ic_home_unselected));
        mTabEntities.add(new TabEntity(ArmsUtils.getString(_mActivity, R.string.bottom_bar_category), R.mipmap.ic_category_selected, R.mipmap.ic_category_unselected));
        mTabEntities.add(new TabEntity(ArmsUtils.getString(_mActivity, R.string.bottom_bar_dynamic), R.mipmap.ic_dynamic_selected, R.mipmap.ic_dynamic_unselected));
        mTabEntities.add(new TabEntity(ArmsUtils.getString(_mActivity, R.string.bottom_bar_communicate), R.mipmap.ic_communicate_selected, R.mipmap.ic_communicate_unselected));
        mBottomBar.setTabData(mTabEntities);
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                Timber.e("position = " + position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }
}
