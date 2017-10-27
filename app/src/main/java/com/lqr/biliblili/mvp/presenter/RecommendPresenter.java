package com.lqr.biliblili.mvp.presenter;

import android.app.Application;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.RxLifecycleUtils;
import com.lqr.biliblili.mvp.contract.RecommendContract;
import com.lqr.biliblili.mvp.ui.adapter.RecommendMultiItemAdapter;
import com.lqr.biliblili.mvp.ui.adapter.entity.RecommendMultiItem;
import com.lqr.biliblili.mvp.ui.widget.CustomLoadMoreView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;

@FragmentScope
public class RecommendPresenter extends BasePresenter<RecommendContract.Model, RecommendContract.View> implements BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemClickListener {

    private RxErrorHandler mErrorHandler;
    private Application mApplication;
    private ImageLoader mImageLoader;
    private AppManager mAppManager;
    private RecommendMultiItemAdapter mAdapter;

    @Inject
    public RecommendPresenter(RecommendContract.Model model, RecommendContract.View rootView, RxErrorHandler errorHandler, Application application, ImageLoader imageLoader, AppManager appManager) {
        super(model, rootView);
        mErrorHandler = errorHandler;
        mApplication = application;
        mImageLoader = imageLoader;
        mAppManager = appManager;
    }

    public void loadData(int idx, boolean refresh, boolean clearCache) {
        mModel.getRecommendIndexData(idx, refresh, clearCache)
                .retryWhen(new RetryWithDelay(3, 2))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> {
                    if (refresh || clearCache) mRootView.showLoading();
                })
                .doFinally(() -> mRootView.hideLoading())
                .observeOn(Schedulers.io())
                .map(indexData -> mModel.parseIndexData(indexData))
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new ErrorHandleSubscriber<List<RecommendMultiItem>>(mErrorHandler) {
                    @Override
                    public void onNext(@NonNull List<RecommendMultiItem> recommendMultiItems) {
                        if (recommendMultiItems != null) {
                            setAdapter(recommendMultiItems, refresh);
                        }
                    }
                });
    }

    public void setAdapter(List<RecommendMultiItem> recommendMultiItems, boolean refresh) {
        if (mAdapter == null) {
            mAdapter = new RecommendMultiItemAdapter(recommendMultiItems);
            mRootView.setRecyclerAdapter(mAdapter);
            mAdapter.setEnableLoadMore(true);
            mAdapter.setPreLoadNumber(2);
            mAdapter.setLoadMoreView(new CustomLoadMoreView());
            mAdapter.setOnLoadMoreListener(this);
            mAdapter.setOnItemClickListener(this);
        } else {
            if (refresh) {
                removePreRefreshItem();
                addPreRefreshItem();
                mAdapter.addData(0, recommendMultiItems);
                mRootView.recyclerScrollToPosition(0);
            } else {
                mAdapter.addData(recommendMultiItems);
                mAdapter.loadMoreComplete();
            }
        }
    }

    public int getIdx(boolean refresh) {
        List<RecommendMultiItem> data = mAdapter.getData();
        if (data == null || data.size() == 0) {
            return 0;
        }
        int index = refresh ? 0 : data.size() - 1;
        return data.get(index).getIndexDataBean() == null ? 0 : data.get(index).getIndexDataBean().getIdx();
    }

    public void removePreRefreshItem() {
        List<RecommendMultiItem> data = mAdapter.getData();
        if (data == null || data.size() == 0) {
            return;
        }
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getItemType() == RecommendMultiItem.PRE_HERE_CLICK_TO_REFRESH) {
                data.remove(i);
                break;
            }
        }
    }

    public void addPreRefreshItem() {
        RecommendMultiItem item = new RecommendMultiItem();
        item.setItemType(RecommendMultiItem.PRE_HERE_CLICK_TO_REFRESH);
        mAdapter.addData(0, item);
    }

    @Override
    public void onLoadMoreRequested() {
        loadData(getIdx(false), false, false);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        List<RecommendMultiItem> data = adapter.getData();
        if (data != null) {
            RecommendMultiItem item = data.get(position);
            if (RecommendMultiItem.isVideoItem(item.getItemType())) {
                ARouter.getInstance().build("/video/detail").withString("aid", item.getIndexDataBean().getParam()).navigation();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }
}
