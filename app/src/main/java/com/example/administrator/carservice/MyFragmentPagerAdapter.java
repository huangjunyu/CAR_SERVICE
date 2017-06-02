package com.example.administrator.carservice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/1.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    public MyFragmentPagerAdapter(FragmentManager fragmentManager, List<Fragment> fragments, List<String> mTitleList){
        super(fragmentManager);
        this.mTitleList = mTitleList;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position%fragments.size());
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.mTitleList.get(position);
    }
}
