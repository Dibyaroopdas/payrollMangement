package com.example.payrollmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.payrollmanagement.Adapters.DeptAdapter;
import com.example.payrollmanagement.Adapters.GradeAdapter;
import com.example.payrollmanagement.api.gradeAPI;
import com.example.payrollmanagement.models.GradeModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GradeListActivity extends AppCompatActivity {

    List<GradeModel> list;

    GradeAdapter gradeAdapter;
    RecyclerView gradeRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_list);


        list = new ArrayList<>();

        gradeRecView = findViewById(R.id.grade_rec_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        gradeRecView.setLayoutManager(linearLayoutManager);
        gradeAdapter = new GradeAdapter(getApplicationContext(),list);
        gradeRecView.setAdapter(gradeAdapter);

        String BASE_URL = "http://10.0.2.2:8000/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gradeAPI gradeAPI = retrofit.create(gradeAPI.class);
        Call<List<GradeModel>> call = gradeAPI.getPost();
        call.enqueue(new Callback<List<GradeModel>>() {
            @Override
            public void onResponse(Call<List<GradeModel>> call, Response<List<GradeModel>> response) {
                list = response.body();
                gradeAdapter.setList(list);
            }

            @Override
            public void onFailure(Call<List<GradeModel>> call, Throwable t) {

            }
        });




    }
}