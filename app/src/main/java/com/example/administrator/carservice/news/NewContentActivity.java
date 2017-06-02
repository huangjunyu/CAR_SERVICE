package com.example.administrator.carservice.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.carservice.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;

public class NewContentActivity extends AppCompatActivity {
    protected Subscription subscription;
    @BindView(R.id.content_title)
    TextView titleTv;
    @BindView(R.id.content_pic)
    ImageView picImg;
    @BindView(R.id.content_newscontent)
    TextView contentTv;
    @BindView(R.id.content_time)
    TextView timeTv;
    @BindView(R.id.contentFrom)
    TextView fromTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_content);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        Log.e("bundl",bundle.getString("newsPic"));
        titleTv.setText(bundle.getString("newsTitle"));
        timeTv.setText(bundle.getString("newsTime"));
        Glide.with(this).load(bundle.getString("newsPic")).into(picImg);
        contentTv.setText(bundle.getString("newsContent"));
        fromTv.setText(bundle.getString("newsFrom"));
    }

}
