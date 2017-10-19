package com.lqr.biliblili.mvp.ui.fragment.main.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.lqr.biliblili.R;
import com.lqr.biliblili.app.base.MySupportFragment;
import com.lqr.biliblili.mvp.contract.LiveContract;
import com.lqr.biliblili.mvp.presenter.LivePresenter;
import com.lqr.biliblili.mvp.ui.widget.TabEntity;

import java.util.ArrayList;

import butterknife.BindView;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * @创建者 CSDN_LQR
 * @描述 直播
 */
public class LiveFragment extends MySupportFragment<LivePresenter> implements LiveContract.View {

    private View mHeaderView;
    private EditText mEtSearch;
    private BGABanner mBanner;
    private CommonTabLayout mCtlCategory;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    public static LiveFragment newInstance() {
        return new LiveFragment();
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live_main_home, container, false);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initHeaderView();
        initCtlCategory();
        initRecyclerView();
    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.loadData();
    }

    private void initHeaderView() {
        mHeaderView = getLayoutInflater().inflate(R.layout.header_live_main_home, null, false);
        mEtSearch = mHeaderView.findViewById(R.id.et_search);
        mBanner = mHeaderView.findViewById(R.id.banner);
        mCtlCategory = mHeaderView.findViewById(R.id.ctl_category);
    }

    private void initCtlCategory() {
        ArrayList<CustomTabEntity> tabEntities = new ArrayList<>();
        tabEntities.add(new TabEntity(ArmsUtils.getString(_mActivity, R.string.live_home_follow_anchor), R.mipmap.live_home_follow_anchor, R.mipmap.live_home_follow_anchor));
        tabEntities.add(new TabEntity(ArmsUtils.getString(_mActivity, R.string.live_home_entertainment), R.mipmap.ic_live_home_entertainment, R.mipmap.ic_live_home_entertainment));
        tabEntities.add(new TabEntity(ArmsUtils.getString(_mActivity, R.string.live_home_mobile_game), R.mipmap.ic_live_home_mobile_game, R.mipmap.ic_live_home_mobile_game));
        tabEntities.add(new TabEntity(ArmsUtils.getString(_mActivity, R.string.live_home_painting), R.mipmap.ic_live_home_painting, R.mipmap.ic_live_home_painting));
        mCtlCategory.setTabData(tabEntities);
        mCtlCategory.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    private void initRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(_mActivity, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public View getHeaderView() {
        return mHeaderView;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void launchActivity(Intent intent) {

    }

    @Override
    public void killMyself() {

    }
}
