package com.example.assignmenttm1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_log;
    EditText username, password, email, phoneNumber, region;
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
        region = findViewById(R.id.et_regis_region);

        register = findViewById(R.id.btn_regis);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkField() == true){
                    Intent toHome = new Intent(RegisterActivity.this, NavigationActivity.class);
                    startActivity(toHome);
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent toLogin = new Intent(this, MainActivity.class);
        startActivity(toLogin);
    }

    private boolean checkField(){
        if(TextUtils.isEmpty(username.getText().toString()) ||
                TextUtils.isEmpty(password.getText().toString()) ||
                TextUtils.isEmpty(email.getText().toString())  ||
                TextUtils.isEmpty(region.getText().toString()) ||
                TextUtils.isEmpty(phoneNumber.getText().toString())) {
            Toast.makeText(RegisterActivity.this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
        }

        if (!username.getText().toString().matches("[a-zA-Z0-9]+")){
            Toast.makeText(this, "Username must be unique and alphanumeric!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.getText().length() < 5 || !password.getText().toString().matches("[a-zA-Z0-9]+")){
            Toast.makeText(this, "Password must be at least five characters and alphanumeric!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!email.getText().toString().endsWith(".com")){
            Toast.makeText(this, "Email must end with ‘.com’", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (phoneNumber.getText().toString().length() == 0){
            Toast.makeText(this, "This field must be filled!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}