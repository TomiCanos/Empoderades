package com.example.admin.empoderades.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.empoderades.R;
import com.example.admin.empoderades.model.News;

public class NewViewHolder extends RecyclerView.ViewHolder {

    private TextView newsTitle;
    private TextView newsSource;
    private TextView newsPublishedTime;
    private ImageView newsImage;

    public NewViewHolder(@NonNull final View itemView) {
        super(itemView);
        newsTitle = itemView.findViewById(R.id.news_title);
        newsSource = itemView.findViewById(R.id.news_source);
        newsImage = itemView.findViewById(R.id.news_image);
        newsPublishedTime = itemView.findViewById(R.id.news_published_time);
    }

    public void onBind(final News newItem) {
        newsTitle.setText(newItem.getTitle());
        newsSource.setText(newItem.getSource().getName());
        newsPublishedTime.setText(newItem.getPublishedAt());
        Glide.with(itemView).load(newItem.getUrlToImage()).into(newsImage);
    }

}
