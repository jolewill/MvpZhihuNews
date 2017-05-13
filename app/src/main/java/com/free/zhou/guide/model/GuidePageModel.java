package com.free.zhou.guide.model;

import com.free.zhou.api.Api;
import com.free.zhou.api.ApiService;
import com.free.zhou.guide.bean.GuidePic;
import com.free.zhou.guide.contract.GuideImageContract;
import com.jaydenxiao.common.baserx.RxSchedulers;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by zskzh on 2017/5/1.
 */

public class GuidePageModel implements GuideImageContract.Model {

    @Override
    public Observable<GuidePic> loadPic() {
        return Api.getDefault().getPic().compose(RxSchedulers.<GuidePic>io_main());
    }
}
