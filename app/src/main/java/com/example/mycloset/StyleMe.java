package com.example.mycloset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mycloset.db.DBHandler;

import java.util.Random;

public class StyleMe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_me);
    }

    public void styleMe(View v){
        //Log.d("hi", "hello");
        long s = new DBHandler(this).getNumEntries("tops");
        Log.d("size", "Table size is: " + s);

        int n = new Random().nextInt((int)s+1);
        Log.d("size", "Random number: " + n);

        Cursor cursor = new DBHandler(this).fetch("tops");
        cursor.moveToFirst();
        String id = cursor.getString(0);
        String image = cursor.getString(1);
        String description = cursor.getString(2);
        String color = cursor.getString(3);

        Log.d("size", "ID: "+ id);
        Log.d("size", "Image: "+ image);
        Log.d("size", "Des: "+ description);
        Log.d("size", "Color: "+ color);
    }

}