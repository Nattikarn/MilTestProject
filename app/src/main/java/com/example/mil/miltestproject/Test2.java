package com.example.mil.miltestproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import junit.framework.Test;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mil on 2/9/2018 AD.
 */

public class Test2 extends MainActivity {

    protected Button goToListView, addBtn;
    EditText text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2_activity);

        goToListView = findViewById(R.id.goToListView);
        addBtn = findViewById(R.id.addBtn);
        text1 = findViewById(R.id.text1);

        Intent intent = getIntent();
        goToListView();
        addBtn();

    }

    private void goToListView() {

        goToListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Test2.this, ArrayListTest3.class);
                startActivity(intent);
                Test2.this.finish();

            }
        });
    }

    private void addBtn() {

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }


    //คลาสที่ใช้ทำงานอะไรบางอย่างใน background task ของ Android
    // ่วนใหญ่ถูกนำมาใช้จัดการ เรื่อง HttpRequest , การติดต่อกับฝั่ง Web Server
    public class HttpGetRequest extends AsyncTask<String, Void, String>{

        private ProgressDialog progressDialog = new ProgressDialog(Test2.this);

        protected void onPreExecute(){
            super.onPreExecute();
            // เริ่มต้นกำหนดค่าอะไรๆก่อนทำงานใน doInBackground
            progressDialog.setMessage("..Loading..");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();
        }

        protected String doInBackground(String... s) {
            // ตรงนี้อาจจะเป็นโค้ดสำหรับติดต่อกับฝั่ง WebServer บลาๆ
            return null;
        }

        protected void onPostExecute(String response){
            progressDialog.dismiss();
            // หลังจาก doInBackground เสร็จอัพเดท UI ให้ผู้ใช้รู้
        }
    }


}


