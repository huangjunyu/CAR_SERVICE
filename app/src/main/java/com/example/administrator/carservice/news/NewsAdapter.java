package com.example.administrator.carservice.news;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.carservice.R;

import java.util.List;

/**
 * Created by Administrator on 2016/12/25.
 */
public class NewsAdapter extends BaseQuickAdapter<NewsBody, BaseViewHolder> {
    Activity activity;
    ImageView img;

    public NewsAdapter(Activity activity, List<NewsBody> data) {
        super(R.layout.item_news, data);
        this.activity = activity;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, NewsBody newsBody) {
        baseViewHolder.setText(R.id.item_news_title, newsBody.getResult().getList()
                .get(baseViewHolder.getAdapterPosition()).getTitle());
        baseViewHolder.setTextColor(R.id.item_news_title, ContextCompat.getColor(activity,R.color.colorAccent));
//        baseViewHolder.setOnItemClickListener(R.)
        baseViewHolder.setText(R.id.item_news_from, newsBody.getResult().getList()
                .get(baseViewHolder.getAdapterPosition()).getSrc());
        Log.e("imgg",newsBody.getResult().getList()
                .get(baseViewHolder.getAdapterPosition()).getPic() + "," + newsBody.getResult().getList()
                .get(baseViewHolder.getAdapterPosition()).getTitle());
        Glide.with(activity).load(newsBody.getResult().getList()
                .get(baseViewHolder.getAdapterPosition()).getPic())
                .centerCrop().into((ImageView) baseViewHolder.getView(R.id.item_news_pic));
    }
}
