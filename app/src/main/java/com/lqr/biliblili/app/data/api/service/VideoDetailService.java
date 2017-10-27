package com.lqr.biliblili.app.data.api.service;

import com.lqr.biliblili.app.data.entity.video.Reply;
import com.lqr.biliblili.app.data.entity.video.Summary;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * @创建者 CSDN_LQR
 * @描述 视频详情
 */
public interface VideoDetailService {

    // 简介
    @Headers({"Domain-Name: video_detail_summary"})
    @GET("/x/view?access_key=19946e1ef3b5cad1a756c475a67185bb&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3940&device=phone&mobi_app=iphone&platform=ios&sign=1206255541e2648c1badb87812458046&ts=1478349831")
    Observable<Summary> getSummaryData(@Query("aid") String aid);

    // 评论
    @Headers({"Domain-Name: video_detail_reply"})
    @GET("/x/v2/reply?appkey=1d8b6e7d45233436&build=515000&mobi_app=android&plat=2&platform=android&sort=0&ts=1508977886&type=1&sign=7294b49920344418e31c896813e85e17")
    Observable<Reply> getReplyData(@Query("oid") String oid, @Query("pn") int pn, @Query("ps") int ps);
}
