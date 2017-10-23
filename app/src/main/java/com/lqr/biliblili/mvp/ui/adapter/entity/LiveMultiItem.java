package com.lqr.biliblili.mvp.ui.adapter.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class LiveMultiItem implements MultiItemEntity {

    public static final int TITLE = 1;
    public static final int ITEM = 2;
    public static final int BANNER = 3;
    public static final int BOTTOM = 4;

    private int itemType;
    private int spanSize;
    private boolean isOdd;// 用于判断ITEM部分是左是右

    // TITLE
    private String titleIconSrc;
    private String titleName;// recommend_data_partition_name
    private int titleCount;// recommend_data_partition_count

    // ITEM
    private String itemCoverSrc;
    private String itemOwnerName;
    private String itemTitle;
    private String itemSubTitle;// area_v2_name
    private int itemOnline;

    // BANNER
    private String bannerCoverSrc;
    private String bannerTitle;

    // BOTTOM
    //
    private void setSpanSzieWithItemType(int itemType) {
        switch (itemType) {
            case TITLE:
                spanSize = 2;
                break;
            case ITEM:
                spanSize = 1;
                break;
            case BANNER:
                spanSize = 2;
                break;
            case BOTTOM:
                spanSize = 2;
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

    public String getTitleIconSrc() {
        return titleIconSrc;
    }

    public void setTitleIconSrc(String titleIconSrc) {
        this.titleIconSrc = titleIconSrc;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public int getTitleCount() {
        return titleCount;
    }

    public void setTitleCount(int titleCount) {
        this.titleCount = titleCount;
    }

    public String getItemCoverSrc() {
        return itemCoverSrc;
    }

    public void setItemCoverSrc(String itemCoverSrc) {
        this.itemCoverSrc = itemCoverSrc;
    }

    public String getItemOwnerName() {
        return itemOwnerName;
    }

    public void setItemOwnerName(String itemOwnerName) {
        this.itemOwnerName = itemOwnerName;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemSubTitle() {
        return itemSubTitle;
    }

    public void setItemSubTitle(String itemSubTitle) {
        this.itemSubTitle = itemSubTitle;
    }

    public int getItemOnline() {
        return itemOnline;
    }

    public void setItemOnline(int itemOnline) {
        this.itemOnline = itemOnline;
    }

    public String getBannerCoverSrc() {
        return bannerCoverSrc;
    }

    public void setBannerCoverSrc(String bannerCoverSrc) {
        this.bannerCoverSrc = bannerCoverSrc;
    }

    public String getBannerTitle() {
        return bannerTitle;
    }

    public void setBannerTitle(String bannerTitle) {
        this.bannerTitle = bannerTitle;
    }
}
