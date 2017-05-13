package com.free.zhou.guide.contract;

import android.provider.MediaStore;

import com.free.zhou.guide.bean.GuidePic;
import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

import java.util.List;

import rx.Observable;


/**
 * Created by zskzh on 2017/5/1.
 */

public interface GuideImageContract {

    interface Model extends BaseModel {
        public Observable<GuidePic> loadPic();
    }

    interface View extends BaseView {
        public void returnNewPic(GuidePic guidePic);
    }

    abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void loadNewPic();
    }

}
