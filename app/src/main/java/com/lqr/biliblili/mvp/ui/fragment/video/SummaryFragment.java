package com.lqr.biliblili.mvp.ui.fragment.video;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.lqr.biliblili.R;
import com.lqr.biliblili.app.base.MySupportFragment;
import com.lqr.biliblili.app.data.entity.video.Summary;
import com.lqr.biliblili.app.utils.TextHandleUtil;
import com.lqr.biliblili.mvp.ui.adapter.MyTagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

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

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_view)
    TextView mTvView;
    @BindView(R.id.tv_danmaku)
    TextView mTvDanmaku;
    @BindView(R.id.tv_desc)
    TextView mTvDesc;

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
            mRootView = inflater.inflate(R.layout.fragment_summary, container, false);
        }
        return mRootView;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if (summary == null || summary.getData() == null)
            return;
        Summary.DataBean data = summary.getData();
        mTvTitle.setText(data.getTitle());
        mTvView.setText(data.getStat() == null ? "0" : TextHandleUtil.handleCount2TenThousand(data.getStat().getView()));
        mTvDanmaku.setText(data.getStat() == null ? "0" : TextHandleUtil.handleCount2TenThousand(data.getStat().getDanmaku()));
        mTvDesc.setText(data.getDesc());

        mTvShare.setText(data.getStat() == null ? "0" : TextHandleUtil.handleCount2TenThousand(data.getStat().getShare()));
        mTvCoin.setText(data.getStat() == null ? "0" : TextHandleUtil.handleCount2TenThousand(data.getStat().getCoin()));
        mTvCollect.setText(data.getStat() == null ? "0" : TextHandleUtil.handleCount2TenThousand(data.getStat().getFavorite()));

        Summary.DataBean.OwnerBean owner = data.getOwner();
        if (owner != null) {
            ArmsUtils.obtainAppComponentFromContext(_mActivity).imageLoader().loadImage(_mActivity, ImageConfigImpl.builder().url(owner.getFace()).imageView(mIvHeader).transformation(new CircleCrop()).build());
            mTvUpperName.setText(owner.getName());
        }
        Summary.DataBean.OwnerExtBean owner_ext = data.getOwner_ext();
        if (owner_ext != null) {
            mTvFans.setText(TextHandleUtil.handleCount2TenThousand(owner_ext.getFans()) + "人关注");
        }

        List<Summary.DataBean.TagBean> tags = data.getTag();
        if (tags != null) {
            mTagFlow.setAdapter(new MyTagAdapter(tags));
        }

        List<Summary.DataBean.RelatesBean> relates = data.getRelates();
        if (relates != null) {
//            mRvRelates.setLayoutManager(new LinearLayoutManager(_mActivity));
//            mRvRelates.setAdapter(new BaseQuickAdapter<Summary.DataBean.RelatesBean, BaseViewHolder>(relates) {
//                @Override
//                protected void convert(BaseViewHolder helper, Summary.DataBean.RelatesBean item) {
//
//                }
//            });
        }
    }

    @Override
    public void setData(Object data) {

    }
}
