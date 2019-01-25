package com.example.admin.empoderades.retrofit;

import com.example.admin.empoderades.model.NewsContainer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface NewsService {

    @GET("/v2/everything")
    Call<NewsContainer> getNews(@Query("q") String q, @Query("sortBy") String sortBy,
                                @Query("language") String language, @Query("apiKey") String apiKey);

}
