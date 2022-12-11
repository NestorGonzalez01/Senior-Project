package com.example.mycloset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mycloset.db.DBHandler;
import com.example.mycloset.utility.ImageManager;

public class Shoes extends AppCompatActivity {
    public Button button;
    ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5;
    private ImageButton selectedImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.selectedImageButton = (ImageButton) findViewById(R.id.imageButton);
        setContentView(R.layout.activity_shoes);

        button = (Button) findViewById(R.id.buttonShoeBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shoes.this, ViewCloset.class);
                startActivity(intent);
            }
        });

        DBHandler dbHandler = new DBHandler(Shoes.this);
        Cursor cursor = new DBHandler(this).fetch("tops");
        cursor.moveToFirst();
        String id = cursor.getString(0);
        String image = cursor.getString(1);

        Log.d("size", "ID: "+ id);
        Log.d("size", "Image: "+ image);

        ImageManager imageManager = new ImageManager(cursor);
        //Bitmap imageDisplay = imageManager.getImage();


        int sizeRows = cursor.getCount();
        ImageButton btn[] = new ImageButton[sizeRows];

        for (int x = 0; x < sizeRows; x++)
        {

            btn[x] = new ImageButton(this);
            Bitmap imageDisplayTops = imageManager.getImage();
            selectedImageButton.setImageBitmap(imageDisplayTops);
            cursor.moveToNext();
        }
        cursor.close();

        imageButton1 = findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shoes.this, Accessories.class);
                startActivity(intent);
            }
        });
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shoes.this, Accessories.class);
                startActivity(intent);
            }
        });
        imageButton3 = findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shoes.this, Accessories.class);
                startActivity(intent);
            }
        });


        imageButton4 = findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shoes.this, Accessories.class);
                startActivity(intent);
            }
        });

        imageButton5 = findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shoes.this, Accessories.class);
                startActivity(intent);
            }
        });


    }
}