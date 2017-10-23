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

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.lqr.biliblili.R;
import com.lqr.biliblili.app.base.MySupportFragment;
import com.lqr.biliblili.di.component.DaggerRecommendComponent;
import com.lqr.biliblili.di.module.RecommendModule;
import com.lqr.biliblili.mvp.contract.RecommendContract;
import com.lqr.biliblili.mvp.presenter.RecommendPresenter;
import com.lqr.biliblili.mvp.ui.adapter.RecommendMultiItemAdapter;

import butterknife.BindView;

/**
 * @创建者 CSDN_LQR
 * @描述 推荐
 */
public class RecommendFragment extends MySupportFragment<RecommendPresenter> implements RecommendContract.View {

    private View mRootView;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    public static RecommendFragment newInstance() {
        return new RecommendFragment();
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        DaggerRecommendComponent
                .builder()
                .recommendModule(new RecommendModule(this))
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null)
            mRootView = inflater.inflate(R.layout.fragment_recommend_main_home, container, false);
        return mRootView;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initRefreshLayout();
    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.loadData(0, false, true);
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

    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeColors(ArmsUtils.getColor(_mActivity, R.color.colorPrimary));
        mRefreshLayout.setOnRefreshListener(() -> mPresenter.loadData(mPresenter.getIdx(true), true, false));
    }

    @Override
    public void setRecyclerAdapter(RecommendMultiItemAdapter adapter) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(_mActivity, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(adapter);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                // 上拉加载更多视图
                if (position == adapter.getData().size()) {
                    return 2;
                }
                return adapter.getData().get(position).getSpanSize();
            }
        });
    }

    @Override
    public void recyclerScrollToPosition(int position) {
        mRecyclerView.scrollToPosition(position);
    }
}
