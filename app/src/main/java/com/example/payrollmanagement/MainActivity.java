package com.example.payrollmanagement;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.payrollmanagement.controller.DeptController;
import com.example.payrollmanagement.controller.EmployeeGradeController;
import com.example.payrollmanagement.controller.SalaryDetailController;
import com.example.payrollmanagement.models.DeptModel;
import com.example.payrollmanagement.models.EmployeeGradeModel;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    CardView addEmployee, addDepartment, addGrade, addEmployeeGrade,employeeList,deptList,gradeList,salaryDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Controller controller = new Controller();controller.start();

        addEmployee = findViewById(R.id.add_emp_btn);
        addEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,addEmployeeActivity.class);
                startActivity(intent);
            }
        });

        addDepartment = findViewById(R.id.add_dept_btn);
        addDepartment.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,addDeptActivity.class);
                startActivity(intent);

            }
        });

        addGrade = findViewById(R.id.add_grade_btn);
        addGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,addGradeActivity.class);
                startActivity(intent);
            }
        });

        addEmployeeGrade = findViewById(R.id.add_grade_details_btn);
        addEmployeeGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,employeeGradeActivity.class);
                startActivity(intent);
            }
        });

        employeeList = findViewById(R.id.emp_list_btn);
        employeeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,EmployeeListActivity.class);
                startActivity(intent);
            }
        });

        deptList = findViewById(R.id.dept_list_btn);
        deptList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DeptListActivity.class);
                startActivity(intent);
            }
        });

        gradeList = findViewById(R.id.grade_list_btn);
        gradeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GradeListActivity.class);
                startActivity(intent);
            }
        });

        salaryDetails = findViewById(R.id.salary_report_btn);
        salaryDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SalaryDetailsActivity.class);
                startActivity(intent);
            }
        });


    }
}