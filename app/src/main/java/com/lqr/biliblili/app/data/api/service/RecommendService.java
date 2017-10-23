package com.lqr.biliblili.app.data.api.service;

import com.lqr.biliblili.app.data.entity.recommend.IndexData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * @创建者 CSDN_LQR
 * @描述 推荐
 */
public interface RecommendService {

    @Headers({"Domain-Name: recommend"})
    @GET("/x/feed/index?appkey=1d8b6e7d45233436&build=515000&mobi_app=android&network=wifi&open_event=cold&platform=android&style=2&ts=1508556998&sign=8215c7d01711e2f11e75830d856d32f5")
    Observable<IndexData> getRecommendIndexData(@Query("idx") int idx, @Query("pull") String pull, @Query("login_event") int login_event);//login_event为1时加载banner
}
