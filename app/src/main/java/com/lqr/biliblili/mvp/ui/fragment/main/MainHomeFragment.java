package com.lqr.biliblili.mvp.ui.fragment.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jess.arms.di.component.AppComponent;
import com.lqr.biliblili.R;
import com.lqr.biliblili.app.base.MySupportFragment;

/**
 * @创建者 CSDN_LQR
 * @描述 首页
 */
public class MainHomeFragment extends MySupportFragment {

    public static MainHomeFragment newInstance() {
        return new MainHomeFragment();
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_main, container, false);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.main_home_menu, menu);
//        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_active:
                ARouter.getInstance().build("/app/web").withString("url", "www.qq.com").navigation();
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
}
