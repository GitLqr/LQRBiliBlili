package com.lqr.biliblili.app.data.api.cache;


import com.lqr.biliblili.app.data.entity.live.GetAllListData;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;

public interface LiveCache {

    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    Observable<Reply<GetAllListData>> getLiveList(Observable<GetAllListData> data, EvictProvider evictProvider);
}
