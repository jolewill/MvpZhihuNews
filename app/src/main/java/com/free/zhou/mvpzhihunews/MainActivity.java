package com.free.zhou.mvpzhihunews;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import android.view.ViewOverlay;

import com.free.zhou.news.adapter.StoryRvAdapter;
import com.free.zhou.news.bean.DailyNews;
import com.free.zhou.news.bean.DailyNewsBefore;
import com.free.zhou.news.bean.StoriesBean;
import com.free.zhou.news.contract.StoryContract;
import com.free.zhou.news.model.DailyNewsModel;
import com.free.zhou.news.presenter.DailyNewsPresenter;
import com.free.zhou.newsinfo.NewsInfoActivity;
import com.free.zhou.newsinfo.bean.NewsInfo;
import com.github.nukc.LoadMoreWrapper.LoadMoreAdapter;
import com.github.nukc.LoadMoreWrapper.LoadMoreWrapper;
import com.jaydenxiao.common.base.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity<DailyNewsPresenter, DailyNewsModel> implements StoryContract.View, SwipeRefreshLayout.OnRefreshListener, StoryRvAdapter.OnClickListen {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rvNews)
    RecyclerView rvNews;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private LinearLayoutManager layoutManager;
    private List<Object> objectList = new ArrayList<>();
    private StoryRvAdapter storyRvAdapter;

    private int page = 1;

    private int firstVisibleItem;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        toolbar.setTitle("知乎日报");
        setSupportActionBar(toolbar);

        swipeRefreshLayout
                .setColorSchemeColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimary));
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                onRefresh();
            }
        });

        swipeRefreshLayout.setOnRefreshListener(this);
        storyRvAdapter = new StoryRvAdapter(objectList, this, MainActivity.this);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvNews.setLayoutManager(layoutManager);
        rvNews.setAdapter(storyRvAdapter);
        // mPresenter.getLastestStory();
        storyRvAdapter.setOnClickListen(this);

        LoadMoreWrapper.with(storyRvAdapter)
                .setFooterView(R.layout.footer) // view or layout resource
                .setShowNoMoreEnabled(true) // enable show NoMoreView，default false
                .setListener(new LoadMoreAdapter.OnLoadMoreListener() {
                    @Override
                    public void onLoadMore(LoadMoreAdapter.Enabled enabled) {
                        //do something
                        //you can enabled.setLoadMoreEnabled(false) when do not need load more
                        if (objectList == null) {
                            enabled.setLoadMoreEnabled(false);
                        } else
                            onPullUpRefresh();
                    }
                }).into(rvNews);


    }


    void onPullUpRefresh() {
        mPresenter.getStoryBefore(getDate(page));
        page++;
    }

    public String getDate(int i) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = calendar.getTime();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -i);
        //  Log.e("date", format.format(calendar.getTime()));
        String a = format.format(calendar.getTime());
        return a;
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
    public void returnLastestStory(DailyNews dailyNews) {
        swipeRefreshLayout.setRefreshing(false);
        objectList.add(dailyNews.getTop_stories());
        Log.e("djdjd", "dddd");
        objectList.addAll(dailyNews.getStories());
        storyRvAdapter.notifyDataSetChanged();
    }

    @Override
    public void returnBeforeStory(DailyNewsBefore dailyNewsBefore) {
        swipeRefreshLayout.setRefreshing(false);
        objectList.addAll(dailyNewsBefore.getStories());
        storyRvAdapter.notifyDataSetChanged();
    }

    @Override
    public void returnWrong(String message) {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        mPresenter.getLastestStory();
    }

    @Override
    public void onClick(StoriesBean storiesBean, int position, View view) {


        Bundle bundle = new Bundle();
        ActivityOptionsCompat sceneTransitionAnimation;
        final Bundle transitionBundle;

        bundle.putString("ID", storiesBean.getId() + "");
        setTransitionName(view, storiesBean);

        final Pair pairs =
                new Pair<>(view.findViewById(R.id.iv_title), getResources().getString(R.string.transition));
        sceneTransitionAnimation = ActivityOptionsCompat
                .makeSceneTransitionAnimation(MainActivity.this, pairs);

        //view.getRootView().findViewById(R.id.iv_title).setTransitionName(((LastestNews.TopStoriesBean) o).getId() + "");
        transitionBundle = sceneTransitionAnimation.toBundle();


        Intent intent = new Intent(this, NewsInfoActivity.class);
        intent.putExtras(bundle);

        // Get the transition name from the string

        //Start the Intent


        ActivityCompat.startActivity(this, intent, transitionBundle);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setTransitionName(View view, Object o) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {

        } else {


            view.findViewById(R.id.cardView).setTransitionName(((StoriesBean) o).getId() + "card1");

            view.findViewById(R.id.iv_title).setTransitionName(((StoriesBean) o).getId() + "image");

            getWindow().setReenterTransition(TransitionInflater.from(this).inflateTransition(R.transition.shared));
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    private ViewOverlay getView(View view) {
        return view.findViewById(R.id.iv_title).getOverlay();
    }

}

