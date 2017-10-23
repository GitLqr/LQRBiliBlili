package com.lqr.biliblili.mvp.contract;

import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import com.lqr.biliblili.app.data.entity.recommend.IndexData;
import com.lqr.biliblili.mvp.ui.adapter.RecommendMultiItemAdapter;
import com.lqr.biliblili.mvp.ui.adapter.entity.RecommendMultiItem;

import java.util.List;

import io.reactivex.Observable;

public interface RecommendContract {

    interface View extends IView {

        void setRecyclerAdapter(RecommendMultiItemAdapter adapter);

        void recyclerScrollToPosition(int position);
    }

    interface Model extends IModel {
        /**
         * @param idx        下拉刷新时取第一个数据的idx，上拉加载更多时取最后一个数据的idx
         * @param refresh    下拉刷新时取"true"，上拉加载更多时取"false"
         * @param clearCache 第一次加载数据时为true，其他时候为false(对应的true时，login_event的值为1[获取banner]，为false时，login_event的值为0)
         * @return
         */
        Observable<IndexData> getRecommendIndexData(int idx, boolean refresh, boolean clearCache);

        List<RecommendMultiItem> parseIndexData(IndexData indexData);

    }
}
