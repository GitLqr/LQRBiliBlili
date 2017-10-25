package com.lqr.biliblili.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.lqr.biliblili.R;

import butterknife.BindView;

/**
 * @创建者 CSDN_LQR
 * @描述 测试自定义控件用的Activity
 */
public class CustomerViewActivity extends BaseActivity {

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_customer_view);
//        StatusBarUtil.setTransparent(this);
//    }

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_customer_view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setSupportActionBar(mToolbar);
    }
}
