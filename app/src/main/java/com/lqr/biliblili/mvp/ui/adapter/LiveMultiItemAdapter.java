package com.lqr.biliblili.mvp.ui.adapter;


import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.lqr.biliblili.R;
import com.lqr.biliblili.mvp.ui.adapter.entity.LiveMultiItem;

import java.util.List;

public class LiveMultiItemAdapter extends BaseMultiItemQuickAdapter<LiveMultiItem, BaseViewHolder> {

    private AppComponent mAppComponent;

    public LiveMultiItemAdapter(List<LiveMultiItem> data) {
        super(data);
        addItemType(LiveMultiItem.TITLE, R.layout.item_title_live);
        addItemType(LiveMultiItem.ITEM, R.layout.item_item_live);
        addItemType(LiveMultiItem.BANNER, R.layout.item_banner_live);
        addItemType(LiveMultiItem.BOTTOM, R.layout.item_bottom_live);
    }

    @Override
    protected void convert(BaseViewHolder helper, LiveMultiItem item) {
        if (mAppComponent == null) {
            mAppComponent = ArmsUtils.obtainAppComponentFromContext(mContext);
        }
        switch (item.getItemType()) {
            case LiveMultiItem.TITLE:
                mAppComponent
                        .imageLoader()
                        .loadImage(mContext, ImageConfigImpl
                                .builder()
                                .imageView(helper.getView(R.id.iv_title_icon_src))
                                .url(item.getTitleIconSrc())
                                .build());
                helper.setText(R.id.tv_title_name, item.getTitleName())
                        .setText(R.id.tv_title_count, item.getTitleCount() + "");
                break;
            case LiveMultiItem.ITEM:
                mAppComponent
                        .imageLoader()
                        .loadImage(mContext, ImageConfigImpl
                                .builder()
                                .imageView(helper.getView(R.id.iv_item_cover_src))
                                .url(item.getItemCoverSrc())
                                .build());
                int leftPadding = item.isOdd() ? ArmsUtils.dip2px(mContext, 8) : 0;
                int rightPadding = item.isOdd() ? 0 : ArmsUtils.dip2px(mContext, 8);
                helper.getView(R.id.fl_item).setPadding(leftPadding, 0, rightPadding, 0);
                helper.setText(R.id.tv_item_owner_name, item.getItemOwnerName())
                        .setText(R.id.tv_item_title, item.getItemTitle())
                        .setText(R.id.tv_item_sub_title, item.getItemSubTitle())
                        .setText(R.id.tv_item_online, item.getItemOnline() + "");
                break;
            case LiveMultiItem.BANNER:
                mAppComponent
                        .imageLoader()
                        .loadImage(mContext, ImageConfigImpl
                                .builder()
                                .imageView(helper.getView(R.id.iv_banner_cover_src))
                                .url(item.getBannerCoverSrc())
                                .build());
                helper.setText(R.id.tv_banner_title, item.getBannerTitle());
                break;
            case LiveMultiItem.BOTTOM:
                break;
        }
    }
}
