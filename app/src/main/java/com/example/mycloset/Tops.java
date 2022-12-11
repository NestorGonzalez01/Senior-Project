package com.example.mycloset;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.mycloset.db.DBHandler;
import com.example.mycloset.utility.ImageManager;


public class Tops extends AppCompatActivity {
    ImageButton imgButton;
    public Button button;
    ImageView img;
    ImageButton imageButton, deleteTop, imageButton5, imageButton4, imageButton3, imageButton2;
    private ImageButton selectedImageButton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tops);

        //back button
        button = (Button) findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tops.this, ViewCloset.class);
                startActivity(intent);
            }
        });


        DBHandler dbHandler = new DBHandler(Tops.this);
        Cursor cursor = new DBHandler(this).fetch("tops");
        cursor.moveToFirst();
        int sizeRows = cursor.getCount();

        String id = cursor.getString(0);
        String image = cursor.getString(1);
        Log.d("size", "ID: " + id);
        Log.d("size", "Image: " + image);
        ImageButton btn[] = new ImageButton[sizeRows];


        ImageManager imageManager = new ImageManager(cursor);
        Log.d("size", "Test: " + sizeRows);

            for (int x = 0; x < sizeRows; x++) {
                //Log.d("size", "poop");

                this.selectedImageButton = (ImageButton) findViewById(R.id.imageButton);
                //btn[x] = new ImageButton(this);
                Bitmap imageDisplayTops = imageManager.getImage();
                selectedImageButton.setImageBitmap(imageDisplayTops);
                cursor.moveToNext();
            }
            cursor.close();

            //calling button to delete image from database
            deleteTop = findViewById(R.id.deleteTop);
            deleteTop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageButton.setVisibility(View.GONE);

                }
            });

//        imageButton = findViewById(R.id.imageButton);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Tops.this, Bottoms.class);
//                startActivity(intent);
//            }
//        });
//
//
//        imageButton5 = findViewById(R.id.imageButton5);
//        imageButton5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Cursor cursor = new DBHandler(Tops.this).fetch("tops");
////                cursor.moveToFirst();
////                String id = cursor.getString(0);
////                String image = cursor.getString(1);
//
////                Log.d("size", "ID: "+ id);
////                Log.d("size", "Image: "+ image);
//                Intent intent = new Intent(Tops.this, Bottoms.class);
//                startActivity(intent);
//            }
//        });
//
//        imageButton4 = findViewById(R.id.imageButton4);
//        imageButton4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Tops.this, Bottoms.class);
//                startActivity(intent);
//            }
//        });
//
//        imageButton3 = findViewById(R.id.imageButton3);
//        imageButton3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Tops.this, Bottoms.class);
//                startActivity(intent);
//            }
//        });
//        imageButton2 = findViewById(R.id.imageButton2);
//        imageButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Tops.this, Bottoms.class);
//                startActivity(intent);
//            }
//        });
 }
}


