package com.example.assignmenttm1;

import static com.example.assignmenttm1.R.id.et_loginUser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_createacc;
    Button login;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_createacc = findViewById(R.id.tv_createacc);
        tv_createacc.setOnClickListener(this);

        username = findViewById(R.id.et_loginUser);
        password = findViewById(R.id.et_loginPass);

        login = findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(checkField() == true){
                    Intent toHome = new Intent(MainActivity.this, NavigationActivity.class);
                    startActivity(toHome);
//                }
            }
        });

    }


    @Override
    public void onClick(View v) {
        Intent toRegister = new Intent(this, RegisterActivity.class);
        startActivity(toRegister);
    }

    private boolean checkField(){
        if (username.length() == 0){
            username.setError("This field must be filled!");
            return false;
        }

        if (password.length() == 0){
            username.setError("This field must be filled!");
            return false;
        }

        return true;
    }
}