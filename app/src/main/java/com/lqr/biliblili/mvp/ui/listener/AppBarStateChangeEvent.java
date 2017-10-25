package com.lqr.biliblili.mvp.ui.listener;

import android.support.design.widget.AppBarLayout;

/**
 * @创建者 CSDN_LQR
 * @描述 监听CollapsingToolbarLayout的折叠状态
 */
public abstract class AppBarStateChangeEvent implements AppBarLayout.OnOffsetChangedListener {
    protected enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    private State mCurrentState = State.IDLE;

    public abstract void onStateChanged(AppBarLayout appBarLayout, State state, int verticalOffset);

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (verticalOffset == 0) {
            if (mCurrentState != State.EXPANDED) {
                onStateChanged(appBarLayout, State.EXPANDED, verticalOffset);
            }
            mCurrentState = State.EXPANDED;
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
            if (mCurrentState != State.COLLAPSED) {
                onStateChanged(appBarLayout, State.COLLAPSED, verticalOffset);
            }
            mCurrentState = State.COLLAPSED;
        } else {
            if (mCurrentState != State.IDLE) {
                onStateChanged(appBarLayout, State.IDLE, verticalOffset);
            }
            mCurrentState = State.IDLE;
        }
    }
}
