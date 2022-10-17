package com.example.mycloset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class Tops extends AppCompatActivity {
    ImageButton imgButton;
    public Button button;
    ImageView img;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tops);
         ImageButton image1 = findViewById(R.id.imageButton);
         ImageButton image2 = findViewById(R.id.imageButton5);
         img  = (ImageView) findViewById(R.id.imageView2);

        button = (Button) findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tops.this, ViewCloset.class);
                startActivity(intent);


            }
        });

        ImageButton imageButton,imageButton2,imageButton3,imageButton4, imageButton5;

        imageButton = findViewById(R.id.imageButton);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        imageButton4 = findViewById(R.id.imageButton4);
        imageButton5 = findViewById(R.id.imageButton5);
        final RelativeLayout relativeLayout;

        imageButton2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tops.this, ViewOutfits.class);
                image2.setImageResource(R.drawable.tops5);
            }
        });


    }
}


