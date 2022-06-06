package com.example.payrollmanagement.api;

import com.example.payrollmanagement.models.EmployeeGradeModel;
import com.example.payrollmanagement.models.GradeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface gradeAPI {

    @POST("/grade/")
    Call<GradeModel> createPost(@Body GradeModel gradeModel);

    @PUT("/grade/{id}")
    Call<GradeModel> updatePost(@Body GradeModel gradeModel, @Path("id") int grade_id);

    @GET("/grade/")
    Call<List<GradeModel>> getPost();

    @GET("/grade/{id}")
    Call<List<GradeModel>> getSinglePost(@Path("id") int grade_id);

    @DELETE("/grade/{id}")
    Call<List<GradeModel>> deletePost(@Path("id") int grade_id);

}
