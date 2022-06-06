package com.example.payrollmanagement.api;

import android.graphics.ColorSpace;

import com.example.payrollmanagement.PlaceholderPost;
import com.example.payrollmanagement.models.EmployeeGradeModel;
import com.example.payrollmanagement.models.EmployeeModel;
import com.example.payrollmanagement.models.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface employeeGradeAPI {

    @POST("/emp_grade/")
    Call<EmployeeGradeModel> createPost(@Body EmployeeGradeModel employeeGradeModel);

    @PUT("/emp_grade/{id}")
    Call<EmployeeGradeModel> updatePost(@Body EmployeeGradeModel employeeGradeModel, @Path("id") int transaction_id);

    @GET("/emp_grade/")
    Call<List<EmployeeGradeModel>> getPost();

    @GET("/emp_grade/{id}")
    Call<List<EmployeeGradeModel>> getSinglePost(@Path("id") int transaction_id);

    @DELETE("/emp_grade/{id}")
    Call<List<EmployeeGradeModel>> deletePost(@Path("id") int transaction_id);

}
