package com.free.zhou.guide;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.free.zhou.guide.Presenter.GuidePagePresenter;
import com.free.zhou.guide.bean.GuidePic;
import com.free.zhou.guide.contract.GuideImageContract;
import com.free.zhou.guide.model.GuidePageModel;
import com.free.zhou.helper.MyTimer;
import com.free.zhou.mvpzhihunews.MainActivity;
import com.free.zhou.mvpzhihunews.R;
import com.jaydenxiao.common.base.BaseActivity;
import com.orhanobut.logger.Logger;

import butterknife.Bind;

public class GuideActivity extends BaseActivity<GuidePagePresenter, GuidePageModel> implements GuideImageContract.View {
    @Bind(R.id.imageView)
    protected ImageView imageView;
    int count = 5000;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  getWindow().requestFeature(Window.FEATURE_NO_TITLE);

    }

    @Override
    public int getLayoutId() {


        return R.layout.activity_guide;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
          /*  window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);*/
            // window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
          //  window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
           /* window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);*/


        }

        mPresenter.loadNewPic();
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }

    @Override
    public void returnNewPic(GuidePic guidePic) {
        Logger.d("sjsjs", guidePic.getCreatives().get(0).getImpression_tracks().get(0));
        Glide.with(this).load(guidePic.getCreatives().get(0).getUrl()).centerCrop().into(imageView);
        MyTimer myTimer = new MyTimer(count, 1000, this, MainActivity.class);
        myTimer.start();
    }
}
