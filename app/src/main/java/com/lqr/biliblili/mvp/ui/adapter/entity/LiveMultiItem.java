package com.lqr.biliblili.mvp.ui.adapter.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;


public class LiveMultiItem implements MultiItemEntity {
    private static final int title = 1;
    private static final int item = 2;
    private static final int cover = 3;
    private static final int bottom = 4;

    private int itemType;
    private int spanSize;

    @Override
    public int getItemType() {
        return itemType;
    }
}
