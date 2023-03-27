package com.example.assignmenttm1;

import static com.example.assignmenttm1.R.id.et_loginUser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        login.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if (v == tv_createacc){
            Intent toRegister = new Intent(this, RegisterActivity.class);
            startActivity(toRegister);
        }

        if(v == login){
            if(checkField() == true){
                Intent toHome = new Intent(this, NavigationActivity.class);
                toHome.putExtra("username", username.getText().toString());
                toHome.putExtra("email", username.getText().toString()+"@gmail.com");
                toHome.putExtra("phoneNumber", "62101515515");
                toHome.putExtra("region", "Indonesia");
                startActivity(toHome);
            }
        }


    }

    private boolean checkField(){
        if(TextUtils.isEmpty(username.getText().toString()) ||
                TextUtils.isEmpty(password.getText().toString())) {
            Toast.makeText(this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
        }

        if (!username.getText().toString().matches("[a-zA-Z0-9]+")){
            Toast.makeText(this, "Username must be unique and alphanumeric!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.getText().length() < 5 || !password.getText().toString().matches("[a-zA-Z0-9]+")){
            Toast.makeText(this, "Password must be at least five characters and alphanumeric!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}