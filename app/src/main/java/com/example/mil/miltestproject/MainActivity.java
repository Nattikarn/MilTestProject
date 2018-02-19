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
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Test2.class);
                startActivity(intent);
            }
        });
    }

}

