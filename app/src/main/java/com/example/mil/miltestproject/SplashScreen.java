package com.example.mil.miltestproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mil on 2/12/2018 AD.
 */

public class SplashScreen extends AppCompatActivity {
    private int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.setContentView(R.layout.splashscreen_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));

                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
