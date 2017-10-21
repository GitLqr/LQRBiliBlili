package com.lqr.biliblili.mvp.ui.adapter.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.lqr.biliblili.app.data.entity.recommend.IndexData;


public class RecommendMultiItem implements MultiItemEntity {

    public static final int BANNER = 1;// goto：banner
    public static final int ITEM = 2;// goto：av(还有一种带黄色标记的，多了一个rcmd_reason)、bangumi、login、ad_web_s、article_s
    public static final int STREAMER = 3;// goto：topic、special

    public static final int TAG = 4;// goto：tag（类似一些游戏标签之类的，不做）
    public static final int RANK = 5;// goto：rank（全站排行榜，不做）
    public static final int CONVERGE = 6;// goto：converge（小埋广告，不做）

    private int itemType;
    private int spanSize;
    private boolean isOdd;// 用于判断ITEM部分是左是右

    private IndexData indexData;

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    public boolean isOdd() {
        return isOdd;
    }

    public void setOdd(boolean odd) {
        isOdd = odd;
    }

    public IndexData getIndexData() {
        return indexData;
    }

    public void setIndexData(IndexData indexData) {
        this.indexData = indexData;
    }
}
