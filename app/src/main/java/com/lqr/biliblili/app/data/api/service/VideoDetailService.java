package com.lqr.biliblili.app.data.api.service;

import com.lqr.biliblili.app.data.entity.video.PlayUrl;
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

    // 获取播放链接
    @Headers({
            "Domain-Name: video_detail_reply",
            "Cookie: finger=7360d3c2; fts=1508123437; sid=j3tkkml8; buvid3=7531F3F3-5901-4A84-B4AE-CFC51252767247169infoc; pgv_pvi=4664536064; rpdid=olwoqoplpsdoswqoiqqww; DedeUserID=60674616; DedeUserID__ckMd5=c003bee1809f575c; SESSDATA=87324b97%2C1511414488%2C58f5afbe; bili_jct=23e4c5db915b02de8aba81b6ed124e2b; LIVE_BUVID=AUTO5715088224898796; _cnt_pm=0; _cnt_notify=0; purl_token=bilibili_1509338432; pgv_si=s2885227520; _dfcaptcha=9122941438097f382ce9ec4f97773b4a; bsource=seo"
    })
    @GET("/playurl?callback=&page=1&platform=html5&quality=1&vtype=flv&type=jsonp&token=e8c5408c708308a31336d3ca59509dc6")
    Observable<PlayUrl> getPlayurl(@Query("aid") String aid);//&aid=15813368
}
