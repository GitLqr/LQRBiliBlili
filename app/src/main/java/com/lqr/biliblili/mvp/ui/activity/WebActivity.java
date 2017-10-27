package com.lqr.biliblili.mvp.ui.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.just.library.AgentWeb;
import com.just.library.ChromeClientCallbackManager;

/**
 * @创建者 CSDN_LQR
 * @描述 app的web界面
 */
@Route(path = "/app/web")
public class WebActivity extends BaseActivity implements ChromeClientCallbackManager.ReceivedTitleCallback {

    @Autowired
    public String url;

    private AgentWeb mAgentWeb;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        ARouter.getInstance().inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return 0;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mAgentWeb = AgentWeb.with(this)//传入Activity or Fragment
                .setAgentWebParent(new LinearLayout(this), new LinearLayout.LayoutParams(-1, -1))//传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams ,第一个参数和第二个参数应该对应。
                .useDefaultIndicator()// 使用默认进度条
                .defaultProgressBarColor() // 使用默认进度条颜色
                .setReceivedTitleCallback(this) //设置 Web 页面的 title 回调
                .createAgentWeb()//
                .ready()
                .go(url);
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
