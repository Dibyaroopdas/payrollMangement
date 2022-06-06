package com.example.payrollmanagement;
import android.util.Log;

import com.example.payrollmanagement.api.userAPI;
import com.example.payrollmanagement.models.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller{

    UserModel userModel;

    public Controller(UserModel userModel) {
        this.userModel = userModel;
    }

    static final String BASE_URL = "http://10.0.2.2:8000/";

    public void start() {
        Log.d("API",userModel.getUser_name());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userAPI userAPI = retrofit.create(userAPI.class);


        Call<UserModel> call = userAPI.createPost(userModel);
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                Log.d("API","DATA ADDED SUCCESSFULLY");
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.d("API","DATA ADDITION FAILED");
            }
        });
    }
}
