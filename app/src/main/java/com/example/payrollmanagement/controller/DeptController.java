package com.example.payrollmanagement.controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.payrollmanagement.MainActivity;
import com.example.payrollmanagement.api.deptAPI;
import com.example.payrollmanagement.api.userAPI;
import com.example.payrollmanagement.models.DeptModel;
import com.example.payrollmanagement.models.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DeptController {

    Context context;
    String status;
    public DeptController(Context context) {
        this.context = context;
    }

    static final String BASE_URL = "http://10.0.2.2:8000/";


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    deptAPI deptAPI= retrofit.create(deptAPI.class);

    public void startActIntent()
    {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public void getSinglePost(int id) {
        Call<List<DeptModel>> call = deptAPI.getSinglePost(id);
        call.enqueue(new Callback<List<DeptModel>>() {
            @Override
            public void onResponse(Call<List<DeptModel>> call, Response<List<DeptModel>> response) {
                startActIntent();
            }

            @Override
            public void onFailure(Call<List<DeptModel>> call, Throwable t) {

            }
        });
    }

    public void getPost() {
        Call<List<DeptModel>> call = deptAPI.getPost();
        call.enqueue(new Callback<List<DeptModel>>() {
            @Override
            public void onResponse(Call<List<DeptModel>> call, Response<List<DeptModel>> response) {
                startActIntent();
            }

            @Override
            public void onFailure(Call<List<DeptModel>> call, Throwable t) {

            }
        });

    }

    public void createDept(DeptModel deptModel) {
        Call<DeptModel> call = deptAPI.createPost(deptModel);
        call.enqueue(new Callback<DeptModel>() {
            @Override
            public void onResponse(Call<DeptModel> call, Response<DeptModel> response) {
                startActIntent();
            }

            @Override
            public void onFailure(Call<DeptModel> call, Throwable t) {

            }
        });
    }

    public void updatePost(DeptModel deptModel, int id) {
        Call<DeptModel> call = deptAPI.updatePost(deptModel,id);
        call.enqueue(new Callback<DeptModel>() {
            @Override
            public void onResponse(Call<DeptModel> call, Response<DeptModel> response) {
                startActIntent();
            }

            @Override
            public void onFailure(Call<DeptModel> call, Throwable t) {

            }
        });
    }

    public void deletePost(int id) {
        Call<List<DeptModel>> call = deptAPI.deletePost(id);
        call.enqueue(new Callback<List<DeptModel>>() {
            @Override
            public void onResponse(Call<List<DeptModel>> call, Response<List<DeptModel>> response) {
                startActIntent();
            }

            @Override
            public void onFailure(Call<List<DeptModel>> call, Throwable t) {

            }
        });
    }





}
