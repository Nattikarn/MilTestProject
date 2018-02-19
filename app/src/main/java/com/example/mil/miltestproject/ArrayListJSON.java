package com.example.mil.miltestproject;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by mil on 2/14/2018 AD.
 */

public class ArrayListJSON extends AppCompatActivity {

    private ListView json_listview;
    ArrayList<String> exData;
    private ProgressDialog progressDialog; //ขึ้นหมุนๆ
    private Button restbtn;

    @SuppressLint("StaticFieldLeak")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arraylistjson_activity);
        Intent intent = getIntent();

        json_listview = findViewById(R.id.json_listview);
        restbtn = findViewById(R.id.restbtn);
        restbtn();

        exData = new ArrayList<String>();
//        exData.add("Test1");

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPreExecute() { //method onPreExecute ที่จะถูกใช้ต่อเมื่อ AsyncTask ถูกเรียกใช้ เพื่อทำการ setup อะไรซักอย่าง
                super.onPreExecute();
                progressDialog = new ProgressDialog(ArrayListJSON.this);
                progressDialog.setCancelable(false);//ไม่ให้กดยกเลิกได้
                progressDialog.setMessage("Loading...");
                progressDialog.show();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    URL url = new URL("http://thaicfp.com/webservices/json-example.php");

                    URLConnection urlConnection = url.openConnection();//open Connection

                    HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection; //ทำHttpUrlConnection
                    httpURLConnection.setAllowUserInteraction(false);//setค่าของ HttpConnection โดยถ้าไม่ต้องการให้มีปฏิสัมพันธ์/ส่งค่าต่อฝบลาๆ แบบ Read มาเฉยๆให้ใช้ False
                    httpURLConnection.setInstanceFollowRedirects(true); //กรณีที่มัน redirect ไปที่อื่น ก็ให้ตามไป
                    httpURLConnection.setRequestMethod("GET");//บอกว่าต้องการ request แบบไหน get หรือ post
                    httpURLConnection.connect(); // ทำการ Connect เชื่อมต่อ

                    InputStream inputStream = null; // check ว่า respond code มันต่อได้หรือเปล่า
                    if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        inputStream = httpURLConnection.getInputStream();

                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);
                        ; //อ่านแล้วเก็บไว้ 8คือค่าparameter

                        StringBuilder stringBuilder = new StringBuilder();
                        String line = null;

                        while ((line = reader.readLine()) != null) {
                            stringBuilder.append(line + "\n");
                        }
                        inputStream.close();

                        Log.d("JSON RESULT", stringBuilder.toString());

                        JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                        JSONArray exArray = jsonObject.getJSONArray("students"); //ex นี่คือ Array ละ

                        for (int i = 0; i < exArray.length(); i++) {
                            JSONObject jsonObj = exArray.getJSONObject(i);
                            exData.add(jsonObj.getString("student_name"));// add ไปใส่ใน exdata

                            //พอมีข้อมูลแล้ว ก็ไปทำการ set ตัว Adapter โดยไปทำที่ PostExecute
                        }
                    }


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override //ตัวนี้จะทำต่อเมื่อ ตัวอื่นทำเสร็จหมดแล้ว จะได้ไปทำอย่างอื่นต่อได้
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(ArrayListJSON.this, android.R.layout.simple_list_item_1, android.R.id.text1, exData);
                json_listview.setAdapter(myAdapter);


                progressDialog.dismiss();
            }
        }.execute();


    }

    private void restbtn() {
        restbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArrayListJSON.this, PostActivity.class);
                startActivity(intent);
            }
        });
    }

}
