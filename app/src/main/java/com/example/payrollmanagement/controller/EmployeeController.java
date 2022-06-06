package com.example.payrollmanagement.controller;

import android.app.slice.SliceSpec;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.payrollmanagement.Adapters.EmployeeAdapter;
import com.example.payrollmanagement.EmployeeListActivity;
import com.example.payrollmanagement.MainActivity;
import com.example.payrollmanagement.R;
import com.example.payrollmanagement.api.employeeAPI;
import com.example.payrollmanagement.models.EmployeeModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmployeeController {

    Context context;

    public EmployeeController(Context context) {
        this.context = context;
    }

    int i;

    String  status;
    static final String BASE_URL = "http://10.0.2.2:8000/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    employeeAPI employeeAPI = retrofit.create(employeeAPI.class);

    List<EmployeeModel> list = new ArrayList<>();;
    EmployeeListActivity employeeListActivity = new EmployeeListActivity();

    public void startActIntent()
    {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public void getSinglePost(int id)
    {
        Call<List<EmployeeModel>> call = employeeAPI.getSinglePost(id);
        call.enqueue(new Callback<List<EmployeeModel>>() {
            @Override
            public void onResponse(Call<List<EmployeeModel>> call, Response<List<EmployeeModel>> response) {
                startActIntent();
            }

            @Override
            public void onFailure(Call<List<EmployeeModel>> call, Throwable t) {

            }
        });
    }

    public void getPost()
    {
        Call<List<EmployeeModel>> call = employeeAPI.getPost();
        call.enqueue(new Callback<List<EmployeeModel>>() {
            @Override
            public void onResponse(Call<List<EmployeeModel>> call, Response<List<EmployeeModel>> response) {


            }

            @Override
            public void onFailure(Call<List<EmployeeModel>> call, Throwable t) {
                i = 0;
            }
        });

    }

    public void createPost(EmployeeModel employeeModel)
    {

        Call<EmployeeModel> call = employeeAPI.createPost(employeeModel);
        call.enqueue(new Callback<EmployeeModel>() {
            @Override
            public void onResponse(Call<EmployeeModel> call, Response<EmployeeModel> response) {
                startActIntent();
            }

            @Override
            public void onFailure(Call<EmployeeModel> call, Throwable t) {
                Log.d("DEPT","dept_add_failed");
            }
        });

    }

    public void updatePost(EmployeeModel employeeModel, int id)
    {
        Call<EmployeeModel> call = employeeAPI.updatePost(employeeModel,id);
        call.enqueue(new Callback<EmployeeModel>() {
            @Override
            public void onResponse(Call<EmployeeModel> call, Response<EmployeeModel> response) {
                startActIntent();
            }

            @Override
            public void onFailure(Call<EmployeeModel> call, Throwable t) {

            }
        });
    }

    public void deletePost(int id)
    {
        Call<List<EmployeeModel>> call = employeeAPI.deletePost(id);
        call.enqueue(new Callback<List<EmployeeModel>>() {
            @Override
            public void onResponse(Call<List<EmployeeModel>> call, Response<List<EmployeeModel>> response) {
                startActIntent();
            }

            @Override
            public void onFailure(Call<List<EmployeeModel>> call, Throwable t) {

            }
        });
    }



}
