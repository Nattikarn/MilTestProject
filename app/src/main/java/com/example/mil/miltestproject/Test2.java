package com.example.mil.miltestproject;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by mil on 2/9/2018 AD.
 */

public class Test2 extends MainActivity {

    private Button goToListView, clickToJson, alertBtn, passValueBtn;
    private EditText text1;
    private AlertDialog.Builder alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2_activity);

        goToListView = findViewById(R.id.goToListView);
        clickToJson = findViewById(R.id.clickToJson);
        text1 = findViewById(R.id.text1);
        passValueBtn = findViewById(R.id.passValueBtn);
        alertBtn = (Button) findViewById(R.id.alertBtn);


        Toast.makeText(getApplication(), "Gogo", Toast.LENGTH_SHORT).show();

        goToListView();
        clickToJson();

        passValueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Test2.this, ViewActivity.class);
                intent.putExtra("Message", text1.getText().toString());
                startActivity(intent);
            }
        });

        alertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog = new AlertDialog.Builder(Test2.this);

                alertDialog.setTitle(R.string.alertDialog);

                alertDialog.setMessage("ERRORRRR");

                alertDialog.setCancelable(false);

                Log.d("AlertBtn","Here");
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Test2.this.finish();
                        Log.d("finish","finish");
                    }
                });
                Log.d("AlertBtn","cancel");

                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Log.d("cancel","cancel");
                    }
                });
                AlertDialog dialog = alertDialog.create();
                alertDialog.show();
            }
        });



    }

    private void goToListView() {

        goToListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Test2.this, ArrayListTest3.class));
                Test2.this.finish();

            }
        });
    }

    private void clickToJson() {

        clickToJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Test2.this, ArrayListJSON.class);
                startActivity(intent);
                Test2.this.finish();
            }
        });

    }


    //คลาสที่ใช้ทำงานอะไรบางอย่างใน background task ของ Android
    // ่วนใหญ่ถูกนำมาใช้จัดการ เรื่อง HttpRequest , การติดต่อกับฝั่ง Web Server
    public class HttpGetRequest extends AsyncTask<String, Void, String> {

        private ProgressDialog progressDialog = new ProgressDialog(Test2.this);

        protected void onPreExecute() {
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

        protected void onPostExecute(String response) {
            progressDialog.dismiss();
            // หลังจาก doInBackground เสร็จอัพเดท UI ให้ผู้ใช้รู้
        }
    }


}


