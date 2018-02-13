package com.example.mil.miltestproject;

import android.app.Activity;
import android.app.LauncherActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by mil on 2/13/2018 AD.
 */

public class ArrayListTest4 extends Activity{
    private ListView listItemTest4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listItemTest4 = findViewById(R.id.listItemTest4);

        listItemTest4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
