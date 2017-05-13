package com.free.zhou.newsinfo.model;

import com.free.zhou.api.Api;
import com.free.zhou.newsinfo.bean.NewsInfo;
import com.free.zhou.newsinfo.contract.NewsInfoContract;
import com.jaydenxiao.common.baserx.RxSchedulers;

import rx.Observable;

/**
 * Created by zskzh on 2017/5/13.
 */

public class NewsModel implements NewsInfoContract.Model {

    @Override
    public Observable<NewsInfo> getNewsInfo(String id) {
        return Api.getDefault().getNewsInfo(id).compose(RxSchedulers.<NewsInfo>io_main());
    }
}
