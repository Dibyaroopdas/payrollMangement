package com.example.payrollmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.payrollmanagement.controller.DeptController;
import com.example.payrollmanagement.models.DeptModel;

public class addDeptActivity extends AppCompatActivity {

    String deptName;
    EditText dept_name_text;
    Button add_dept;
    DeptModel deptModel = new DeptModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dept);

        dept_name_text = findViewById(R.id.dept_name);



        add_dept = findViewById(R.id.add_dept_btn);
        add_dept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deptName = dept_name_text.getText().toString();
                if(deptName.equals(""))
                {
                    Toast.makeText(addDeptActivity.this, "pleae enter all the fields", Toast.LENGTH_SHORT).show();

                }
                else{
                    deptModel.setDept_name(deptName);
                    DeptController deptController = new DeptController(addDeptActivity.this);
                    deptController.createDept(deptModel);
                }

            }
        });




    }
}