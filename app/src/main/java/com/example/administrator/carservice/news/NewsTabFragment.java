package com.example.administrator.carservice.news;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.administrator.carservice.R;
import com.example.administrator.carservice.network.Network;
import com.example.administrator.carservice.utils.RecyclerViewDivider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewsTabFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    protected Subscription subscription;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    private Context context;
    private int currentPage;
    protected NewsAdapter newsAdapter;
    private boolean isInitCache = false;
    protected List<NewsBody> newsBodyList;
    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    protected void initData() {
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new RecyclerViewDivider(getActivity(),LinearLayoutManager.HORIZONTAL,1, ContextCompat.getColor(getActivity(),R.color.gray_divide)));
        refreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        refreshLayout.setOnRefreshListener(this);
        //开启loading,获取数据
        setRefreshing(true);
        onRefresh();
        recyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Log.e("iii",i + newsBodyList.get(i).getResult().getList().get(i).getUrl());
                Intent newsContentIntent = new Intent(getActivity(),NewsContentActivity.class);
                newsContentIntent.putExtra("newsTitle",newsBodyList.get(i).getResult().getList().get(i).getTitle())
                .putExtra("newsContent",Html.fromHtml(newsBodyList.get(i).getResult().getList().get(i).getContent()).toString())
                        .putExtra("newsPic",newsBodyList.get(i).getResult().getList().get(i).getPic())
                        .putExtra("newsFrom",newsBodyList.get(i).getResult().getList().get(i).getSrc())
                        .putExtra("newsTime",newsBodyList.get(i).getResult().getList().get(i).getTime());
                newsContentIntent.putExtra("webUrl",newsBodyList.get(i).getResult().getList().get(i).getWeburl());
                startActivity(newsContentIntent);


            }
        });
    }

    public void showToast(String msg) {
        Snackbar.make(recyclerView, msg, Snackbar.LENGTH_SHORT).show();
    }

    public void setRefreshing(final boolean refreshing) {
        subscription = Network.getInforApi()
                .newsPost(getParam(), "40")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(refreshing);
            }
        });
    }

    @Override
    public void onRefresh() {
        setRefreshing(true);
    }

    Observer<NewsBody> observer = new Observer<NewsBody>() {
        @Override
        public void onCompleted() {
        }
        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(NewsBody newsBody) {
            newsBodyList = new ArrayList<>();
            for (int i = 0; i < newsBody.getResult().getList().size(); i++) {

                newsBodyList.add(newsBody);
            }
            newsAdapter = new NewsAdapter(getActivity(),newsBodyList);
            newsAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
            newsAdapter.isFirstOnly(false);
            recyclerView.setAdapter(newsAdapter);
            refreshLayout.setRefreshing(false);
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        unsubscribe();
    }

    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}