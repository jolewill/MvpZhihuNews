package com.free.zhou.news.contract;

import com.free.zhou.guide.contract.GuideImageContract;
import com.free.zhou.news.bean.DailyNews;
import com.free.zhou.news.bean.DailyNewsBefore;
import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

import rx.Observable;

/**
 * Created by zskzh on 2017/5/1.
 */

public interface StoryContract {

    interface Model extends BaseModel {
        Observable<DailyNews> getLastestStory();

        Observable<DailyNewsBefore> getBeforStory(String date);
    }

    interface View extends BaseView {
        void returnLastestStory(DailyNews dailyNews);

        void returnBeforeStory(DailyNewsBefore dailyNewsBefore);

        void returnWrong(String message);
    }

    abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void getLastestStory();

        public abstract void getStoryBefore(String date);
    }
}
