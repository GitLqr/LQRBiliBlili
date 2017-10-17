package com.lqr.biliblili.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jess.arms.base.BaseFragment;
import com.jess.arms.mvp.IPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragmentEx<P extends IPresenter> extends BaseFragment<P> {

    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = initView(inflater, container, savedInstanceState);
        mUnbinder = ButterKnife.bind(view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        mUnbinder = null;
    }
}
