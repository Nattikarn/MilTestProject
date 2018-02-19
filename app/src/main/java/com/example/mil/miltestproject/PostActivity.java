package com.example.mil.miltestproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mil.miltestproject.ApiUtitilies.ApiUtils;
import com.example.mil.miltestproject.ApiUtitilies.RetrofitInterface;
import com.example.mil.miltestproject.Model.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

/**
 * Created by mil on 2/16/2018 AD.
 */

public class PostActivity extends Activity implements View.OnClickListener {

    private RetrofitInterface mRetrofitInterface;
    private TextView mResponseTv;
    private Button submitBtn;
    private EditText titleEt, bodyEt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_activity);

        titleEt = findViewById(R.id.et_title);
        bodyEt = findViewById(R.id.et_body);
        submitBtn = findViewById(R.id.btn_submit);
        mResponseTv = findViewById(R.id.tv_response);

        mRetrofitInterface = ApiUtils.getRetrofitInterface();

        submitBtn.setOnClickListener(this);
    }


    public void onClick(View view) {

        if (view.getId() == R.id.btn_submit) {
            String title = titleEt.getText().toString().trim();
            String body = bodyEt.getText().toString().trim();

            Log.d("HERE", "Hey");
            if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)) {
                sendPost(title, body);
            }
        }

    }

    private void sendPost(String title, String body) {
        Log.d("SendPost", "HERE");
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        mRetrofitInterface.savePost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.d("TEXT1", "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d("TEXT2", "Unable to submit post to API.");
            }
        });
    }




    public void showResponse(String response) {
        if (mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }

}
