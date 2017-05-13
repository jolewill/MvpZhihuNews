package com.free.zhou.news.model;

import com.free.zhou.api.Api;
import com.free.zhou.news.bean.DailyNews;
import com.free.zhou.news.bean.DailyNewsBefore;
import com.free.zhou.news.contract.StoryContract;
import com.jaydenxiao.common.baserx.RxSchedulers;

import rx.Observable;

/**
 * Created by zskzh on 2017/5/11.
 */

public class DailyNewsModel implements StoryContract.Model {
    @Override
    public Observable<DailyNews> getLastestStory() {
        return Api.getDefault().getLastestNews().compose(RxSchedulers.<DailyNews>io_main());
    }

    @Override
    public Observable<DailyNewsBefore> getBeforStory(String date) {
        return Api.getDefault().getDailyNewsBefore(date).compose(RxSchedulers.<DailyNewsBefore>io_main());
    }

}
