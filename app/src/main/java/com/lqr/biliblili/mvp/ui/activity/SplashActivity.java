package com.lqr.biliblili.mvp.ui.activity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.RxLifecycleUtils;
import com.lqr.biliblili.R;
import com.lqr.biliblili.app.utils.SystemUiVisibilityUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * @创建者 CSDN_LQR
 * @描述 启动页面
 */
@Route(path = "/app/splash")
public class SplashActivity extends BaseActivity {

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int initView(Bundle savedInstanceState) {
        SystemUiVisibilityUtil.hideStatusBar(getWindow(), true);
        return R.layout.activity_splash;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .compose(RxLifecycleUtils.bindToLifecycle(this))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    ARouter.getInstance().build("/app/main").navigation();
//                    ArmsUtils.startActivity(MainActivity.class)
                });
    }
}
