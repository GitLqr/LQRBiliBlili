package com.lqr.biliblili.app.data.api.cache;


import com.lqr.biliblili.app.data.entity.recommend.IndexData;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;

//@EncryptKey(ConstantUtil.ENCRYPT_KEY)
public interface RecommendCache {

    //    @Encrypt
    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    Observable<Reply<IndexData>> getRecommendIndexData(Observable<IndexData> data, DynamicKey dynamicKey, EvictProvider evictProvider);
}
