package com.lqr.biliblili.mvp.presenter;

import android.app.Application;
import android.content.Context;
import android.widget.ImageView;

import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.RxLifecycleUtils;
import com.lqr.biliblili.app.data.entity.live.GetAllListData;
import com.lqr.biliblili.mvp.contract.LiveContract;
import com.lqr.biliblili.mvp.ui.adapter.LiveMultiItemAdapter;
import com.lqr.biliblili.mvp.ui.adapter.entity.LiveMultiItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cn.bingoogolapple.bgabanner.BGABanner;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;

@FragmentScope
public class LivePresenter extends BasePresenter<LiveContract.Model, LiveContract.View> {

    private List<GetAllListData.BannerBean> mBanner;

    private RxErrorHandler mErrorHandler;
    private Application mApplication;
    private ImageLoader mImageLoader;
    private AppManager mAppManager;
    private LiveMultiItemAdapter mAdapter;

    @Inject
    public LivePresenter(LiveContract.Model model, LiveContract.View rootView, RxErrorHandler errorHandler, Application application, ImageLoader imageLoader, AppManager appManager) {
        super(model, rootView);
        mErrorHandler = errorHandler;
        mApplication = application;
        mImageLoader = imageLoader;
        mAppManager = appManager;
    }

    public void loadData() {
        mModel.getLiveList()
                .retryWhen(new RetryWithDelay(3, 2))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> {
                    mRootView.showLoading();
                })
                .doFinally(() -> {
                    mRootView.hideLoading();
                })
                .observeOn(Schedulers.io())
                .map(getAllListDataResult -> {
                    GetAllListData getAllListData = getAllListDataResult.getData();
                    List<LiveMultiItem> data = new ArrayList<>();
                    if (getAllListData != null) {
                        // 轮播
                        mBanner = getAllListData.getBanner();
                        // 推荐
                        data.addAll(mModel.parseRecommendData(getAllListData));
                        // 分类数据
                        data.addAll(mModel.parsePartitions(getAllListData));
                    }
                    return data;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new ErrorHandleSubscriber<List<LiveMultiItem>>(mErrorHandler) {
                    @Override
                    public void onNext(@NonNull List<LiveMultiItem> liveMultiItems) {
                        setBanner();
                        if (liveMultiItems != null)
                            setAdapter(liveMultiItems);
                    }
                });
    }

    public void setBanner() {
        BGABanner.Adapter<ImageView, String> adapter = new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                mImageLoader.loadImage(getContext(),
                        ImageConfigImpl
                                .builder()
                                .url(model)
                                .imageView(itemView)
                                .build());
            }
        };

        List<String> banners = new ArrayList<>();
        if (mBanner != null) {
            for (int i = 0; i < mBanner.size(); i++) {
                banners.add(mBanner.get(i).getImg());
            }
        }
        mRootView.setBanner(adapter, banners);
    }

    public void setAdapter(List<LiveMultiItem> data) {
        if (mAdapter == null) {
            mAdapter = new LiveMultiItemAdapter(data);
            mAdapter.setSpanSizeLookup((gridLayoutManager, position) -> data.get(position).getSpanSize());
            mRootView.setHeaderView(mAdapter);
            mRootView.setRecyclerAdapter(mAdapter);
            mRootView.setFooterView(mAdapter);
        } else {
            mAdapter.setNewData(data);
        }
    }

    private Context getContext() {
        return mAppManager.getTopActivity() == null ?
                mApplication : mAppManager.getTopActivity();
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
