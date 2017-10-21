package com.lqr.biliblili.mvp.ui.fragment.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.flyco.tablayout.SlidingTabLayout;
import com.jess.arms.di.component.AppComponent;
import com.lqr.biliblili.R;
import com.lqr.biliblili.app.base.MySupportFragment;
import com.lqr.biliblili.app.tag.MainTag;
import com.lqr.biliblili.mvp.ui.adapter.MainHomeFragmentAdapter;

import org.simple.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @创建者 CSDN_LQR
 * @描述 首页
 */
public class MainHomeFragment extends MySupportFragment {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tablayout)
    SlidingTabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    @OnClick(R.id.ll_toolbar)
    void openDrawer() {
        EventBus.getDefault().post(new MainTag(), "openDrawer");
    }

    public static MainHomeFragment newInstance() {
        return new MainHomeFragment();
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 要让Fragment中的onCreateOptionsMenu()被回调，必须调用setHasOptionsMenu(true);
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_home_main, container, false);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initTabLayoutAndViewPager();
    }


    @Override
    public void setData(Object data) {

    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        // 必须让Fragment中的Toolbar成为Activity的ActionBar，否则setHasOptionsMenu(true)就没有意义了。
        ((AppCompatActivity) _mActivity).setSupportActionBar(mToolbar);
        ((AppCompatActivity) _mActivity).getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // 必须调用menu.clear();清空菜单栏，否则可能会出现Activity中的menu与Fragment中的menu重叠。
        menu.clear();
        inflater.inflate(R.menu.main_home_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_active:
                ARouter.getInstance().build("/app/web").withString("url", "http://www.qq.com").navigation();
                break;
            case R.id.main_game:
                break;
            case R.id.main_download:
                break;
            case R.id.main_search:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initTabLayoutAndViewPager() {
        mViewPager.setAdapter(new MainHomeFragmentAdapter(getChildFragmentManager(), _mActivity));
        mViewPager.setCurrentItem(1);
        mTabLayout.setViewPager(mViewPager);
    }
}
