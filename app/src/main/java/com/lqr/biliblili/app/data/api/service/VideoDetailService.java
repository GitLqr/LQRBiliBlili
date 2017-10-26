package com.lqr.biliblili.app.data.api.service;

import com.lqr.biliblili.app.data.entity.video.Reply;
import com.lqr.biliblili.app.data.entity.video.Summary;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * @创建者 CSDN_LQR
 * @描述 视频详情
 */
public interface VideoDetailService {

    // 简介
    @Headers({"Domain-Name: video_detail_summary"})
    @GET("/x/v2/view?aid=15604756&appkey=1d8b6e7d45233436&build=515000&from=7&mobi_app=android&plat=0&platform=android&ts=1508893149&sign=7694dea72964a471993829a4e8d9b4fc")
    Observable<Summary> getSummaryData();

    // 评论
    @Headers({"Domain-Name: video_detail_reply"})
    @GET("/x/v2/reply?appkey=1d8b6e7d45233436&build=515000&mobi_app=android&oid=15379648&plat=2&platform=android&pn=1&ps=20&sort=0&ts=1508977886&type=1&sign=7294b49920344418e31c896813e85e17")
    Observable<Reply> getReplyData();
}
