package com.example.payrollmanagement.api;

import com.example.payrollmanagement.models.GradeModel;
import com.example.payrollmanagement.models.SalaryDetailsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface salaryDetailsAPI {

    @POST("/salary_det/")
    Call<SalaryDetailsModel> createPost(@Body SalaryDetailsModel salaryDetailsModel);

    @PUT("/salary_det/{id}")
    Call<SalaryDetailsModel> updatePost(@Body SalaryDetailsModel salaryDetailsModel, @Path("id") int transaction_id);

    @GET("/salary_det/")
    Call<List<SalaryDetailsModel>> getPost(@Query("q") String status);

    @GET("/salary_det/{id}")
    Call<List<SalaryDetailsModel>> getSinglePost(@Path("id") int transaction_id);

    @DELETE("/salary_det/{id}")
    Call<List<SalaryDetailsModel>> deletePost(@Path("id") int transaction_id);
}
