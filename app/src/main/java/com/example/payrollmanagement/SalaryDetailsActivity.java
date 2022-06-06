package com.example.payrollmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.payrollmanagement.Adapters.DeptAdapter;
import com.example.payrollmanagement.api.deptAPI;
import com.example.payrollmanagement.api.employeeAPI;
import com.example.payrollmanagement.api.employeeGradeAPI;
import com.example.payrollmanagement.api.gradeAPI;
import com.example.payrollmanagement.models.DeptModel;
import com.example.payrollmanagement.models.EmployeeGradeModel;
import com.example.payrollmanagement.models.EmployeeModel;
import com.example.payrollmanagement.models.GradeModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SalaryDetailsActivity extends AppCompatActivity {

    int id_emp,id_dept,id_grade,id_trans;
    List<EmployeeGradeModel> employeeGradeModelList;
    List<EmployeeModel> employeeModelList;
    List<GradeModel> gradeModelList;
    List<DeptModel> deptModelList;
    TextView emp_name,dept_name,pf,pt,ma,hra,ta,bonus,net,basic;
    String emp_name1,dept_name1;
    EditText emp_id_det;
    Button get_det_btn;

    String BASE_URL = "http://10.0.2.2:8000/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_details);

        employeeGradeModelList = new ArrayList<>();
        employeeModelList = new ArrayList<>();
        gradeModelList = new ArrayList<>();
        deptModelList = new ArrayList<>();

        emp_name = findViewById(R.id.emp_name_salary);
        dept_name = findViewById(R.id.dept_name_salary);
        pf = findViewById(R.id.pf_salary);
        pt= findViewById(R.id.pt_salary);
        ma= findViewById(R.id.ma_salary);
        hra= findViewById(R.id.hra_salary);
        ta= findViewById(R.id.ta_salary);
        bonus= findViewById(R.id.bonus_salary);
        net= findViewById(R.id.net_salary);
        basic = findViewById(R.id.emp_baisc_salary);
        emp_id_det = findViewById(R.id.emp_id_det);
        get_det_btn = findViewById(R.id.emp_btn_id);

        get_det_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id_emp = Integer.parseInt(emp_id_det.getText().toString());

                employeeGradeAPI employeeGradeAPI = retrofit.create(employeeGradeAPI.class);
                Call<List<EmployeeGradeModel>> call = employeeGradeAPI.getSinglePost(id_emp);
                call.enqueue(new Callback<List<EmployeeGradeModel>>() {
                    @Override
                    public void onResponse(Call<List<EmployeeGradeModel>> call, Response<List<EmployeeGradeModel>> response) {
                        employeeGradeModelList = response.body();
                        if(response.body() == null){
                            Toast.makeText(SalaryDetailsActivity.this, "Invalid ID", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        Log.d("grade",employeeGradeModelList.toString());
                        id_dept = employeeGradeModelList.get(0).getEmp_dept_id();
                        id_grade = employeeGradeModelList.get(0).getEmp_grade_id();
                        id_trans = employeeGradeModelList.get(0).getTransaction_id();

                        deptAPI deptAPI = retrofit.create(com.example.payrollmanagement.api.deptAPI.class);
                        Call<List<DeptModel>> call_dept = deptAPI.getSinglePost(id_dept);
                        call_dept.enqueue(new Callback<List<DeptModel>>() {
                            @Override
                            public void onResponse(Call<List<DeptModel>> call, Response<List<DeptModel>> response) {
                                deptModelList = response.body();
                                gradeAPI gradeAPI = retrofit.create(com.example.payrollmanagement.api.gradeAPI.class);
                                Call<List<GradeModel>> call_grade = gradeAPI.getSinglePost(id_grade);
                                call_grade.enqueue(new Callback<List<GradeModel>>() {
                                    @Override
                                    public void onResponse(Call<List<GradeModel>> call, Response<List<GradeModel>> response) {
                                        gradeModelList = response.body();
                                        employeeAPI employeeAPI = retrofit.create(com.example.payrollmanagement.api.employeeAPI.class);
                                        Call<List<EmployeeModel>> call_emp = employeeAPI.getSinglePost(id_emp);
                                        call_emp.enqueue(new Callback<List<EmployeeModel>>() {
                                            @Override
                                            public void onResponse(Call<List<EmployeeModel>> call, Response<List<EmployeeModel>> response) {
                                                employeeModelList = response.body();
                                                int grade_ta,grade_hra,grade_ma,grade_bonus,grade_pf,grade_pt,basic_salary;
                                                basic_salary = gradeModelList.get(0).getGrade_basic();
                                                grade_hra = gradeModelList.get(0).getGrade_hra();
                                                grade_ma = gradeModelList.get(0).getGrade_ma();
                                                grade_bonus = gradeModelList.get(0).getGrade_bonus();
                                                grade_ta= gradeModelList.get(0).getGrade_ta();
                                                grade_pt= gradeModelList.get(0).getGrade_pt();
                                                grade_pf= gradeModelList.get(0).getGrade_pf();



                                                int gross_salary;
                                                gross_salary = basic_salary +
                                                        ((basic_salary * grade_hra)/100)+
                                                        ((basic_salary * grade_ma)/100)+
                                                        ((basic_salary * grade_ta)/100)+
                                                        grade_bonus;

                                                int net_salary;
                                                net_salary = gross_salary - ((gross_salary * grade_pt)/100)-
                                                        grade_pf;

                                                emp_name1 = employeeModelList.get(0).getEmp_name();
                                                dept_name1 = deptModelList.get(0).getDept_name();

                                                emp_name.setText(emp_name1);
                                                dept_name.setText(dept_name1);
                                                basic.setText(String.valueOf(basic_salary));
                                                pf.setText(String.valueOf(grade_pf));
                                                pt.setText(String.valueOf(grade_pt));
                                                ma.setText(String.valueOf(grade_ma));
                                                hra.setText(String.valueOf(grade_hra));
                                                ta.setText(String.valueOf(grade_ta));
                                                bonus.setText(String.valueOf(grade_bonus));
                                                net.setText(String.valueOf(net_salary));


                                                Log.d("net salary", String.valueOf(basic_salary));
                                                Log.d("net salary", String.valueOf(grade_hra));
                                                Log.d("net salary", String.valueOf(grade_ma));
                                                Log.d("net salary", String.valueOf(grade_ta));
                                                Log.d("net salary", String.valueOf(grade_pt));
                                                Log.d("net salary", String.valueOf(grade_pf));
                                                Log.d("net salary", String.valueOf(gross_salary));
                                                Log.d("net salary", String.valueOf(net_salary));


                                            }

                                            @Override
                                            public void onFailure(Call<List<EmployeeModel>> call, Throwable t) {

                                            }
                                        });

                                    }
                                    @Override
                                    public void onFailure(Call<List<GradeModel>> call, Throwable t) {

                                    }
                                });
                            }

                            @Override
                            public void onFailure(Call<List<DeptModel>> call, Throwable t) {
                            }
                        });







                    }

                    @Override
                    public void onFailure(Call<List<EmployeeGradeModel>> call, Throwable t) {

                    }
                });


            }
        });



        //id_emp = 12;




    }
}