package com.lqr.biliblili.app.data.api.service;

import com.lqr.biliblili.app.data.entity.live.GetAllListData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * @创建者 CSDN_LQR
 * @描述 直播
 */
public interface LiveService {

    /**
     * 首页直播
     */
    @Headers({"Domain-Name: live"})
    @GET("/room/v1/AppIndex/getAllList?_device=android&_hwid=Pwc3BzUCOllgWW9eIl4i&appkey=1d8b6e7d45233436&build=515000&device=android&mobi_app=android&platform=android&scale=xhdpi&src=kuan&trace_id=20171019034900026&ts=1508399366&version=5.15.0.515000&sign=8fe2091c7683c86721da54690ab9fdbf")
    Observable<GetAllListData> getLiveIndexList();
}
