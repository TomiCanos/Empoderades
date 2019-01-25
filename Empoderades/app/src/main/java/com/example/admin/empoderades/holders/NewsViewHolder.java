package com.example.admin.empoderades.holders;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.admin.empoderades.R;
import com.example.admin.empoderades.model.News;
import retrofit2.http.Url;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    private News news;
    private TextView newsTitle;
    private TextView newsSource;
    private TextView newsPublishedTime;
    private ImageView newsImage;

    public NewsViewHolder(@NonNull final View itemView) {
        super(itemView);
        newsTitle = itemView.findViewById(R.id.news_title);
        newsSource = itemView.findViewById(R.id.news_source);
        newsImage = itemView.findViewById(R.id.news_image);
        newsPublishedTime = itemView.findViewById(R.id.news_published_time);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(itemView.getContext(), Uri.parse(news.getUrl()));
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(itemView.getContext(), "Agregado a favoritos", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    public void onBind(final News newItem) {
        news = newItem;
        newsTitle.setText(newItem.getTitle());
        newsSource.setText(newItem.getSource().getName());
        newsPublishedTime.setText(newItem.getPublishedAt());
        Glide.with(itemView).load(newItem.getUrlToImage()).into(newsImage);
    }

}
