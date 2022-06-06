package com.example.payrollmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.payrollmanagement.controller.EmployeeGradeController;
import com.example.payrollmanagement.models.EmployeeGradeModel;
import com.example.payrollmanagement.models.GradeModel;

public class employeeGradeActivity extends AppCompatActivity {

    EditText emp_id_text,grade_id_text,dept_id_text;
    String emp_id,grade_id,dept_id;
    Button add_grade_details_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_grade);

        emp_id_text = findViewById(R.id.emp_id);
        grade_id_text = findViewById(R.id.emp_grade_id);
        dept_id_text = findViewById(R.id.emp_dept_id);



        add_grade_details_btn = findViewById(R.id.add_emp_grade_btn);

        add_grade_details_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                emp_id = emp_id_text.getText().toString();
                grade_id = grade_id_text.getText().toString();
                dept_id = dept_id_text.getText().toString();

                if(emp_id.equals("") || grade_id.equals("") || dept_id.equals("")){
                    Toast.makeText(employeeGradeActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                }else{
                    EmployeeGradeModel employeeGradeModel = new EmployeeGradeModel();
                    employeeGradeModel.setEmp_id(Integer.parseInt(emp_id));
                    employeeGradeModel.setEmp_grade_id(Integer.parseInt(grade_id));
                    employeeGradeModel.setEmp_dept_id(Integer.parseInt(dept_id));
                    EmployeeGradeController employeeGradeController = new EmployeeGradeController(employeeGradeActivity.this);
                    employeeGradeController.createPost(employeeGradeModel);
                }
            }
        });

    }
}