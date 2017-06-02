package com.example.administrator.carservice;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.carservice.Base.BaseFragment;
import com.example.administrator.carservice.news.NewsTabFragment;
//import com.example.administrator.carservice.news.InformationActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/3.
 */
public class NewsFragment extends BaseFragment {

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private String[] newsType;
    @BindView(R.id.news_viewpager)
    ViewPager viewPager;
    @BindView(R.id.news_tablayout)
    TabLayout tabLayout;
    public void initFragment(){
        newsType = getResources().getStringArray(R.array.news_type);
        //添加页卡标题
        for (int i = 0;i < newsType.length;i++){
            NewsTabFragment newsTabFragment = new NewsTabFragment();
            newsTabFragment.setParam(newsType[i]);
            fragments.add(newsTabFragment);
            mTitleList.add(newsType[i]);
            tabLayout.addTab(tabLayout.newTab().setText(newsType[i]));//添加tab选项卡
        }
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(),fragments,mTitleList);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setOffscreenPageLimit(15);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(myFragmentPagerAdapter);
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);
        initFragment();
        return view;
    }

    @Override
    protected void initData() {
    }
}

