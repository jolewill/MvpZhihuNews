package com.free.zhou.guide.Presenter;

import com.free.zhou.guide.bean.GuidePic;
import com.free.zhou.guide.contract.GuideImageContract;
import com.jaydenxiao.common.baserx.RxManager;
import com.jaydenxiao.common.baserx.RxSubscriber;

/**
 * Created by zskzh on 2017/5/1.
 */

public class GuidePagePresenter extends GuideImageContract.Presenter {
    @Override
    public void loadNewPic() {
        mRxManage.add(mModel.loadPic().subscribe(new RxSubscriber<GuidePic>(mContext, false) {
            @Override
            protected void _onNext(GuidePic guidePic) {
                mView.returnNewPic(guidePic);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }
}
