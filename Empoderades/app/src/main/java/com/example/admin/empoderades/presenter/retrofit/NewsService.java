package com.example.admin.empoderades.presenter.retrofit;

import com.example.admin.empoderades.model.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NewsService {

    @GET("/v2/everything?q=feminista&sortBy=publishedAt&language=es&apiKey=efeb5f40bf49468e8f07ee81bfe0a7a8")
    Call<News> getNews;

}
