package com.lqr.biliblili.mvp.ui.fragment.main.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.lqr.biliblili.R;
import com.lqr.biliblili.app.base.MySupportFragment;
import com.lqr.biliblili.di.component.DaggerLiveComponent;
import com.lqr.biliblili.di.module.LiveModule;
import com.lqr.biliblili.mvp.contract.LiveContract;
import com.lqr.biliblili.mvp.presenter.LivePresenter;
import com.lqr.biliblili.mvp.ui.adapter.LiveMultiItemAdapter;
import com.lqr.biliblili.mvp.ui.widget.TabEntity;

import java.util.ArrayList;
import java.util.List;

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
    private View mFooterView;
    private Button mBtnAllLive;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    private View mRootView;

    public static LiveFragment newInstance() {
        return new LiveFragment();
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        DaggerLiveComponent.builder()
                .liveModule(new LiveModule(this))
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null)
            mRootView = inflater.inflate(R.layout.fragment_live_main_home, container, false);
        return mRootView;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initRefreshLayout();
        initHeaderView();
        initCtlCategory();
        initFooterView();
    }


    @Override
    public void setData(Object data) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.loadData(false);
    }

    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeColors(ArmsUtils.getColor(_mActivity, R.color.colorPrimary));
        mRefreshLayout.setOnRefreshListener(() -> mPresenter.loadData(true));
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
        tabEntities.add(new TabEntity(ArmsUtils.getString(_mActivity, R.string.live_home_game), R.mipmap.ic_live_home_game, R.mipmap.ic_live_home_game));
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

    private void initFooterView() {
        mFooterView = getLayoutInflater().inflate(R.layout.footer_live_main_home, null, false);
        mBtnAllLive = mFooterView.findViewById(R.id.btn_all_live);
    }

    @Override
    public void showLoading() {
        mRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        mRefreshLayout.setRefreshing(false);
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

    @Override
    public void setHeaderView(LiveMultiItemAdapter adapter) {
        adapter.addHeaderView(mHeaderView);
    }

    @Override
    public void setBanner(BGABanner.Adapter<ImageView, String> adapter, List<String> banners) {
        mBanner.setAdapter(adapter);
        mBanner.setData(banners, banners);
    }

    @Override
    public void setRecyclerAdapter(LiveMultiItemAdapter adapter) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(_mActivity, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void setFooterView(LiveMultiItemAdapter adapter) {
        adapter.addFooterView(mFooterView);
    }

    @Override
    public void onDestroy() {
        // 退出app后必须关闭轮播的自动轮播功能。
        mBanner.setAutoPlayAble(false);
        super.onDestroy();
    }
}
