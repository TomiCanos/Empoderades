package com.example.admin.empoderades.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.empoderades.R;
import com.example.admin.empoderades.holders.NewViewHolder;
import com.example.admin.empoderades.model.New;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter {

    private List<New> news = new ArrayList<>();

    public void setData(final List<New> data) {
        news.clear();
        news.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        final View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.news_item_view, viewGroup, false);
        return new NewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        ((NewViewHolder) viewHolder).onBind(news.get(viewHolder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return news.size();
    }
}