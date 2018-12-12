package com.example.admin.empoderades.view;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import com.example.admin.empoderades.R;
import com.example.admin.empoderades.adapters.NewsListAdapter;
import com.example.admin.empoderades.model.New;
import com.example.admin.empoderades.presenter.retrofit.NewsDAO;
import com.example.admin.empoderades.presenter.retrofit.ResultListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<New> news;
    private Button getNews;
    private NewsDAO newsDAO;
    private RecyclerView newsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsRecyclerView = findViewById(R.id.news_recycler_view);

        newsDAO = new NewsDAO();
        newsDAO.getNewsAsync(new ResultListener<List<New>>() {
            @Override
            public void finish(List<New> result) {
                news = result;
                loadData();
            }
        });
    }

    public void loadData() {
        final NewsListAdapter newsAdapter = new NewsListAdapter();
        newsAdapter.setData(news);
        newsRecyclerView.setAdapter(newsAdapter);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
