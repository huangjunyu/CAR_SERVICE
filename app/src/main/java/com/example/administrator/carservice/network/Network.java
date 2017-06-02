package com.example.administrator.carservice.network;

import com.example.administrator.carservice.RequestApi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/12/11.
 */
public class Network {
    public static RequestApi requestApi;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    static OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request request = chain.request();
                    Request.Builder builder1 = request.newBuilder();
                    Request build = builder1.addHeader("Authorization", "APPCODE 043d0512fe5e4e04a328a9d6552e5923").build();
                    return chain.proceed(build);
                }
            }).retryOnConnectionFailure(true)
            .build();

    public static RequestApi getRequestApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://112.74.13.51:8080/carmgr/")
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
        requestApi = retrofit.create(RequestApi.class);
    return requestApi;
    }

    public static RequestApi getInforApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://jisunews.market.alicloudapi.com")
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
        requestApi = retrofit.create(RequestApi.class);
        return requestApi;
    }
    public static RequestApi getNews(){
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://jisunews.market.alicloudapi.com")
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
        requestApi = retrofit.create(RequestApi.class);
        return requestApi;
    }
}
