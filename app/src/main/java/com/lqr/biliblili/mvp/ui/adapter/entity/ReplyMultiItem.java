package com.lqr.biliblili.mvp.ui.adapter.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.lqr.biliblili.app.data.entity.video.Reply;


public class ReplyMultiItem implements MultiItemEntity {

    public static final int ITEM = 1;
    public static final int TITLE_HOTS = 2;

    private int itemType;
    private Reply.DataBean.RepliesBean replies;

    public ReplyMultiItem(int itemType) {
        this.itemType = itemType;
    }

    public ReplyMultiItem(int itemType, Reply.DataBean.RepliesBean replies) {
        this.itemType = itemType;
        this.replies = replies;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public Reply.DataBean.RepliesBean getReplies() {
        return replies;
    }

    public void setReplies(Reply.DataBean.RepliesBean replies) {
        this.replies = replies;
    }
}
