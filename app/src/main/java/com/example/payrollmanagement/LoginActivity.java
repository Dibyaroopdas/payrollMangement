package com.example.payrollmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText email,password;
    private Button loginBtnLog;
    private TextView loginToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.emailLog);
        password = findViewById(R.id.passwordLog);
        loginBtnLog = findViewById(R.id.login_log_btn);

        loginBtnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uEmail = email.getText().toString();
                String uPassword = password.getText().toString();

                if(uEmail.equals("") || uPassword.equals("")){
                    Toast.makeText(LoginActivity.this, "Please complete the Fields ", Toast.LENGTH_SHORT).show();
                }else{
                    if(uEmail.equals("admin") && uPassword.equals("admin123")){
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }
}