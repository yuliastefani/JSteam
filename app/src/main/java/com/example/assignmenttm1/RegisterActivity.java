package com.example.assignmenttm1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_log;
    EditText username, password, email, phoneNumber;
    Button register;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tv_log = findViewById(R.id.tv_login);
        tv_log.setOnClickListener(this);

        username = findViewById(R.id.et_regis_un);
        password = findViewById(R.id.et_regis_pw);
        email = findViewById(R.id.et_regis_em);
        phoneNumber = findViewById(R.id.et_regis_phone);

        register = findViewById(R.id.btn_regis);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(checkField() == true){
                    Intent toHome = new Intent(RegisterActivity.this, NavigationActivity.class);
                    startActivity(toHome);
//                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent toLogin = new Intent(this, MainActivity.class);
        startActivity(toLogin);
    }

    private boolean checkField(){
        if (username.length() == 0 || username.getText().toString().matches("[a-zA-Z0-9]+")){
            username.setError("Username must be unique and alphanumeric!");
            return false;
        }

        if (password.length() < 5 || password.getText().toString().matches("[a-zA-Z0-9]+")){
            password.setError("Password must be at least five characters and alphanumeric!");
            return false;
        }

        if (email.getText().toString().endsWith(".com")){
            email.setError("This field must be filled!");
            return false;
        }

        if (phoneNumber.length() == 0){
            email.setError("This field must be filled!");
            return false;
        }

        return true;
    }
}