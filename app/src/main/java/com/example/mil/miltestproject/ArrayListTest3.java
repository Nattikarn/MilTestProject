package com.example.mil.miltestproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by mil on 2/12/2018 AD.
 */

public class ArrayListTest3 extends Test2 {

    private ListView listItem;
    private Button backbtn;
    ArrayList<String> myItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arraylist_activity);

        Intent intent = getIntent();
        backbtn();

        ListView myItem = findViewById(R.id.listItem);
        myItemList = new ArrayList<String>();
        getListItem();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myItemList);
        myItem.setAdapter(arrayAdapter);
    }

    private void getListItem() {
        myItemList.add("First Item");
        myItemList.add("Second Item");
        myItemList.add("Third Item");
        myItemList.add("Forth Item");
        myItemList.add("Fift Item");
        myItemList.add("Sixth Item");
        myItemList.add("Seventh Item");
        myItemList.add("Eighth Item");
        myItemList.add("Ninth Item");
        myItemList.add("Tenth Item");
        myItemList.add("First Item");
        myItemList.add("Second Item");
        myItemList.add("Third Item");
        myItemList.add("Forth Item");
        myItemList.add("Fift Item");
        myItemList.add("Sixth Item");
        myItemList.add("Seventh Item");
        myItemList.add("Eighth Item");
        myItemList.add("Ninth Item");
        myItemList.add("Tenth Item");
    }


    private void backbtn() {
        backbtn = findViewById(R.id.backbtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArrayListTest3.this, Test2.class);
                startActivity(intent);
            }
        });
    }


}
