package com.example.payrollmanagement.controller;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.payrollmanagement.api.gradeAPI;
import com.example.payrollmanagement.api.salaryDetailsAPI;
import com.example.payrollmanagement.models.EmployeeGradeModel;
import com.example.payrollmanagement.models.GradeModel;
import com.example.payrollmanagement.models.SalaryDetailsModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SalaryDetailController {

    Context context;

    public SalaryDetailController(Context context) {
        this.context = context;
    }

    List<EmployeeGradeModel> employeeGradeModelList = new ArrayList<>();

    public void start()
    {
        EmployeeGradeController employeeGradeController = new EmployeeGradeController(context);
        employeeGradeController.getPost();
        employeeGradeModelList = employeeGradeController.getList();

        Log.d("gradeModel",String.valueOf(employeeGradeModelList.get(0).getEmp_id()));


    }

}
