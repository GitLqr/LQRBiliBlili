package com.lqr.biliblili.mvp.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jaeger.library.StatusBarUtil;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.DeviceUtils;
import com.lqr.biliblili.BuildConfig;
import com.lqr.biliblili.R;
import com.lqr.biliblili.app.base.MySupportActivity;
import com.lqr.biliblili.di.component.DaggerMainComponent;
import com.lqr.biliblili.di.module.MainModule;
import com.lqr.biliblili.mvp.contract.MainContract;
import com.lqr.biliblili.mvp.presenter.MainPresenter;
import com.lqr.biliblili.mvp.ui.widget.TabEntity;

import java.util.ArrayList;

import butterknife.BindView;
import me.yokeyword.fragmentation.Fragmentation;
import timber.log.Timber;

import static com.jess.arms.utils.Preconditions.checkNotNull;

/**
 * @创建者 CSDN_LQR
 * @描述 主界面（侧边栏 与 内容）
 */
@Route(path = "/app/main")
public class MainActivity extends MySupportActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.drawer)
    DrawerLayout mDrawer;
    @BindView(R.id.nav)
    NavigationView mNav;

    @BindView(R.id.fl_content)
    FrameLayout mFlContent;
    @BindView(R.id.bottom_bar)
    CommonTabLayout mBottomBar;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initFragmentation();
        initStatusBar();
        initNavigationView();
        initBottomBar();
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    private void initFragmentation() {


    }

    private void initStatusBar() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            StatusBarUtil.setTranslucentForDrawerLayout(this, mDrawer, 40);
        } else {
            StatusBarUtil.setColorNoTranslucent(this, ArmsUtils.getColor(this, R.color.colorPrimary));
        }
        mNav.getHeaderView(0).setPadding(0, DeviceUtils.getStatuBarHeight(this), 0, 0);
    }

    private void initNavigationView() {
        mNav.setBackgroundColor(ArmsUtils.getColor(this, R.color.nav_menu_bg));
        removeNavigationViewScrollbar(mNav);
    }

    private void initBottomBar() {
        ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
        mTabEntities.add(new TabEntity(ArmsUtils.getString(this, R.string.bottom_bar_home), R.mipmap.ic_home_selected, R.mipmap.ic_home_unselected));
        mTabEntities.add(new TabEntity(ArmsUtils.getString(this, R.string.bottom_bar_category), R.mipmap.ic_category_selected, R.mipmap.ic_category_unselected));
        mTabEntities.add(new TabEntity(ArmsUtils.getString(this, R.string.bottom_bar_dynamic), R.mipmap.ic_dynamic_selected, R.mipmap.ic_dynamic_unselected));
        mTabEntities.add(new TabEntity(ArmsUtils.getString(this, R.string.bottom_bar_communicate), R.mipmap.ic_communicate_selected, R.mipmap.ic_communicate_unselected));
        mBottomBar.setTabData(mTabEntities);
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                Timber.e("position = " + position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }


    private void removeNavigationViewScrollbar(NavigationView navigationView) {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }

}
