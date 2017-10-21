package com.lqr.biliblili.app.config.applyOptions;

import android.content.Context;

import me.jessyan.rxerrorhandler.handler.listener.ResponseErrorListener;


public class MyResponseErrorListener implements ResponseErrorListener {
    @Override
    public void handleResponseError(Context context, Throwable t) {
        /* 用来提供处理所有错误的监听
           rxjava必要要使用ErrorHandleSubscriber(默认实现Subscriber的onError方法),此监听才生效 */
    }
}
