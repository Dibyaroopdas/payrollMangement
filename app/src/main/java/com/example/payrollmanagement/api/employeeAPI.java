package com.example.payrollmanagement.api;

import com.example.payrollmanagement.models.DeptModel;
import com.example.payrollmanagement.models.EmployeeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface employeeAPI {

    @POST("/employee/")
    Call<EmployeeModel> createPost(@Body EmployeeModel employeeModel);

    @PUT("/employee/{id}")
    Call<EmployeeModel> updatePost(@Body EmployeeModel employeeModel, @Path("id") int emp_id);

    @GET("/employee/")
    Call<List<EmployeeModel>> getPost();

    @GET("/employee/{id}")
    Call<List<EmployeeModel>> getSinglePost(@Path("id") int emp_id);

    @DELETE("/employee/{id}")
    Call<List<EmployeeModel>> deletePost(@Path("id") int emp_id);


}
