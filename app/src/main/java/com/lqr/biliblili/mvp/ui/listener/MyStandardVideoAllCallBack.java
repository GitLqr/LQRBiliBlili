package com.lqr.biliblili.mvp.ui.listener;


import com.shuyu.gsyvideoplayer.listener.StandardVideoAllCallBack;

import timber.log.Timber;

public class MyStandardVideoAllCallBack implements StandardVideoAllCallBack {

    //加载成功，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onPrepared(String s, Object... objects) {
    }

    //点击了开始按键播放，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onClickStartIcon(String s, Object... objects) {
    }

    //点击了错误状态下的开始按键，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onClickStartError(String s, Object... objects) {
    }

    //点击了播放状态下的开始按键--->停止，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onClickStop(String s, Object... objects) {
    }

    //点击了全屏播放状态下的开始按键--->停止，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onClickStopFullscreen(String s, Object... objects) {
    }

    //点击了暂停状态下的开始按键--->播放，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onClickResume(String s, Object... objects) {
    }

    //点击了全屏暂停状态下的开始按键--->播放，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onClickResumeFullscreen(String s, Object... objects) {
    }

    //点击了空白弹出seekbar，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onClickSeekbar(String s, Object... objects) {
    }

    //点击了全屏的seekbar，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onClickSeekbarFullscreen(String s, Object... objects) {
    }

    //播放完了，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onAutoComplete(String s, Object... objects) {
    }

    //进去全屏，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onEnterFullscreen(String s, Object... objects) {
    }

    //退出全屏，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onQuitFullscreen(String s, Object... objects) {
        Timber.e("onQuitFullscreen");
    }

    //进入小窗口，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onQuitSmallWidget(String s, Object... objects) {
    }

    //退出小窗口，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onEnterSmallWidget(String s, Object... objects) {
    }

    //触摸调整声音，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onTouchScreenSeekVolume(String s, Object... objects) {
    }

    //触摸调整进度，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onTouchScreenSeekPosition(String s, Object... objects) {
    }

    //触摸调整亮度，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onTouchScreenSeekLight(String s, Object... objects) {
    }

    //播放错误，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onPlayError(String s, Object... objects) {
    }

    //点击了空白区域开始播放，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onClickStartThumb(String s, Object... objects) {
    }

    //点击了播放中的空白区域，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onClickBlank(String s, Object... objects) {
    }

    //点击了全屏播放中的空白区域，objects[0]是title，object[1]是当前所处播放器（全屏或非全屏）
    @Override
    public void onClickBlankFullscreen(String s, Object... objects) {
    }
}
