package com.example.mycloset;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;


public class ViewOutfits extends AppCompatActivity {
    ImageView i1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_outfits);
        i1 = (ImageView)findViewById(R.id.imageView2);

        Bundle bundle = getIntent().getExtras();
        if(bundle!= null)
        {
            int resId = bundle.getInt("resId");
            i1.setImageResource(resId);
        }


    }
}