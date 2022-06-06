package com.example.payrollmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;
import java.util.UUID;

import androidx.appcompat.app.AppCompatActivity;

import com.example.payrollmanagement.controller.EmployeeController;
import com.example.payrollmanagement.models.EmployeeModel;
import com.example.payrollmanagement.models.UserModel;
import com.example.payrollmanagement.models.employeeModelTest;

public class addEmployeeActivity extends AppCompatActivity {

    EditText emp_name_text,emp_surname_text,emp_addr_text,emp_city_text,
    emp_state_text,emp_email_text,emp_pan_no_text, emp_pincode_text, emp_mobile_no_text;
    public Button add_emp_btn;
    public String emp_name,emp_surname,emp_addr,emp_city,
            emp_state,emp_email,emp_pan_no, emp_mobile_no,emp_pincode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        emp_name_text = (EditText)findViewById(R.id.emp_name);
        emp_surname_text = findViewById(R.id.emp_surname);
        emp_addr_text = findViewById(R.id.emp_address);
        emp_city_text = findViewById(R.id.emp_city);
        emp_state_text = findViewById(R.id.emp_state);
        emp_email_text = findViewById(R.id.emp_email);
        emp_pan_no_text = findViewById(R.id.emp_pan_no);
        emp_mobile_no_text = findViewById(R.id.emp_mobile_no);
        emp_pincode_text = findViewById(R.id.emp_pincode);

        EmployeeModel employeeModel = new EmployeeModel();

        add_emp_btn = findViewById(R.id.add_emp_btn);

        add_emp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                emp_name = emp_name_text.getText().toString();
                emp_surname = emp_surname_text.getText().toString();
                emp_addr = emp_addr_text.getText().toString();
                emp_city = emp_city_text.getText().toString();
                emp_state = emp_state_text.getText().toString();
                emp_email = emp_email_text.getText().toString();
                emp_pan_no = emp_pan_no_text.getText().toString();
                emp_pincode = emp_pincode_text.getText().toString();
                emp_mobile_no = emp_mobile_no_text.getText().toString();

                if(emp_name == null || emp_surname == null || emp_addr == null ||
                        emp_city == null || emp_state == null || emp_email == null  ||
                        emp_pan_no == null || emp_pincode == null){

                    Toast.makeText(addEmployeeActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    employeeModel.setEmp_name(emp_name);
                    employeeModel.setEmp_surname(emp_surname);
                    employeeModel.setEmp_address(emp_addr);
                    employeeModel.setEmp_city(emp_city);
                    employeeModel.setEmp_state(emp_state);
                    employeeModel.setEmp_mail_id(emp_email);
                    employeeModel.setEmp_pan_no(emp_pan_no);
                    employeeModel.setEmp_pincode(Integer.parseInt(emp_pincode));
                    employeeModel.setEmp_mobile_no(emp_mobile_no);
                    EmployeeController employeeController = new EmployeeController(addEmployeeActivity.this);
                    employeeController.createPost(employeeModel);

                }
            }
        });
    }
}