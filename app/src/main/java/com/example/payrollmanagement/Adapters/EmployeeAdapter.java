package com.example.payrollmanagement.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.payrollmanagement.R;
import com.example.payrollmanagement.SalaryDetailsActivity;
import com.example.payrollmanagement.api.employeeAPI;
import com.example.payrollmanagement.models.EmployeeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyviewHolder> {

    Context context;
    List<EmployeeModel> list,list_updated;
    int id;

    public EmployeeAdapter(Context context,List<EmployeeModel> list){
        this.context = context;
        this.list = list;
    }

    public void setList(List<EmployeeModel> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.emp_cardview,parent,false);
        return new MyviewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.MyviewHolder holder, int position){
        holder.emp_name.setText(list.get(position).getEmp_name().toString());
        holder.emp_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String BASE_URL = "http://10.0.2.2:8000/";
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                String status = "running";

                employeeAPI employeeAPI = retrofit.create(employeeAPI.class);
                id = list.get(holder.getAdapterPosition()).getEmp_id();
                Call<List<EmployeeModel>> call = employeeAPI.deletePost(id);
                call.enqueue(new Callback<List<EmployeeModel>>() {
                    @Override
                    public void onResponse(Call<List<EmployeeModel>> call, Response<List<EmployeeModel>> response) {
                        list_updated = response.body();
                        setList(list_updated);
                    }

                    @Override
                    public void onFailure(Call<List<EmployeeModel>> call, Throwable t) {

                    }
                });


            }
        });



    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        TextView emp_name,emp_delete,emp_salary;

        public MyviewHolder(View itemView) {
            super(itemView);

            emp_name = itemView.findViewById(R.id.emp_name_cardview);
            emp_delete = itemView.findViewById(R.id.emp_delete_cardview);
            emp_salary = itemView.findViewById(R.id.emp_salary_cardview);

        }
    }

}
