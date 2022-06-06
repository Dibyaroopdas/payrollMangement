package com.example.payrollmanagement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PlaceholderAPI {
    @GET("/")
    Call<List<PlaceholderPost>> loadChanges(@Query("q") String status);

    @GET("/user/1")
    Call<List<PlaceholderPost>> loadChanges1(@Query("q") String status);

    @POST("/")
    Call<PlaceholderPost> createPost(@Body PlaceholderPost placeholderPost);
}
