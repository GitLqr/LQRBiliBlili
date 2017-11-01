package com.lqr.biliblili.mvp.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.lqr.biliblili.R;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

public class LQRBiliBiliPlayer extends StandardGSYVideoPlayer {

    public LQRBiliBiliPlayer(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }

    public LQRBiliBiliPlayer(Context context) {
        super(context);
    }

    public LQRBiliBiliPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int getLayoutId() {
        return R.layout.widget_lqr_bilibili_player;
    }

    @Override
    protected void onClickUiToggle() {
        super.onClickUiToggle();
        if (mCurrentState == CURRENT_STATE_PLAYING) {
            if (mBottomContainer != null) {
                if (mBottomContainer.getVisibility() == View.VISIBLE) {
                    if (mOnWidgetVisibleListener != null) {
                        mOnWidgetVisibleListener.onShow();
                    }
                } else {
                    if (mOnWidgetVisibleListener != null) {
                        mOnWidgetVisibleListener.onHide();
                    }
                }
            }
        } else {
            if (mOnWidgetVisibleListener != null) {
                mOnWidgetVisibleListener.onShow();
            }
        }
    }

    @Override
    protected void hideAllWidget() {
        super.hideAllWidget();
        if (mOnWidgetVisibleListener != null) {
            mOnWidgetVisibleListener.onHide();
        }
    }

    OnWidgetVisibleListener mOnWidgetVisibleListener;

    public OnWidgetVisibleListener getOnWidgetVisibleListener() {
        return mOnWidgetVisibleListener;
    }

    public void setOnWidgetVisibleListener(OnWidgetVisibleListener onWidgetVisibleListener) {
        mOnWidgetVisibleListener = onWidgetVisibleListener;
    }

    public interface OnWidgetVisibleListener {
        void onShow();

        void onHide();
    }
}
