package com.example.mil.miltestproject;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by mil on 2/9/2018 AD.
 */

public class List extends Test2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        Intent intent = getIntent();
    }
}
