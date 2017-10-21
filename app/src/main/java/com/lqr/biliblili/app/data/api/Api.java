package com.lqr.biliblili.app.data.api;

public interface Api {
    String LIVE_BASE_URL = "http://api.live.bilibili.com/";
    String RECOMMEND_BASE_URL = "http://app.bilibili.com/";

    // 没有登录的情况下，使用这个User-Agent
    String COMMON_UA_STR = "Mozilla/5.0 BiliDroid/5.15.0 (bbcallen@gmail.com)";
}
