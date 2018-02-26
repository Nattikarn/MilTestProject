package com.example.mil.miltestproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mil.miltestproject.ApiUtitilies.ApiUtils;
import com.example.mil.miltestproject.ApiUtitilies.RetrofitInterface;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button loginBtn;
    RetrofitInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.loginBtn);


        // ส่วนของ Retrofit
        apiService = ApiUtils.getRetrofitInterface();
        loginBtn();
        UserLogin user = new UserLogin();
        user.setStaff_id(4286);
        user.setPassword(5689);
       //apiService.savePost(user).enqueue(new Callback<>); // callback<ใส่ class ที่เป็น response>

        // ----------- //
    }

    private void loginBtn() {

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Test2.class));
            }
        });
    }

}

