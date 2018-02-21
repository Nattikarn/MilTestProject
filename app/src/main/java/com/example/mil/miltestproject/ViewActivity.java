package com.example.mil.miltestproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Window;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.mil.miltestproject.ApiUtitilies.ApiUtils;
import com.example.mil.miltestproject.ApiUtitilies.RetroClient;
import com.example.mil.miltestproject.ApiUtitilies.RetrofitInterface;
import com.example.mil.miltestproject.Model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mil on 2/19/2018 AD.
 */

public class ViewActivity extends Activity {
    private ListView viewpost_list;
    private ProgressDialog progressDialog;
    private RetrofitInterface mRetrofitInterface;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private SeekBar seekBarId;
    private TextView resultSeekbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity);

        Intent intent = getIntent();

        viewpost_list = (ListView) findViewById(R.id.viewpost_list);

        resultSeekbar = (TextView) findViewById(R.id.resultSeekbar);
        seekBarId = (SeekBar) findViewById(R.id.seekbarId);
        resultSeekbar.setText("Score: " + seekBarId.getProgress() + "/" + seekBarId.getMax());
        seekBarId.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                resultSeekbar.setText("Score: " + seekBar.getProgress() + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                resultSeekbar.setTextColor(Color.GRAY);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            resultSeekbar.setTextColor(Color.RED);
            }
        });

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupBtn);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = (RadioButton) findViewById(checkedId);
            }
        });

       // mRetrofitInterface = ApiUtils.getRetrofitInterface();

//        getAnswer();
    }

/*    private void getAnswer(String title, String body, int userId) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.setUserId(userId);
        mRetrofitInterface.savePost(post).enqueue(Callback);
    }*/

}
