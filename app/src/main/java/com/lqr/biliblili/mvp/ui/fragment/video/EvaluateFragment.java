package com.lqr.biliblili.mvp.ui.fragment.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jess.arms.di.component.AppComponent;
import com.lqr.biliblili.app.base.MySupportFragment;

/**
 * @创建者 CSDN_LQR
 * @描述 评论
 */
public class EvaluateFragment extends MySupportFragment {

    public static EvaluateFragment newInstance() {
        return new EvaluateFragment();
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(container.getContext());
        textView.setText("评论");
        return textView;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setData(Object data) {

    }
}
