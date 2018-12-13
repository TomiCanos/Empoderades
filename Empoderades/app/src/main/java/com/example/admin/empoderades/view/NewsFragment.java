package com.example.admin.empoderades.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.empoderades.R;
import com.example.admin.empoderades.adapters.NewsListAdapter;
import com.example.admin.empoderades.model.News;
import com.example.admin.empoderades.retrofit.NewsDAO;
import com.example.admin.empoderades.retrofit.ResultListener;

import java.util.List;

public class NewsFragment extends Fragment {
    private List<News> news;
    private NewsDAO newsDAO;
    private RecyclerView newsRecyclerView;
    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (view != null){
            return view;
        }
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        newsRecyclerView = view.findViewById(R.id.news_recycler_view);

        newsDAO = new NewsDAO();
        newsDAO.getNewsAsync(new ResultListener<List<News>>() {
            @Override
            public void finish(List<News> result) {
                news = result;
                loadData();
            }
        });

        return view;
    }


    public void loadData() {
        final NewsListAdapter newsAdapter = new NewsListAdapter();
        newsAdapter.setData(news);
        newsRecyclerView.setAdapter(newsAdapter);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onStop() {
        view = getView();
        super.onStop();
    }
}
