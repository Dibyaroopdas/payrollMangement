package com.example.payrollmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.payrollmanagement.controller.GradeContoller;
import com.example.payrollmanagement.models.GradeModel;

public class addGradeActivity extends AppCompatActivity {

    EditText grade_name_text,grade_shortname_text,grade_basic_text,
    grade_ta_text,grade_hra_text,grade_ma_text,grade_bonus_text, grade_pf_text, grade_pt_text;

    String grade_name,grade_short_name,grade_basic,grade_ta,grade_hra,grade_ma,grade_bonus,grade_pf,grade_pt;

    GradeModel gradeModel = new GradeModel();

    Button addGradeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade);

        grade_name_text = findViewById(R.id.grade_name);
        grade_shortname_text = findViewById(R.id.grade_shortname);
        grade_basic_text = findViewById(R.id.grade_basic);
        grade_ta_text  = findViewById(R.id.grade_ta);
        grade_hra_text = findViewById(R.id.grade_hra);
        grade_ma_text = findViewById(R.id.grade_ma);
        grade_bonus_text= findViewById(R.id.grade_bonus);
        grade_pf_text = findViewById(R.id.grade_pf);
        grade_pt_text = findViewById(R.id.grade_pt);
        addGradeBtn = findViewById(R.id.add_grade_btn);




        addGradeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                grade_name = grade_name_text.getText().toString();
                grade_short_name = grade_shortname_text.getText().toString();
                grade_basic = grade_basic_text.getText().toString();
                grade_ta = grade_ta_text.getText().toString();
                grade_hra = grade_hra_text.getText().toString();
                grade_ma = grade_ma_text.getText().toString();
                grade_bonus = grade_bonus_text.getText().toString();
                grade_pf = grade_pf_text.getText().toString();
                grade_pt = grade_pt_text.getText().toString();

                if(grade_name.equals("") || grade_short_name.equals("") ||
                        grade_basic.equals("") || grade_ta.equals("") ||
                        grade_hra.equals("") || grade_ma.equals("") ||
                        grade_bonus.equals("")||grade_pf.equals("")||grade_pt.equals("")){
                    Toast.makeText(addGradeActivity.this, "please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    gradeModel.setGrade_name(grade_name);
                    gradeModel.setGrade_name_short(grade_short_name);
                    gradeModel.setGrade_basic(Integer.parseInt(grade_basic));
                    gradeModel.setGrade_ta(Integer.parseInt(grade_ta));
                    gradeModel.setGrade_hra(Integer.parseInt(grade_hra));
                    gradeModel.setGrade_ma(Integer.parseInt(grade_ma));
                    gradeModel.setGrade_bonus(Integer.parseInt(grade_bonus));
                    gradeModel.setGrade_pf(Integer.parseInt(grade_pf));
                    gradeModel.setGrade_pt(Integer.parseInt(grade_pt));

                    GradeContoller gradeContoller = new GradeContoller(addGradeActivity.this);
                    gradeContoller.createPost(gradeModel);
                }
            }
        });

    }
}