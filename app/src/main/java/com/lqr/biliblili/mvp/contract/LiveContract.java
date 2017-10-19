package com.lqr.biliblili.mvp.contract;


import android.support.v7.widget.RecyclerView;

import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;

public interface LiveContract {

    interface View extends IView {
        android.view.View getHeaderView();

        RecyclerView getRecyclerView();
    }

    interface Model extends IModel {

    }
}
