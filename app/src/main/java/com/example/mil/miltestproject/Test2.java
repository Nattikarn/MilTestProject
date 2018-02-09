package com.example.mil.miltestproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by mil on 2/9/2018 AD.
 */

public class Test2 extends MainActivity {

    protected Button goToListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2_activity);
        Intent intent = getIntent();
        goToListView();

    }

    private void goToListView() {
        goToListView = findViewById(R.id.goToListView);

        goToListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Test2.this, List.class);
                startActivity(intent);
            }
        });
    }

}
