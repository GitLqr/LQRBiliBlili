package com.lqr.biliblili.mvp.ui.widget.player;

import android.graphics.drawable.Drawable;
import android.view.View;

import com.lqr.biliblili.mvp.ui.listener.MyStandardVideoAllCallBack;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.listener.VideoAllCallBack;
import com.shuyu.gsyvideoplayer.render.effect.NoEffect;
import com.shuyu.gsyvideoplayer.render.view.GSYVideoGLView;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;

import java.io.File;
import java.util.Map;

/**
 * @创建者 CSDN_LQR
 * @描述 LQRBiliBiliPlayer的配置类
 */
public class LQRBiliPlayerOptionBuilder {

    // 退出全屏显示的控件图片
    protected int mShrinkImageRes = -1;

    // 全屏显示的控件图片
    protected int mEnlargeImageRes = -1;

    // 播放的tag，防止错误，因为普通的url也可能重复
    protected int mPlayPosition = -22;

    // 触摸快进dialog的进度高亮颜色
    protected int mDialogProgressHighLightColor = -11;

    // 触摸快进dialog的进度普通颜色
    protected int mDialogProgressNormalColor = -11;

    // 触摸隐藏等待时间
    protected int mDismissControlTime = 2500;

    // 从哪个开始播放
    protected long mSeekOnStart = -1;

    // 触摸滑动进度的比例系数
    protected float mSeekRatio = 1;

    // 播放速度
    protected float mSpeed = 1;

    // 是否隐藏虚拟按键
    protected boolean mHideKey = true;

    // 是否使用全屏动画效果
    protected boolean mShowFullAnimation = true;

    // 是否需要显示流量提示
    protected boolean mNeedShowWifiTip = true;

    // 是否自动旋转
    protected boolean mRotateViewAuto = true;

    // 当前全屏是否锁定全屏
    protected boolean mLockLand = false;

    // 循环
    protected boolean mLooping = false;

    // 是否支持非全屏滑动触摸有效
    protected boolean mIsTouchWidget = true;

    // 是否支持全屏滑动触摸有效
    protected boolean mIsTouchWidgetFull = true;

    // 是否显示暂停图片
    protected boolean mShowPauseCover = true;

    // 旋转使能后是否跟随系统设置
    protected boolean mRotateWithSystem = true;

    // 边播放边缓存
    protected boolean mCacheWithPlay;

    // 是否需要锁定屏幕
    protected boolean mNeedLockFull;

    // 点击封面播放
    protected boolean mThumbPlay;

    // 是否需要变速不变调
    protected boolean mSounchTouch;

    // 播放的tag，防止错误，因为普通的url也可能重复
    protected String mPlayTag = "";

    // 播放url
    protected String mUrl;

    // 视频title
    protected String mVideoTitle = null;

    // 是否自定义的缓冲文件路径
    protected File mCachePath;

    // http请求头
    protected Map<String, String> mMapHeadData;

    // 视频状体回调
    protected VideoAllCallBack mVideoAllCallBack;

    // 标准播放器的回调
    protected MyStandardVideoAllCallBack mMyStandardVideoAllCallBack;

    // 点击锁屏的回调
    protected LockClickListener mLockClickListener;

    // 封面
    protected View mThumbImageView;

    // 底部进度条样式
    protected Drawable mBottomProgressDrawable;

    // 底部进度条样式
    protected Drawable mBottomShowProgressDrawable;

    // 底部进度条小圆点样式
    protected Drawable mBottomShowProgressThumbDrawable;

    // 音量进度条样式
    protected Drawable mVolumeProgressDrawable;

    // 滤镜
    protected GSYVideoGLView.ShaderInterface mEffectFilter = new NoEffect();

    /**
     * 全屏动画
     *
     * @param showFullAnimation 是否使用全屏动画效果
     */
    public LQRBiliPlayerOptionBuilder setShowFullAnimation(boolean showFullAnimation) {
        this.mShowFullAnimation = showFullAnimation;
        return this;
    }

    /**
     * 设置循环
     */
    public LQRBiliPlayerOptionBuilder setLooping(boolean looping) {
        this.mLooping = looping;
        return this;
    }

    /**
     * 设置播放过程中的回调
     */
    public LQRBiliPlayerOptionBuilder setVideoAllCallBack(VideoAllCallBack videoAllCallBack) {
        this.mVideoAllCallBack = videoAllCallBack;
        return this;
    }

    /**
     * 是否开启自动旋转
     */
    public LQRBiliPlayerOptionBuilder setRotateViewAuto(boolean rotateViewAuto) {
        this.mRotateViewAuto = rotateViewAuto;
        return this;
    }

    /**
     * 播放速度
     */
    public LQRBiliPlayerOptionBuilder setLockLand(boolean lockLand) {
        this.mLockLand = lockLand;
        return this;
    }

    /**
     * 变声不变调
     */
    public LQRBiliPlayerOptionBuilder setSoundTouch(boolean soundTouch) {
        this.mSounchTouch = soundTouch;
        return this;
    }

    /**
     * 全屏隐藏虚拟按键，默认打开
     */
    public LQRBiliPlayerOptionBuilder setHideKey(boolean hideKey) {
        this.mHideKey = hideKey;
        return this;
    }

    /**
     * 是否可以滑动界面改变进度，声音等
     * 默认true
     */
    public LQRBiliPlayerOptionBuilder setIsTouchWidget(boolean isTouchWiget) {
        this.mIsTouchWidget = isTouchWiget;
        return this;
    }

    /**
     * 是否需要显示流量提示,默认true
     */
    public LQRBiliPlayerOptionBuilder setNeedShowWifiTip(boolean needShowWifiTip) {
        this.mNeedShowWifiTip = needShowWifiTip;
        return this;
    }

    /**
     * 设置右下角 显示切换到全屏 的按键资源
     * 必须在setUp之前设置
     * 不设置使用默认
     */
    public LQRBiliPlayerOptionBuilder setEnlargeImageRes(int enlargeImageRes) {
        this.mEnlargeImageRes = enlargeImageRes;
        return this;
    }

    /**
     * 设置右下角 显示退出全屏 的按键资源
     * 必须在setUp之前设置
     * 不设置使用默认
     */
    public LQRBiliPlayerOptionBuilder setShrinkImageRes(int mShrinkImageRes) {
        this.mShrinkImageRes = mShrinkImageRes;
        return this;
    }

    /**
     * 是否需要加载显示暂停的cover图片
     * 打开状态下，暂停退到后台，再回到前台不会显示黑屏，但可以对某些机型有概率出现OOM
     * 关闭情况下，暂停退到后台，再回到前台显示黑屏
     *
     * @param showPauseCover 默认true
     */
    public LQRBiliPlayerOptionBuilder setShowPauseCover(boolean showPauseCover) {
        this.mShowPauseCover = showPauseCover;
        return this;
    }

    /**
     * 调整触摸滑动快进的比例
     *
     * @param seekRatio 滑动快进的比例，默认1。数值越大，滑动的产生的seek越小
     */
    public LQRBiliPlayerOptionBuilder setSeekRatio(float seekRatio) {
        if (seekRatio < 0) {
            return this;
        }
        this.mSeekRatio = seekRatio;
        return this;
    }

    /**
     * 是否更新系统旋转，false的话，系统禁止旋转也会跟着旋转
     *
     * @param rotateWithSystem 默认true
     */
    public LQRBiliPlayerOptionBuilder setRotateWithSystem(boolean rotateWithSystem) {
        this.mRotateWithSystem = rotateWithSystem;
        return this;
    }

    /**
     * 播放tag防止错误，因为普通的url也可能重复
     *
     * @param playTag 保证不重复就好
     */
    public LQRBiliPlayerOptionBuilder setPlayTag(String playTag) {
        this.mPlayTag = playTag;
        return this;
    }

    /**
     * 设置播放位置防止错位
     */
    public LQRBiliPlayerOptionBuilder setPlayPosition(int playPosition) {
        this.mPlayPosition = playPosition;
        return this;
    }

    /**
     * 从哪里开始播放
     * 目前有时候前几秒有跳动问题，毫秒
     * 需要在startPlayLogic之前，即播放开始之前
     */
    public LQRBiliPlayerOptionBuilder setSeekOnStart(long seekOnStart) {
        this.mSeekOnStart = seekOnStart;
        return this;
    }

    /**
     * 播放url
     */
    public LQRBiliPlayerOptionBuilder setUrl(String url) {
        this.mUrl = url;
        return this;
    }

    /**
     * 视频title
     */
    public LQRBiliPlayerOptionBuilder setVideoTitle(String videoTitle) {
        this.mVideoTitle = videoTitle;
        return this;
    }

    /**
     * 是否边缓存，m3u8等无效
     */
    public LQRBiliPlayerOptionBuilder setCacheWithPlay(boolean cacheWithPlay) {
        this.mCacheWithPlay = cacheWithPlay;
        return this;
    }

    /**
     * 自定义缓存路径，推荐不设置，使用默认路径
     */
    public LQRBiliPlayerOptionBuilder setCachePath(File cachePath) {
        this.mCachePath = cachePath;
        return this;
    }

    /**
     * 设置请求的头信息
     */
    public LQRBiliPlayerOptionBuilder setMapHeadData(Map<String, String> mapHeadData) {
        this.mMapHeadData = mapHeadData;
        return this;
    }

    public LQRBiliPlayerOptionBuilder setMyStandardVideoAllCallBack(MyStandardVideoAllCallBack myStandardVideoAllCallBack) {
        this.mMyStandardVideoAllCallBack = myStandardVideoAllCallBack;
        return this;
    }

    /**
     * 设置封面
     */
    public LQRBiliPlayerOptionBuilder setThumbImageView(View view) {
        mThumbImageView = view;
        return this;
    }

    /**
     * 底部进度条(弹出的)
     */
    public LQRBiliPlayerOptionBuilder setBottomShowProgressBarDrawable(Drawable drawable, Drawable thumb) {
        mBottomShowProgressDrawable = drawable;
        mBottomShowProgressThumbDrawable = thumb;
        return this;
    }

    /**
     * 底部进度条(非弹出)
     */
    public LQRBiliPlayerOptionBuilder setBottomProgressBarDrawable(Drawable drawable) {
        mBottomProgressDrawable = drawable;
        return this;
    }

    /**
     * 声音进度条
     */
    public LQRBiliPlayerOptionBuilder setDialogVolumeProgressBar(Drawable drawable) {
        mVolumeProgressDrawable = drawable;
        return this;
    }


    /**
     * 中间进度条字体颜色
     */
    public LQRBiliPlayerOptionBuilder setDialogProgressColor(int highLightColor, int normalColor) {
        mDialogProgressHighLightColor = highLightColor;
        mDialogProgressNormalColor = normalColor;
        return this;
    }

    /**
     * 是否点击封面可以播放
     */
    public LQRBiliPlayerOptionBuilder setThumbPlay(boolean thumbPlay) {
        this.mThumbPlay = thumbPlay;
        return this;
    }

    /**
     * 是否需要全屏锁定屏幕功能
     * 如果单独使用请设置setIfCurrentIsFullscreen为true
     */
    public LQRBiliPlayerOptionBuilder setNeedLockFull(boolean needLockFull) {
        this.mNeedLockFull = needLockFull;
        return this;
    }

    /**
     * 锁屏点击
     */
    public LQRBiliPlayerOptionBuilder setLockClickListener(LockClickListener lockClickListener) {
        this.mLockClickListener = lockClickListener;
        return this;
    }

    /**
     * 设置触摸显示控制ui的消失时间
     *
     * @param dismissControlTime 毫秒，默认2500
     */
    public LQRBiliPlayerOptionBuilder setDismissControlTime(int dismissControlTime) {
        this.mDismissControlTime = dismissControlTime;
        return this;
    }

    /**
     * 设置滤镜效果
     */
    public LQRBiliPlayerOptionBuilder setEffectFilter(GSYVideoGLView.ShaderInterface effectFilter) {
        this.mEffectFilter = effectFilter;
        return this;
    }

    public void build(LQRBiliPlayer biliBiliPlayer) {
        if (mMyStandardVideoAllCallBack != null) {
            biliBiliPlayer.setStandardVideoAllCallBack(mMyStandardVideoAllCallBack);
        }
        if (mBottomShowProgressDrawable != null && mBottomShowProgressThumbDrawable != null) {
            biliBiliPlayer.setBottomShowProgressBarDrawable(mBottomShowProgressDrawable, mBottomShowProgressThumbDrawable);
        }

        if (mBottomProgressDrawable != null) {
            biliBiliPlayer.setBottomProgressBarDrawable(mBottomProgressDrawable);
        }

        if (mVolumeProgressDrawable != null) {
            biliBiliPlayer.setDialogVolumeProgressBar(mVolumeProgressDrawable);
        }

        if (mDialogProgressHighLightColor > 0 && mDialogProgressNormalColor > 0) {
            biliBiliPlayer.setDialogProgressColor(mDialogProgressHighLightColor, mDialogProgressNormalColor);
        }

        build((GSYBaseVideoPlayer) biliBiliPlayer);
    }

    public void build(GSYBaseVideoPlayer gsyVideoPlayer) {
        gsyVideoPlayer.setPlayTag(mPlayTag);
        gsyVideoPlayer.setPlayPosition(mPlayPosition);
        gsyVideoPlayer.setThumbPlay(mThumbPlay);
        if (mThumbImageView != null) {
            gsyVideoPlayer.setThumbImageView(mThumbImageView);
        }
        gsyVideoPlayer.setNeedLockFull(mNeedLockFull);
        if (mLockClickListener != null) {
            gsyVideoPlayer.setLockClickListener(mLockClickListener);
        }
        gsyVideoPlayer.setDismissControlTime(mDismissControlTime);
        if (mSeekOnStart > 0) {
            gsyVideoPlayer.setSeekOnStart(mSeekOnStart);
        }
        gsyVideoPlayer.setShowFullAnimation(mShowFullAnimation);
        gsyVideoPlayer.setLooping(mLooping);
        if (mMyStandardVideoAllCallBack == null) {
            gsyVideoPlayer.setVideoAllCallBack(mVideoAllCallBack);
        }
        gsyVideoPlayer.setRotateViewAuto(mRotateViewAuto);
        gsyVideoPlayer.setLockLand(mLockLand);
        gsyVideoPlayer.setSpeed(mSpeed, mSounchTouch);
        gsyVideoPlayer.setHideKey(mHideKey);
        gsyVideoPlayer.setIsTouchWiget(mIsTouchWidget);
        gsyVideoPlayer.setIsTouchWigetFull(mIsTouchWidgetFull);
        gsyVideoPlayer.setNeedShowWifiTip(mNeedShowWifiTip);
        gsyVideoPlayer.setEffectFilter(mEffectFilter);
        if (mEnlargeImageRes > 0) {
            gsyVideoPlayer.setEnlargeImageRes(mEnlargeImageRes);
        }
        if (mShrinkImageRes > 0) {
            gsyVideoPlayer.setShrinkImageRes(mShrinkImageRes);
        }
        gsyVideoPlayer.setShowPauseCover(mShowPauseCover);
        gsyVideoPlayer.setSeekRatio(mSeekRatio);
        gsyVideoPlayer.setRotateWithSystem(mRotateWithSystem);
        gsyVideoPlayer.setUp(mUrl, mCacheWithPlay, mCachePath, mMapHeadData, mVideoTitle);
    }
}
