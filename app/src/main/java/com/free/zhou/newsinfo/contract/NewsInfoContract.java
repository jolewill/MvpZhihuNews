package com.free.zhou.newsinfo.contract;

import com.free.zhou.news.contract.StoryContract;
import com.free.zhou.newsinfo.bean.NewsInfo;
import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

import rx.Observable;

/**
 * Created by zskzh on 2017/5/13.
 */

public interface NewsInfoContract {

    interface Model extends BaseModel {
        Observable<NewsInfo> getNewsInfo(String id);
    }

    interface View extends BaseView {
        void ReturnNewInfoSuccess(NewsInfo newsInfo);

        void ReturnNewInfoFail(String msg);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getNewsInfo(String id);
    }
}
