package com.example.payrollmanagement.api;

import com.example.payrollmanagement.models.DeptModel;
import com.example.payrollmanagement.models.EmployeeGradeModel;
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

public interface deptAPI {

    @POST("/dept/")
    Call<DeptModel> createPost(@Body DeptModel deptModel);

    @PUT("/dept/{id}")
    Call<DeptModel> updatePost(@Body DeptModel deptModel, @Path("id") int dept_id);

    @GET("/dept/")
    Call<List<DeptModel>> getPost();

    @GET("/dept/{id}")
    Call<List<DeptModel>> getSinglePost(@Path("id") int dept_id);

    @DELETE("/dept/{id}")
    Call<List<DeptModel>> deletePost(@Path("id") int dept_id);



}
