package com.lqr.biliblili.mvp.ui.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jess.arms.utils.ArmsUtils;
import com.lqr.biliblili.R;
import com.lqr.biliblili.app.data.entity.video.Summary;
import com.lqr.biliblili.mvp.ui.fragment.video.ReplyFragment;
import com.lqr.biliblili.mvp.ui.fragment.video.SummaryFragment;

import java.util.ArrayList;

public class VideoDetailFragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTabTitles;
    private Context mContext;

    public VideoDetailFragmentAdapter(FragmentManager fm, Context context, Summary summary) {
        super(fm);
        mContext = context;
        String summaryStr = ArmsUtils.getString(mContext, R.string.v_detail_summary);
        String replyStr = mContext.getResources().getString(R.string.v_detail_evaluate, summary.getData().getStat() == null ? 0 : summary.getData().getStat().getReply());
        mTabTitles = new String[]{summaryStr, replyStr};
        mFragments.add(SummaryFragment.newInstance(summary));
        mFragments.add(ReplyFragment.newInstance());
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles[position];
    }
}
