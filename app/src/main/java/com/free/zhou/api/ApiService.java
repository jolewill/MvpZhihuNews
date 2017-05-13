package com.free.zhou.api;

import com.free.zhou.guide.bean.GuidePic;
import com.free.zhou.news.bean.DailyNews;
import com.free.zhou.news.bean.DailyNewsBefore;
import com.free.zhou.newsinfo.bean.NewsInfo;
import com.jaydenxiao.common.basebean.BaseRespose;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zskzh on 2017/5/1.
 */

public interface ApiService {
    @GET("7/prefetch-launch-images/1080*1920")
    Observable<GuidePic> getPic();

    @GET("4/news/latest")
    Observable<DailyNews> getLastestNews();

    @GET("4/news/before/{date}")
    Observable<DailyNewsBefore> getDailyNewsBefore(@Path("date") String date);

    @GET("4/news/{id}")
    Observable<NewsInfo> getNewsInfo(@Path("id") String id);




}
