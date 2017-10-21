package com.lqr.biliblili.mvp.contract;


import android.widget.ImageView;

import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import com.lqr.biliblili.app.data.entity.live.GetAllListData;
import com.lqr.biliblili.mvp.ui.adapter.LiveMultiItemAdapter;
import com.lqr.biliblili.mvp.ui.adapter.entity.LiveMultiItem;

import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;
import io.reactivex.Observable;

public interface LiveContract {

    interface View extends IView {
        void setHeaderView(LiveMultiItemAdapter adapter);

        void setBanner(BGABanner.Adapter<ImageView, String> adapter, List<String> banners);

        void setRecyclerAdapter(LiveMultiItemAdapter adapter);

        void setFooterView(LiveMultiItemAdapter adapter);
    }

    interface Model extends IModel {
        Observable<GetAllListData> getLiveList(boolean update);

        List<LiveMultiItem> parseRecommendData(GetAllListData.DataBean getAllListData);

        List<LiveMultiItem> parsePartitions(GetAllListData.DataBean getAllListData);
    }
}
