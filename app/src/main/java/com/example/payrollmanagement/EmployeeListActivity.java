package com.example.payrollmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.payrollmanagement.Adapters.EmployeeAdapter;
import com.example.payrollmanagement.api.employeeAPI;
import com.example.payrollmanagement.controller.EmployeeController;
import com.example.payrollmanagement.models.EmployeeModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmployeeListActivity extends AppCompatActivity {

    List<EmployeeModel> list;

    RecyclerView employeeRecView;
    EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        list = new ArrayList<>();
        employeeRecView = findViewById(R.id.employee_rec_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        employeeRecView.setLayoutManager(linearLayoutManager);
        employeeAdapter = new EmployeeAdapter(getApplicationContext(),list);
        employeeRecView.setAdapter(employeeAdapter);

        String BASE_URL = "http://10.0.2.2:8000/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        String status = "running";

        employeeAPI employeeAPI = retrofit.create(employeeAPI.class);
        Call<List<EmployeeModel>> call = employeeAPI.getPost();

        call.enqueue(new Callback<List<EmployeeModel>>() {
            @Override
            public void onResponse(Call<List<EmployeeModel>> call, Response<List<EmployeeModel>> response) {
                list = response.body();
                employeeAdapter.setList(list);

            }

            @Override
            public void onFailure(Call<List<EmployeeModel>> call, Throwable t) {

            }
        });

    }





}