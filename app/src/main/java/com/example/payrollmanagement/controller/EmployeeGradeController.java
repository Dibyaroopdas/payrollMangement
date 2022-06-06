package com.example.payrollmanagement.controller;

import android.content.Context;
import android.content.Intent;

import com.example.payrollmanagement.MainActivity;
import com.example.payrollmanagement.api.employeeGradeAPI;
import com.example.payrollmanagement.models.EmployeeGradeModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmployeeGradeController {

    Context context;

    public EmployeeGradeController(Context context) {
        this.context = context;
    }

    String  status;
    static final String BASE_URL = "http://10.0.2.2:8000/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    employeeGradeAPI employeeGradeAPI = retrofit.create(employeeGradeAPI.class);

    public void startActIntent()
    {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }



    public List<EmployeeGradeModel> employeeGradeModelList = new ArrayList<>();

    public List<EmployeeGradeModel> getList(){
            return  employeeGradeModelList;
    }


    public void getSinglePost(int id)
    {
        Call<List<EmployeeGradeModel>> call = employeeGradeAPI.getSinglePost(id);
        call.enqueue(new Callback<List<EmployeeGradeModel>>() {
            @Override
            public void onResponse(Call<List<EmployeeGradeModel>> call, Response<List<EmployeeGradeModel>> response) {
                startActIntent();

            }

            @Override
            public void onFailure(Call<List<EmployeeGradeModel>> call, Throwable t) {

            }
        });
    }

    public void getPost()
    {

        Call<List<EmployeeGradeModel>> call = employeeGradeAPI.getPost();
        call.enqueue(new Callback<List<EmployeeGradeModel>>() {
            @Override
            public void onResponse(Call<List<EmployeeGradeModel>> call, Response<List<EmployeeGradeModel>> response) {
                employeeGradeModelList = response.body();

            }

            @Override
            public void onFailure(Call<List<EmployeeGradeModel>> call, Throwable t) {

            }
        });


    }

    public void createPost(EmployeeGradeModel employeeGradeModel)
    {
        Call<EmployeeGradeModel> call = employeeGradeAPI.createPost(employeeGradeModel);
        call.enqueue(new Callback<EmployeeGradeModel>() {
            @Override
            public void onResponse(Call<EmployeeGradeModel> call, Response<EmployeeGradeModel> response) {
                startActIntent();
            }

            @Override
            public void onFailure(Call<EmployeeGradeModel> call, Throwable t) {

            }
        });
    }

    public void updatePost(EmployeeGradeModel employeeGradeModel, int id)
    {
        Call<EmployeeGradeModel> call = employeeGradeAPI.updatePost(employeeGradeModel,id);
        call.enqueue(new Callback<EmployeeGradeModel>() {
            @Override
            public void onResponse(Call<EmployeeGradeModel> call, Response<EmployeeGradeModel> response) {
                startActIntent();
            }

            @Override
            public void onFailure(Call<EmployeeGradeModel> call, Throwable t) {

            }
        });
    }

    public void deletePost(int id)
    {
        Call<List<EmployeeGradeModel>> call = employeeGradeAPI.deletePost(id);
        call.enqueue(new Callback<List<EmployeeGradeModel>>() {
            @Override
            public void onResponse(Call<List<EmployeeGradeModel>> call, Response<List<EmployeeGradeModel>> response) {
                startActIntent();
            }

            @Override
            public void onFailure(Call<List<EmployeeGradeModel>> call, Throwable t) {

            }
        });
    }
}
