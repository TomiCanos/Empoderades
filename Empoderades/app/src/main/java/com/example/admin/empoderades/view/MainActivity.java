package com.example.admin.empoderades.view;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.admin.empoderades.R;
import com.example.admin.empoderades.model.News;
import com.example.admin.empoderades.presenter.retrofit.NewsDAO;
import com.example.admin.empoderades.presenter.retrofit.ResultListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<News> news;
    private Button getNews;
    private NewsDAO newsDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsDAO = new NewsDAO();
        getNews = findViewById(R.id.getNewsButton);

        getNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsDAO.getNewsAsync(new ResultListener<List<News>>() {
                    @Override
                    public void finish(List<News> resultado) {
                        news = resultado;
                    }
                });
            }
        });
    }
}
