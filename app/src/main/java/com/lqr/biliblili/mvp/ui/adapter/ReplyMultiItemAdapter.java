package com.lqr.biliblili.mvp.ui.adapter;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.lqr.biliblili.R;
import com.lqr.biliblili.app.data.entity.video.Reply;
import com.lqr.biliblili.mvp.ui.adapter.entity.ReplyMultiItem;

import java.util.List;

public class ReplyMultiItemAdapter extends BaseMultiItemQuickAdapter<ReplyMultiItem, BaseViewHolder> {

    private int[] mLevelIcons = new int[]{
            R.mipmap.ic_lv0_large
            , R.mipmap.ic_lv1_large
            , R.mipmap.ic_lv2_large
            , R.mipmap.ic_lv3_large
            , R.mipmap.ic_lv4_large
            , R.mipmap.ic_lv5_large
            , R.mipmap.ic_lv6_large
            , R.mipmap.ic_lv7_large
            , R.mipmap.ic_lv8_large
            , R.mipmap.ic_lv9_large
    };

    public ReplyMultiItemAdapter(List<ReplyMultiItem> data) {
        super(data);
        addItemType(ReplyMultiItem.ITEM, R.layout.item_item_video_detail);
        addItemType(ReplyMultiItem.TITLE_HOTS, R.layout.item_title_hots_video_detail);
    }

    @Override
    protected void convert(BaseViewHolder helper, ReplyMultiItem item) {
        switch (item.getItemType()) {
            case ReplyMultiItem.ITEM:
                Reply.DataBean.RepliesBean replies = item.getReplies();
                if (replies == null) {
                    return;
                }
                Reply.DataBean.RepliesBean.MemberBeanXX member = replies.getMember();
                ArmsUtils.obtainAppComponentFromContext(mContext).imageLoader().loadImage(mContext, ImageConfigImpl.builder().url(member.getAvatar()).imageView(helper.getView(R.id.iv_avatar)).transformation(new CircleCrop()).build());
                helper.setText(R.id.tv_uname, member.getUname())
                        .setImageResource(R.id.iv_level, mLevelIcons[member.getLevel_info().getCurrent_level()])
                        .setText(R.id.tv_floor, "#" + replies.getFloor())
                        .setText(R.id.tv_content, replies.getContent().getMessage())
                        .setText(R.id.tv_count, replies.getCount() + "")
                        .setVisible(R.id.line, getData().indexOf(item) + 1 < (getData().size()) ? getData().get(getData().indexOf(item) + 1).getItemType() == ReplyMultiItem.TITLE_HOTS ? false : true : true);

                LinearLayout llReplies = helper.getView(R.id.ll_replies);
                llReplies.removeAllViews();
                List<Reply.DataBean.RepliesBean> repliesReplies = replies.getReplies();
                if (repliesReplies != null && repliesReplies.size() > 0) {
                    llReplies.setVisibility(View.VISIBLE);
                    for (int i = 0; i < repliesReplies.size(); i++) {
                        Reply.DataBean.RepliesBean repliesBean = repliesReplies.get(i);
                        View repliesView = View.inflate(mContext, R.layout.item_item_replies_video_detail, null);
                        ((TextView) repliesView.findViewById(R.id.tv_replies_name)).setText(repliesBean.getMember().getUname());
                        ((TextView) repliesView.findViewById(R.id.tv_replies_content)).setText(repliesBean.getContent().getMessage());
                        llReplies.addView(repliesView);
                        if (i < repliesReplies.size() - 1) {
                            View line = new View(mContext);
                            line.setBackgroundColor(ArmsUtils.getColor(mContext, R.color.nav_bottom_line));
                            llReplies.addView(line);
                        }
                    }
                } else {
                    llReplies.setVisibility(View.GONE);
                }
                break;
            case ReplyMultiItem.TITLE_HOTS:
                break;
        }
    }
}
