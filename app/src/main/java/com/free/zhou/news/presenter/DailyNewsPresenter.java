package com.free.zhou.news.presenter;

import android.util.Log;

import com.free.zhou.guide.bean.GuidePic;
import com.free.zhou.guide.contract.GuideImageContract;
import com.free.zhou.news.bean.DailyNews;
import com.free.zhou.news.bean.DailyNewsBefore;
import com.free.zhou.news.contract.StoryContract;
import com.jaydenxiao.common.baserx.RxSubscriber;
import com.jaydenxiao.common.commonutils.LogUtils;

/**
 * Created by zskzh on 2017/5/11.
 */

public class DailyNewsPresenter extends StoryContract.Presenter {
    @Override
    public void getLastestStory() {
        mRxManage.add(mModel.getLastestStory().subscribe(new RxSubscriber<DailyNews>(mContext, false) {

            @Override
            protected void _onNext(DailyNews dailyNews) {
                mView.returnLastestStory(dailyNews);
              //  LogUtils.loge("megegg", dailyNews.getDate());
            }

            @Override
            protected void _onError(String message) {
                mView.returnWrong(message);
            }
        }));
    }

    @Override
    public void getStoryBefore(String date) {
        mRxManage.add(mModel.getBeforStory(date).subscribe(new RxSubscriber<DailyNewsBefore>(mContext, false) {
            @Override
            protected void _onNext(DailyNewsBefore dailyNewsBefore) {
                mView.returnBeforeStory(dailyNewsBefore);
            }

            @Override
            protected void _onError(String message) {
                mView.returnWrong(message);
            }
        }));
    }
}
