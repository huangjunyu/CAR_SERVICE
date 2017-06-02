package com.example.administrator.carservice;

import com.example.administrator.carservice.news.NewsBody;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/12/11.
 */
public interface RequestApi {//网络请求接口
    @GET("/news/channel")
    Observable<NewsTypeListBean> inforPost();
    @GET("/news/get")
    Observable<NewsBody> newsPost(@Query("channel") String channel,@Query("num") String num);
}
