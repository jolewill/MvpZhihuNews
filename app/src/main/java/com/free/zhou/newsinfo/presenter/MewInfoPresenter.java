package com.free.zhou.newsinfo.presenter;

import com.free.zhou.newsinfo.bean.NewsInfo;
import com.free.zhou.newsinfo.contract.NewsInfoContract;
import com.jaydenxiao.common.baserx.RxManager;
import com.jaydenxiao.common.baserx.RxSubscriber;

/**
 * Created by zskzh on 2017/5/13.
 */

public class MewInfoPresenter extends NewsInfoContract.Presenter {
    @Override
    public void getNewsInfo(String id) {
        mRxManage.add(mModel.getNewsInfo(id).subscribe(new RxSubscriber<NewsInfo>(mContext,false) {
            @Override
            protected void _onNext(NewsInfo newsInfo) {
                mView.ReturnNewInfoSuccess(newsInfo);
            }

            @Override
            protected void _onError(String message) {
                mView.ReturnNewInfoFail(message);
            }
        }));
    }
}
