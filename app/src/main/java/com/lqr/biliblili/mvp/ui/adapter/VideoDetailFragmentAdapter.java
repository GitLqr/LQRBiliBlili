package com.lqr.biliblili.mvp.ui.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lqr.biliblili.mvp.ui.fragment.video.EvaluateFragment;
import com.lqr.biliblili.mvp.ui.fragment.video.SummaryFragment;

import java.util.ArrayList;

public class VideoDetailFragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTabTitles;
    private Context mContext;

    public VideoDetailFragmentAdapter(FragmentManager fm, String[] tabTitles) {
        super(fm);
        mTabTitles = tabTitles;
        mFragments.add(SummaryFragment.newInstance());
        mFragments.add(EvaluateFragment.newInstance());
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
