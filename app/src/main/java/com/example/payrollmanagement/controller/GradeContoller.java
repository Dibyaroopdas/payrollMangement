package com.example.payrollmanagement.controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.payrollmanagement.MainActivity;
import com.example.payrollmanagement.api.gradeAPI;
import com.example.payrollmanagement.models.EmployeeGradeModel;
import com.example.payrollmanagement.models.GradeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GradeContoller {

    Context context;

    public GradeContoller(Context context) {
        this.context = context;
    }

    String  status;
    static final String BASE_URL = "http://10.0.2.2:8000/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    gradeAPI gradeAPI = retrofit.create(gradeAPI.class);

    public void startActIntent()
    {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public void getSinglePost(int id)
    {
        Call<List<GradeModel>> call = gradeAPI.getSinglePost(id);
        call.enqueue(new Callback<List<GradeModel>>() {
            @Override
            public void onResponse(Call<List<GradeModel>> call, Response<List<GradeModel>> response) {
                startActIntent();
            }

            @Override
            public void onFailure(Call<List<GradeModel>> call, Throwable t) {

            }
        });
    }

    public void getPost()
    {
        Call<List<GradeModel>> call = gradeAPI.getPost();
        call.enqueue(new Callback<List<GradeModel>>() {
            @Override
            public void onResponse(Call<List<GradeModel>> call, Response<List<GradeModel>> response) {

            }

            @Override
            public void onFailure(Call<List<GradeModel>> call, Throwable t) {

            }
        });
    }

    public void createPost(GradeModel gradeModel)
    {
        Call<GradeModel> call = gradeAPI.createPost(gradeModel);
        call.enqueue(new Callback<GradeModel>() {
            @Override
            public void onResponse(Call<GradeModel> call, Response<GradeModel> response) {
                startActIntent();
            }

            @Override
            public void onFailure(Call<GradeModel> call, Throwable t) {

            }
        });
    }

    public void updatePost(GradeModel gradeModel, int id)
    {
        Call<GradeModel> call = gradeAPI.updatePost(gradeModel,id);
        call.enqueue(new Callback<GradeModel>() {
            @Override
            public void onResponse(Call<GradeModel> call, Response<GradeModel> response) {
                startActIntent();
            }

            @Override
            public void onFailure(Call<GradeModel> call, Throwable t) {

            }
        });
    }

    public void deletePost(int id)
    {
        Call<List<GradeModel>> call = gradeAPI.deletePost(id);
        call.enqueue(new Callback<List<GradeModel>>() {
            @Override
            public void onResponse(Call<List<GradeModel>> call, Response<List<GradeModel>> response) {
                startActIntent();
            }

            @Override
            public void onFailure(Call<List<GradeModel>> call, Throwable t) {

            }
        });
    }

}
