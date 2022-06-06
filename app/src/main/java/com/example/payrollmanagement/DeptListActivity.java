
package com.example.payrollmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.payrollmanagement.Adapters.DeptAdapter;
import com.example.payrollmanagement.Adapters.EmployeeAdapter;
import com.example.payrollmanagement.api.deptAPI;
import com.example.payrollmanagement.api.employeeAPI;
import com.example.payrollmanagement.models.DeptModel;
import com.example.payrollmanagement.models.EmployeeModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DeptListActivity extends AppCompatActivity {

    List<DeptModel> list;

    RecyclerView deptRecView;
    DeptAdapter deptAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dept_list);

        list = new ArrayList<>();
        deptRecView = findViewById(R.id.dept_rec_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        deptRecView.setLayoutManager(linearLayoutManager);
        deptAdapter = new DeptAdapter(getApplicationContext(),list);
        deptRecView.setAdapter(deptAdapter);

        String BASE_URL = "http://10.0.2.2:8000/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        String status = "running";

        deptAPI deptAPI = retrofit.create(deptAPI.class);
        Call<List<DeptModel>> call = deptAPI.getPost();

        call.enqueue(new Callback<List<DeptModel>>() {
            @Override
            public void onResponse(Call<List<DeptModel>> call, Response<List<DeptModel>> response) {
                list = response.body();
                deptAdapter.setList(list);
            }

            @Override
            public void onFailure(Call<List<DeptModel>> call, Throwable t) {

            }
        });

    }
}