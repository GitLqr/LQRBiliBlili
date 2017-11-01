package com.lqr.biliblili.mvp.ui.adapter.entity;

import android.text.TextUtils;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.lqr.biliblili.app.data.entity.recommend.IndexData;


public class RecommendMultiItem implements MultiItemEntity {

    public static final int BANNER = 1;// goto：banner
    public static final int STREAMER = 2;// goto：topic、special
    public static final int ITEM_AV = 3;// goto：av
    public static final int ITEM_AV_RCMD_REASON = 4;// goto：av(带黄色标记的，多了一个rcmd_reason)
    public static final int ITEM_BANGUMI = 5;// goto：bangumi
    public static final int ITEM_LOGIN = 6;// goto：login
    public static final int ITEM_AD_WEB_S = 7;// goto：ad_web_s
    public static final int ITEM_ARTICLE_S = 8;// goto：article_s
    public static final int PRE_HERE_CLICK_TO_REFRESH = 9;// 刚刚看到这里，点击刷新

//    public static final int TAG = 4;// goto：tag（类似一些游戏标签之类的，不做）
//    public static final int RANK = 5;// goto：rank（全站排行榜，不做）
//    public static final int CONVERGE = 6;// goto：converge（小埋广告，不做）

    private int itemType;
    private int spanSize;
    private boolean isOdd;// 用于判断ITEM部分是左是右

    private IndexData.DataBean indexDataBean;

    public static boolean isVideoItem(int itemType) {
        if (itemType == ITEM_AV || ITEM_AV == ITEM_AV_RCMD_REASON) {
            return true;
        }
        return false;
    }

    public static boolean isWeNeed(String gotoStr) {
        if (TextUtils.isEmpty(gotoStr))
            return false;
        if ("banner".equals(gotoStr)
                || "topic".equals(gotoStr)
                || "special".equals(gotoStr)
                || "av".equals(gotoStr)
                || "bangumi".equals(gotoStr)
                || "login".equals(gotoStr)
                || "ad_web_s".equals(gotoStr)
                || "article_s".equals(gotoStr)
                ) {
            return true;
        }
        return false;
    }

    public static boolean isItemData(String gotoStr) {
        if (TextUtils.isEmpty(gotoStr))
            return false;
        if ("av".equals(gotoStr)
                || "bangumi".equals(gotoStr)
                || "login".equals(gotoStr)
                || "ad_web_s".equals(gotoStr)
                || "article_s".equals(gotoStr)
                ) {
            return true;
        }
        return false;
    }

    public void setItemTypeWithGoto(String gotoStr) {
        setItemTypeWithGoto(gotoStr, false);
    }

    public void setItemTypeWithGoto(String gotoStr, boolean hasRcmdReason) {
        switch (gotoStr) {
            case "banner":
                itemType = BANNER;
                break;
            case "av":
                itemType = hasRcmdReason ? ITEM_AV : ITEM_AV_RCMD_REASON;
                break;
            case "bangumi":
                itemType = ITEM_BANGUMI;
                break;
            case "login":
                itemType = ITEM_LOGIN;
                break;
            case "ad_web_s":
                itemType = ITEM_AD_WEB_S;
                break;
            case "article_s":
                itemType = ITEM_ARTICLE_S;
                break;
            case "topic":
                itemType = STREAMER;
                break;
            case "special":
                itemType = STREAMER;
                break;
        }
        setSpanSzieWithItemType(itemType);
    }

    private void setSpanSzieWithItemType(int itemType) {
        switch (itemType) {
            case BANNER:
                spanSize = 2;
                break;
            case STREAMER:
                spanSize = 2;
                break;
            case PRE_HERE_CLICK_TO_REFRESH:
                spanSize = 2;
                break;
            default:
                spanSize = 1;
                break;
        }
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
        setSpanSzieWithItemType(itemType);
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

    public IndexData.DataBean getIndexDataBean() {
        return indexDataBean;
    }

    public void setIndexDataBean(IndexData.DataBean indexDataBean) {
        this.indexDataBean = indexDataBean;
    }
}
