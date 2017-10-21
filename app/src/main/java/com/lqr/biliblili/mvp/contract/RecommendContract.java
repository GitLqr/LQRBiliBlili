package com.lqr.biliblili.mvp.contract;

import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import com.lqr.biliblili.app.data.entity.recommend.IndexData;

import io.reactivex.Observable;

public interface RecommendContract {

    interface View extends IView {

    }

    interface Model extends IModel {
        Observable<IndexData> getRecommendIndexData(int idx, boolean refresh);
    }
}
