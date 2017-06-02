package com.example.administrator.carservice;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.carservice.Base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    private Fragment newsFragment;
    private Fragment fragment2;
    private Fragment fragment3;
    private Fragment fragment4;
    //    @BindView(R.id.main_tl)
    protected TabLayout tabLayout;
    //    @BindView(R.id.main_viewpager)
    ViewPager viewPager;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private List<Fragment> fragments = new ArrayList<>();
    private int[] tabIcons = {
            R.drawable.home,
            R.drawable.wait_pay_tab,
            R.drawable.wait_use_tab,
            R.drawable.going_tab,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ButterKnife.bind(this);
        initFragment();
    }

    private void initFragment() {
        tabLayout = (TabLayout) findViewById(R.id.main_tl);
        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        newsFragment = new NewsFragment();
        fragment2 = new BlankFragment();
        fragment3 = new BlankFragment();
        fragment4 = new BlankFragment();
        fragments.add(newsFragment);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);
        mTitleList.add("待付款");
        mTitleList.add("待使用");
        mTitleList.add("进行中");
        mTitleList.add("已完成");

        tabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments, mTitleList);
        viewPager.setAdapter(myFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        viewPager.setCurrentItem(1);
        viewPager.setCurrentItem(0);//直接设置0的话竟然不起作用,好吧.就这样迂回一下吧
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setCustomView(getTabView(0));//返回一个view，可以自由定义布局
        tabLayout.getTabAt(1).setCustomView(getTabView(1));
        tabLayout.getTabAt(2).setCustomView(getTabView(2));
        tabLayout.getTabAt(3).setCustomView(getTabView(3));
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.main_tab, null);
        TextView txt_title = (TextView) view.findViewById(R.id.txt_title);
        txt_title.setText(mTitleList.get(position));
        ImageView img_title = (ImageView) view.findViewById(R.id.img_title);
        img_title.setImageResource(tabIcons[position]);
        return view;
    }
}
