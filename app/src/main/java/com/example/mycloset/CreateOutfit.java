package com.example.mycloset;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mycloset.db.DBHandler;


public class CreateOutfit extends AppCompatActivity {


    public static int[] createOutfitArray = new int[4];
    public Button button;
    ImageView imageView3;


   // ImageView imageView = (ImageView)findViewById(R.id.imageButton);
    //int resourceId = getIntent().getIntExtra("Top_1",R.drawable.ic_launcher_background);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_outfit);

        //Adding Action to go Back to Home
        button = (Button) findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateOutfit.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        //Adding Action to Save
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(CreateOutfit.this, ViewOutfits.class);
                startActivity(intent);
            }
        });

        //Adding Action to Add From Closet
        imageView3 = findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateOutfit.this, Tops.class);
                startActivity(intent);
            }
        });

    }
}