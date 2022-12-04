package com.example.mycloset;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.mycloset.db.DBHandler;

public class StyleMe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_me);

        long s = new DBHandler(this).getNumEntries("tops");
        Log.d("size", "Table size is: " + s);
    }
}