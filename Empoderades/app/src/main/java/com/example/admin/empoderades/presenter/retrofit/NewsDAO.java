package com.example.admin.empoderades.presenter.retrofit;

import com.example.admin.empoderades.model.News;
import com.example.admin.empoderades.model.NewsContainer;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

public class NewsDAO {
    private Retrofit retrofit;

    public NewsDAO() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create());

        retrofit = retrofitBuilder.client(httpClient.build()).build();
    }

    public void getNewsAsync(final ResultListener<List<News>> listener) {
        NewsService newsService = retrofit.create(NewsService.class);
        Call<NewsContainer> call = newsService.getNews();
        call.enqueue(new Callback<NewsContainer>() {
            @Override
            public void onResponse(Call<NewsContainer> call, Response<NewsContainer> response) {
                listener.finish(response.body().getArticles());
            }

            @Override
            public void onFailure(Call<NewsContainer> call, Throwable t) {
                listener.finish(new ArrayList<News>());
            }
        });
    }
}
