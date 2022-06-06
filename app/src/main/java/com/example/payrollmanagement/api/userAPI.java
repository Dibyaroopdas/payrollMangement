package com.example.payrollmanagement.api;

import com.example.payrollmanagement.models.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface userAPI {

    @POST("/user/")
    Call<UserModel> createPost(@Body UserModel userModel);

}
