package com.lqr.biliblili.app.data.api.service;

import com.lqr.biliblili.app.data.entity.recommend.IndexData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * @创建者 CSDN_LQR
 * @描述 推荐
 */
public interface RecommendService {

    @Headers({"Domain-Name: recommend"})
    @GET("/x/feed/index?appkey=1d8b6e7d45233436&build=515000&idx={idx}&login_event=0&mobi_app=android&network=wifi&open_event=&platform=android&pull=true&style=2&ts=1508556998&sign=8215c7d01711e2f11e75830d856d32f5")
    Observable<IndexData> getRecommendIndexData(@Path("idx") int idx, @Path("pull") String pull);
}
