package com.lqr.biliblili.mvp.ui.widget;

import android.content.Context;
import android.util.AttributeSet;

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
}
