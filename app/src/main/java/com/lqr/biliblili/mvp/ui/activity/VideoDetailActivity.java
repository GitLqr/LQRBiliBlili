package com.lqr.biliblili.mvp.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.flyco.systembar.SystemBarHelper;
import com.flyco.tablayout.SlidingTabLayout;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.lqr.biliblili.R;
import com.lqr.biliblili.app.base.MySupportActivity;
import com.lqr.biliblili.app.data.entity.video.PlayUrl;
import com.lqr.biliblili.app.data.entity.video.VideoDetail;
import com.lqr.biliblili.di.component.DaggerVideoDetailComponent;
import com.lqr.biliblili.di.module.VideoDetailModule;
import com.lqr.biliblili.mvp.contract.VideoDetailContract;
import com.lqr.biliblili.mvp.presenter.VideoDetailPresenter;
import com.lqr.biliblili.mvp.ui.adapter.VideoDetailFragmentAdapter;
import com.lqr.biliblili.mvp.ui.listener.AppBarStateChangeEvent;
import com.lqr.biliblili.mvp.ui.listener.VideoViewListener;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

import java.util.Map;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;

/**
 * @创建者 CSDN_LQR
 * @描述 视频详情
 */
@Route(path = "/video/detail")
public class VideoDetailActivity extends MySupportActivity<VideoDetailPresenter> implements VideoDetailContract.View {

    @Autowired(name = "aid")
    public String aid;

    // Fab锚点
    private int mAnchorX = 30;
    private int mAnchorY = 60;
    // 播放器
    private boolean isPlay;
    private boolean isPause;
    private boolean cacheVideo = true;
    private OrientationUtils mOrientationUtils;
    private GSYVideoOptionBuilder mGsyVideoOptionBuilder;
    private ImageView mIvCover;

    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_av)
    TextView mTvAv;
    @BindView(R.id.video_view)
    StandardGSYVideoPlayer mVideoView;
    @BindView(R.id.tv_play_immediately)
    TextView mTvPlayImmediately;

    @BindView(R.id.tablayout)
    SlidingTabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    @BindView(R.id.fab)
    FloatingActionButton mFab;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        ARouter.getInstance().inject(this);
        DaggerVideoDetailComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .videoDetailModule(new VideoDetailModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_video_detail; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initStatusBar();
        initAppbar();
        initToolbar();
        initFab();
        initVideoPlayer();
        if (!TextUtils.isEmpty(aid)) {
            mPresenter.loadData(aid);
        } else {
            showMessage("aid = " + aid);
        }
    }

    private void initStatusBar() {
        //设置StatusBar透明
        SystemBarHelper.immersiveStatusBar(this);
        SystemBarHelper.setHeightAndPadding(this, mToolbar);
    }


    private void initAppbar() {
        mAppbar.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> showHideFab(verticalOffset));
        mAppbar.addOnOffsetChangedListener(new AppBarStateChangeEvent() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state, int verticalOffset) {
                if (state == State.EXPANDED) {
                    mTvAv.setVisibility(View.VISIBLE);
                    mTvPlayImmediately.setVisibility(View.GONE);
                } else if (state == State.COLLAPSED) {
                    mTvAv.setVisibility(View.GONE);
                    mTvPlayImmediately.setVisibility(View.VISIBLE);
                } else {
                    mTvAv.setVisibility(View.VISIBLE);
                    mTvPlayImmediately.setVisibility(View.GONE);
                }
            }
        });
    }

    private void initToolbar() {
        // toolbar
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        mToolbar.setNavigationOnClickListener(v -> killMyself());

        // CollapsingToolbarLayout
        mCollapsingToolbarLayout.setTitleEnabled(false);// 必须关闭文字，否则Toolbar中的自定义控件位置会受影响
    }

    @Override
    public void initViewPager(VideoDetail videoDetail) {
        VideoDetailFragmentAdapter videoDetailFragmentAdapter = new VideoDetailFragmentAdapter(getSupportFragmentManager(), this, videoDetail);
        mViewPager.setAdapter(videoDetailFragmentAdapter);
        mTabLayout.setViewPager(mViewPager);
    }


    private void initFab() {
        mFab.setOnClickListener(view -> {
            ObjectAnimator translationY = ObjectAnimator.ofFloat(mFab, "translationY", -ArmsUtils.dip2px(this, mAnchorY));
            translationY.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    showPlayer();
                }
            });
            translationY.start();
        });
    }

    private void showPlayer() {
        mFab.setVisibility(View.GONE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Animator circularReveal = ViewAnimationUtils.createCircularReveal(mVideoView, mVideoView.getWidth() - ArmsUtils.dip2px(VideoDetailActivity.this, mAnchorX), mVideoView.getHeight() - ArmsUtils.dip2px(VideoDetailActivity.this, mAnchorY), 0, mVideoView.getWidth());
            circularReveal.start();
        }
        mVideoView.getStartButton().setVisibility(View.GONE);
        mPresenter.loadPlayUrl(aid);
        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) mAppbar.getChildAt(0).getLayoutParams();
        layoutParams.setScrollFlags(0);
        mAppbar.getChildAt(0).setLayoutParams(layoutParams);

    }

    private void initVideoPlayer() {
        // 封面
        mIvCover = new ImageView(this);
        mOrientationUtils = new OrientationUtils(this, mVideoView);
        // 开始播放了才能旋转和全屏
        mOrientationUtils.setEnable(false);
        mGsyVideoOptionBuilder = new GSYVideoOptionBuilder()
                .setThumbImageView(mIvCover)
                .setUrl("")
                .setIsTouchWiget(true)
                .setRotateViewAuto(false)
                .setLockLand(false)
                .setShowFullAnimation(true)
                .setNeedLockFull(true)
                .setSeekRatio(1)
                .setCacheWithPlay(cacheVideo)
                .setVideoTitle("")
                .setStandardVideoAllCallBack(new VideoViewListener() {
                    @Override
                    public void onPrepared(String s, Object... objects) {
                        super.onPrepared(s, objects);
                        // 开始播放了才能旋转和全屏
                        mOrientationUtils.setEnable(true);
                        isPlay = true;
                    }

                    @Override
                    public void onQuitFullscreen(String s, Object... objects) {
                        super.onQuitFullscreen(s, objects);
                        if (mOrientationUtils != null) {
                            mOrientationUtils.backToProtVideo();
                        }
                    }
                });
        mGsyVideoOptionBuilder.build(mVideoView);
        mVideoView.getFullscreenButton().setOnClickListener(v -> {
            // 直接横屏
            mOrientationUtils.resolveByClick();
            // 第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
            mVideoView.startWindowFullscreen(VideoDetailActivity.this, true, true);
        });
        mVideoView.setLockClickListener((view, lock) -> {
            if (mOrientationUtils != null) {
                //配合下方的onConfigurationChanged
                mOrientationUtils.setEnable(!lock);
            }
        });
        mVideoView.getTitleTextView().setVisibility(View.GONE);
        mVideoView.getBackButton().setVisibility(View.GONE);
        mVideoView.getStartButton().setVisibility(View.GONE);
    }

    @Override
    public void playVideo(PlayUrl playUrl) {
        if (playUrl != null) {
            Map<String, PlayUrl.DurlBean> durl = playUrl.getDurl();
            if (durl != null) {
                PlayUrl.DurlBean durlBean = durl.get("0");
                if (durlBean != null) {
                    mVideoView.setVisibility(View.VISIBLE);
                    mVideoView.release();
                    mGsyVideoOptionBuilder
                            .setUrl(durlBean.getUrl())
                            .setCacheWithPlay(cacheVideo)
                            .build(mVideoView);
                    mVideoView.postDelayed(() -> mVideoView.startPlayLogic(), 1000);
                }
            }
        }
    }

    public void showHideFab(int verticalOffset) {
        if (verticalOffset == 0) {
            showFab();
        } else if (verticalOffset < 0) {
            hideFab();
        }
    }

    private void showFab() {
        if (mFab.getVisibility() == View.INVISIBLE) {
            mFab.animate().scaleX(1f).scaleY(1f)
                    .setInterpolator(new OvershootInterpolator())
                    .start();
            mFab.setClickable(true);
        }
    }

    private void hideFab() {
        if (mFab.getVisibility() == View.INVISIBLE) {
            mFab.animate().scaleX(0).scaleY(0)
                    .setInterpolator(new AccelerateInterpolator())
                    .start();
            mFab.setClickable(false);
        }
    }

    private GSYVideoPlayer getCurPlay() {
        if (mVideoView.getFullWindowPlayer() != null) {
            return mVideoView.getFullWindowPlayer();
        }
        return mVideoView;
    }

    @Override
    public void onBackPressedSupport() {
        if (mOrientationUtils != null) {
            mOrientationUtils.backToProtVideo();
        }
        if (StandardGSYVideoPlayer.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressedSupport();
    }

    @Override
    protected void onResume() {
        getCurPlay().onVideoResume();
        super.onResume();
        isPause = false;
    }

    @Override
    protected void onPause() {
        getCurPlay().onVideoPause();
        super.onPause();
        isPause = true;
    }

    @Override
    protected void onDestroy() {
        if (isPlay) {
            getCurPlay().release();
        }
        if (mOrientationUtils != null) {
            mOrientationUtils.releaseListener();
        }
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // 如果旋转了就全屏
        if (isPlay && !isPause) {
            mVideoView.onConfigurationChanged(this, newConfig, mOrientationUtils);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }


    @Override
    public void setTvAvStr(String av) {
        mTvAv.setText("av" + av);
    }

    @Override
    public ImageView getIvCover() {
        return mIvCover;
    }
}
