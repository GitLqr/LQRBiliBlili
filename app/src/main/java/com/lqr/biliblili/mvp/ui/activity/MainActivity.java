package com.lqr.biliblili.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.flyco.systembar.SystemBarHelper;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.lqr.biliblili.R;
import com.lqr.biliblili.app.base.MySupportActivity;
import com.lqr.biliblili.app.tag.MainTag;
import com.lqr.biliblili.di.component.DaggerMainComponent;
import com.lqr.biliblili.di.module.MainModule;
import com.lqr.biliblili.mvp.contract.MainContract;
import com.lqr.biliblili.mvp.presenter.MainPresenter;
import com.lqr.biliblili.mvp.ui.fragment.nav.NavFreeFowFragment;
import com.lqr.biliblili.mvp.ui.fragment.nav.NavHistoryFragment;
import com.lqr.biliblili.mvp.ui.fragment.nav.NavHomeFragment;
import com.lqr.biliblili.mvp.ui.fragment.nav.NavLiveCenterFragment;
import com.lqr.biliblili.mvp.ui.fragment.nav.NavLookLaterFragment;
import com.lqr.biliblili.mvp.ui.fragment.nav.NavMyCollectFragment;
import com.lqr.biliblili.mvp.ui.fragment.nav.NavMyFollowFragment;
import com.lqr.biliblili.mvp.ui.fragment.nav.NavMyVipFragment;
import com.lqr.biliblili.mvp.ui.fragment.nav.NavOfflineCacheFragment;
import com.lqr.biliblili.mvp.ui.fragment.nav.NavVipOrderFragment;

import org.simple.eventbus.Subscriber;

import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportFragment;

import static com.jess.arms.utils.Preconditions.checkNotNull;

/**
 * @创建者 CSDN_LQR
 * @描述 主界面（侧边栏 与 内容）
 */
@Route(path = "/app/main")
public class MainActivity extends MySupportActivity<MainPresenter> implements MainContract.View, NavigationView.OnNavigationItemSelectedListener {

    private long mPreTime = 0;

    @BindView(R.id.ll_root)
    LinearLayout mLlRoot;
    @BindView(R.id.drawer)
    DrawerLayout mDrawer;
    @BindView(R.id.nav)
    NavigationView mNav;

    @OnClick(R.id.rl_setting)
    void toSetting() {
        ARouter.getInstance().build("/app/setting").navigation();
    }

    @OnClick(R.id.rl_theme)
    void toTheme() {
        ARouter.getInstance().build("/app/theme").navigation();
    }

    @OnClick(R.id.rl_change_skin)
    void changeSkin() {
        // TODO: 2017/10/18 切换夜间/白天皮肤
    }

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
        initStatusBar();
        initFragmentation();
        initNavigationView();
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
        NavHomeFragment homeFragment = findFragment(NavHomeFragment.class);
        if (homeFragment == null) {
            loadRootFragment(R.id.fl_content, NavHomeFragment.newInstance());
        }
    }

    private void initStatusBar() {
        SystemBarHelper.tintStatusBarForDrawer(this, mDrawer, ArmsUtils.getColor(this, R.color.colorPrimary));
        SystemBarHelper.setPadding(this, mNav.getHeaderView(0));
        SystemBarHelper.setPadding(this, mLlRoot);
    }

    private void initNavigationView() {
        mNav.setBackgroundColor(ArmsUtils.getColor(this, R.color.nav_menu_bg));
        removeNavigationViewScrollbar(mNav);
        mNav.setCheckedItem(R.id.nav_home);
        mNav.setNavigationItemSelectedListener(this);
    }


    private void removeNavigationViewScrollbar(NavigationView navigationView) {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        closeDrawer();
        switch (item.getItemId()) {
            case R.id.nav_home:
                NavHomeFragment homeFragment = findFragment(NavHomeFragment.class);
                if (homeFragment == null) {
                    start(NavHomeFragment.newInstance(), SupportFragment.SINGLETASK);
                } else {
                    popTo(NavHomeFragment.class, false);
                }
                break;
            case R.id.nav_history:
                NavHistoryFragment historyFragment = findFragment(NavHistoryFragment.class);
                if (historyFragment == null) {
                    popTo(NavHomeFragment.class, false, new TimerTask() {
                        @Override
                        public void run() {
                            start(NavHistoryFragment.newInstance());
                        }
                    });
                } else {
                    popTo(NavHistoryFragment.class, false);
                }
                break;
            case R.id.nav_offline_cache:
                NavOfflineCacheFragment offlineCacheFragment = findFragment(NavOfflineCacheFragment.class);
                if (offlineCacheFragment == null) {
                    popTo(NavHomeFragment.class, false, new TimerTask() {
                        @Override
                        public void run() {
                            start(NavOfflineCacheFragment.newInstance());
                        }
                    });
                } else {
                    popTo(NavOfflineCacheFragment.class, false);
                }
                break;
            case R.id.nav_my_collect:
                NavMyCollectFragment myCollectFragment = findFragment(NavMyCollectFragment.class);
                if (myCollectFragment == null) {
                    popTo(NavHomeFragment.class, false, new TimerTask() {
                        @Override
                        public void run() {
                            start(NavMyCollectFragment.newInstance());
                        }
                    });
                } else {
                    popTo(NavMyCollectFragment.class, false);
                }
                break;
            case R.id.nav_my_follow:
                NavMyFollowFragment myFollowFragment = findFragment(NavMyFollowFragment.class);
                if (myFollowFragment == null) {
                    popTo(NavHomeFragment.class, false, new TimerTask() {
                        @Override
                        public void run() {
                            start(NavMyFollowFragment.newInstance());
                        }
                    });
                } else {
                    popTo(NavMyFollowFragment.class, false);
                }
                break;
            case R.id.nav_look_later:
                NavLookLaterFragment lookLaterFragment = findFragment(NavLookLaterFragment.class);
                if (lookLaterFragment == null) {
                    popTo(NavHomeFragment.class, false, new TimerTask() {
                        @Override
                        public void run() {
                            start(NavLookLaterFragment.newInstance());
                        }
                    });
                } else {
                    popTo(NavLookLaterFragment.class, false);
                }
                break;
            case R.id.nav_live_center:
                NavLiveCenterFragment liveCenterFragment = findFragment(NavLiveCenterFragment.class);
                if (liveCenterFragment == null) {
                    popTo(NavHomeFragment.class, false, new TimerTask() {
                        @Override
                        public void run() {
                            start(NavLiveCenterFragment.newInstance());
                        }
                    });
                } else {
                    popTo(NavLiveCenterFragment.class, false);
                }
                break;
            case R.id.nav_my_vip:
                NavMyVipFragment myVipFragment = findFragment(NavMyVipFragment.class);
                if (myVipFragment == null) {
                    popTo(NavHomeFragment.class, false, new TimerTask() {
                        @Override
                        public void run() {
                            start(NavMyVipFragment.newInstance());
                        }
                    });
                } else {
                    popTo(NavMyVipFragment.class, false);
                }
                break;
            case R.id.nav_free_fow:
                NavFreeFowFragment freeFowFragment = findFragment(NavFreeFowFragment.class);
                if (freeFowFragment == null) {
                    popTo(NavHomeFragment.class, false, new TimerTask() {
                        @Override
                        public void run() {
                            start(NavFreeFowFragment.newInstance());
                        }
                    });
                } else {
                    popTo(NavFreeFowFragment.class, false);
                }
                break;
            case R.id.nav_vip_order:
                NavVipOrderFragment vipOrderFragment = findFragment(NavVipOrderFragment.class);
                if (vipOrderFragment == null) {
                    popTo(NavHomeFragment.class, false, new TimerTask() {
                        @Override
                        public void run() {
                            start(NavVipOrderFragment.newInstance());
                        }
                    });
                } else {
                    popTo(NavVipOrderFragment.class, false);
                }
                break;
        }
        return true;
    }

    @Override
    public void onBackPressedSupport() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            closeDrawer();
        } else {
            ISupportFragment topFragment = getTopFragment();
            if (!(topFragment instanceof NavHomeFragment)) {
                mNav.setCheckedItem(R.id.nav_home);
            }
            if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                pop();
            } else {
                // 放置后台
                // moveTaskToBack(false);

                // 2秒内两次点击返回键退出应用
                long nowTime = System.currentTimeMillis();
                if (nowTime - mPreTime > 2000) {
                    ArmsUtils.makeText(this, ArmsUtils.getString(this, R.string.double_click_to_exit));
                    mPreTime = nowTime;
                } else {
                    ArmsUtils.exitApp();
                }
            }
        }
    }

    @Subscriber(tag = "openDrawer")
    public void openDrawer(MainTag mainTag) {
        if (!mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.openDrawer(GravityCompat.START);
        }
    }

    public void closeDrawer() {
        mDrawer.closeDrawer(GravityCompat.START);
    }
}
