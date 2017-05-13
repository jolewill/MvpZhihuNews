package com.free.zhou.newsinfo;

import android.os.Build;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.free.zhou.mvpzhihunews.R;
import com.free.zhou.newsinfo.bean.NewsInfo;
import com.free.zhou.newsinfo.contract.NewsInfoContract;
import com.free.zhou.newsinfo.model.NewsModel;
import com.free.zhou.newsinfo.presenter.MewInfoPresenter;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsInfoActivity extends BaseActivity<MewInfoPresenter, NewsModel> implements NewsInfoContract.View {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.iv_title)
    ImageView imageView;

    @Bind(R.id.nestedScrollview)
    NestedScrollView scrollView;

    @Bind(R.id.wv_info)
    WebView webView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_news_info;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {

        setContentView(R.layout.activity_news_info);
        ButterKnife.bind(this);
       /* if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(TransitionInflater.from(this).inflateTransition(
                    R.transition.news_exit));

        }*/
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.setVisibility(View.GONE);
                supportFinishAfterTransition();
            }
        });

        String id = getIntent().getExtras().getString("ID");
        String title = getIntent().getExtras().getString("title");
        mPresenter.getNewsInfo(id);
    }

    @Override
    protected void onResume() {
        super.onResume();
       /* if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setReturnTransition(TransitionInflater.from(this).inflateTransition(
                    R.transition.shared));
        }*/
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
    public void ReturnNewInfoSuccess(NewsInfo newsInfo) {

        Glide.with(this).load(newsInfo.getImage()).into(imageView);
               /* webView.loadData(newsInfo.getBody(), "text/html", "UTF-8");
                webView.loadData(newsInfo.getCss().get(0), "text/css", "UTF-8");*/


        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"img-wrap\">")
                .append("<div class=\"img-mask\"></div>");
        String mNewsContent = "<link rel=\"stylesheet\" type=\"text/css\" href=\"news_content_style.css\"/>"
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"news_header_style.css\"/>"
                + newsInfo.getBody().replace("<div class=\"img-place-holder\">", sb.toString());
        webView.loadDataWithBaseURL("file:///android_asset/", mNewsContent, "text/html", "UTF-8", null);
               /* OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(newsInfo.getCss().get(0)).build();
                try {
                    okhttp3.Response response = okHttpClient.newCall(request).execute();
                    if (response.isSuccessful()) {
                        String css = response.body().string();

                    } else {
                        Log.e("something went wrong", "something");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
    }

    @Override
    public void ReturnNewInfoFail(String msg) {

    }
}
