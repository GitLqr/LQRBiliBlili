package com.lqr.biliblili.mvp.ui.fragment.video;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.lqr.biliblili.R;
import com.lqr.biliblili.app.base.MySupportFragment;
import com.lqr.biliblili.app.data.entity.video.Summary;
import com.lqr.biliblili.app.utils.TextHandleUtil;
import com.lqr.biliblili.mvp.ui.adapter.MyTagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

import static com.lqr.biliblili.R.id.rv_relates;
import static com.lqr.biliblili.R.id.tv_upper_name;

/**
 * @创建者 CSDN_LQR
 * @描述 简介
 */
public class SummaryFragment extends MySupportFragment {

    private Summary summary;
    private View mRootView;
    private List<Summary.DataBean.TagBean> tags;
    private List<Summary.DataBean.TagBean> newTags;
    private MyTagAdapter adapter = null;
    private boolean isTagShrink = false;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_view)
    TextView mTvView;
    @BindView(R.id.tv_danmaku)
    TextView mTvDanmaku;
    @BindView(R.id.tv_desc)
    TextView mTvDesc;
    @BindView(R.id.iv_desc_shrink)
    ImageView mIvDescShrink;

    @BindView(R.id.tv_share)
    TextView mTvShare;
    @BindView(R.id.tv_coin)
    TextView mTvCoin;
    @BindView(R.id.tv_collect)
    TextView mTvCollect;
    @BindView(R.id.tv_download)
    TextView mTvDownload;

    @BindView(R.id.iv_header)
    ImageView mIvHeader;
    @BindView(tv_upper_name)
    TextView mTvUpperName;
    @BindView(R.id.tv_fans)
    TextView mTvFans;

    @BindView(R.id.tag_flow)
    TagFlowLayout mTagFlow;
    @BindView(R.id.iv_tag_shrink)
    ImageView mIvTagShrink;
    @BindView(rv_relates)
    RecyclerView mRvRelates;

    private SummaryFragment(Summary summary) {
        this.summary = summary;
    }

    public static SummaryFragment newInstance(Summary summary) {
        return new SummaryFragment(summary);
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment_summary_video_detail, container, false);
        }
        return mRootView;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if (summary == null || summary.getData() == null)
            return;
        Summary.DataBean data = summary.getData();
        initVideoSummary(data);
        initUpperInfo(data);
        initOtherInfo(data);
    }

    @Override
    public void setData(Object data) {

    }

    private void initVideoSummary(Summary.DataBean data) {
        mTvTitle.setText(data.getTitle());
        mTvView.setText(data.getStat() == null ? "0" : TextHandleUtil.handleCount2TenThousand(data.getStat().getView()));
        mTvDanmaku.setText(data.getStat() == null ? "0" : TextHandleUtil.handleCount2TenThousand(data.getStat().getDanmaku()));
        mTvDesc.setText(data.getDesc());
        mTvShare.setText(data.getStat() == null ? "0" : TextHandleUtil.handleCount2TenThousand(data.getStat().getShare()));
        mTvCoin.setText(data.getStat() == null ? "0" : TextHandleUtil.handleCount2TenThousand(data.getStat().getCoin()));
        mTvCollect.setText(data.getStat() == null ? "0" : TextHandleUtil.handleCount2TenThousand(data.getStat().getFavorite()));
        mIvDescShrink.setOnClickListener(v -> {
            if (mTvDesc.getMaxLines() == 1) {
                mTvDesc.setMaxLines(10);
                mIvDescShrink.setImageResource(R.mipmap.ic_video_detail_arrow_up);
            } else {
                mTvDesc.setMaxLines(1);
                mIvDescShrink.setImageResource(R.mipmap.ic_video_detail_arrow_down);
            }
        });
    }

    private void initUpperInfo(Summary.DataBean data) {
        Summary.DataBean.OwnerBean owner = data.getOwner();
        if (owner != null) {
            ArmsUtils.obtainAppComponentFromContext(_mActivity).imageLoader().loadImage(_mActivity, ImageConfigImpl.builder().url(owner.getFace()).imageView(mIvHeader).transformation(new CircleCrop()).build());
            mTvUpperName.setText(owner.getName());
        }
        Summary.DataBean.OwnerExtBean owner_ext = data.getOwner_ext();
        if (owner_ext != null) {
            mTvFans.setText(TextHandleUtil.handleCount2TenThousand(owner_ext.getFans()) + "人关注");
        }

        // 得到视频相关tag
        tags = data.getTag();
        if (tags != null) {
            // 如果tag数量超过4个，就缩减
            if (tags.size() > 4) {
                newTags = new ArrayList<>();
                Collections.sort(tags);
                for (int i = 0; i < 4; i++) {
                    newTags.add(tags.get(i));
                }
                adapter = new MyTagAdapter(newTags);
                isTagShrink = true;
            } else {
                adapter = new MyTagAdapter(tags);
            }
            mTagFlow.setAdapter(adapter);

            // 箭头的点击事件
            changeArrowDown();
            mIvTagShrink.setOnClickListener(v -> {
                if (isTagShrink) {
                    // 切换成多的
                    if (newTags != null) {
                        adapter = new MyTagAdapter(tags);
                    }
                    changeArrowUp();
                } else {
                    // 切换成少的
                    if (newTags != null) {
                        adapter = new MyTagAdapter(newTags);
                    }
                    changeArrowDown();
                }
                isTagShrink = !isTagShrink;
                if (newTags != null) {
                    mTagFlow.setAdapter(adapter);
                }
            });
        }
    }

    private void changeArrowDown() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mIvTagShrink.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_TOP, R.id.tag_flow);
        mIvTagShrink.setLayoutParams(params);
        mIvTagShrink.setImageResource(R.mipmap.ic_video_detail_arrow_down);
    }

    private void changeArrowUp() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mIvTagShrink.getLayoutParams();
        params.removeRule(RelativeLayout.ALIGN_TOP);
        mIvTagShrink.setLayoutParams(params);
        mIvTagShrink.setImageResource(R.mipmap.ic_video_detail_arrow_up);
    }

    private void initOtherInfo(Summary.DataBean data) {
        List<Summary.DataBean.RelatesBean> relates = data.getRelates();
        if (relates != null) {
            mRvRelates.setLayoutManager(new LinearLayoutManager(_mActivity));
            mRvRelates.setAdapter(new BaseQuickAdapter<Summary.DataBean.RelatesBean, BaseViewHolder>(R.layout.item_relate_video_detail, relates) {
                @Override
                protected void convert(BaseViewHolder helper, Summary.DataBean.RelatesBean item) {
                    ArmsUtils.obtainAppComponentFromContext(_mActivity).imageLoader().loadImage(_mActivity, ImageConfigImpl.builder().url(item.getPic()).imageView(helper.getView(R.id.iv_pic)).build());
                    helper.setText(R.id.tv_title, item.getTitle())
                            .setText(R.id.tv_owner_name, item.getOwner() == null ? "" : item.getOwner().getName())
                            .setText(R.id.tv_view, item.getStat() == null ? "0" : TextHandleUtil.handleCount2TenThousand(item.getStat().getView()))
                            .setText(R.id.tv_danmaku, item.getStat() == null ? "0" : TextHandleUtil.handleCount2TenThousand(item.getStat().getDanmaku()));
                }
            });
        }
    }
}
