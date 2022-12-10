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


public class Bottoms extends AppCompatActivity {
    public Button button;
    ImageButton imageBottom1, imageBottom2, imageBottom3;
    private ImageButton selectedImageButton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.selectedImageButton = (ImageButton) findViewById(R.id.imageBottom1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottoms);

        button = (Button) findViewById(R.id.buttonBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bottoms.this, ViewCloset.class);
                startActivity(intent);
            }
        });

        DBHandler dbHandler = new DBHandler(Bottoms.this);
        Cursor cursor = new DBHandler(this).fetch("tops");
        cursor.moveToFirst();
        String id = cursor.getString(0);
        String image = cursor.getString(1);

        Log.d("size", "ID: "+ id);
        Log.d("size", "Image: "+ image);

        ImageManager imageManager = new ImageManager(cursor);

        int sizeRows = cursor.getCount();
        ImageButton btn[] = new ImageButton[sizeRows];

        for (int x = 0; x < sizeRows; x++)
        {

            btn[x] = new ImageButton(this);
            Bitmap imageDisplayBottoms = imageManager.getImage();
            selectedImageButton.setImageBitmap(imageDisplayBottoms);
            cursor.moveToNext();
        }
        cursor.close();

        imageBottom1 = findViewById(R.id.imageBottom1);
        imageBottom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bottoms.this, Shoes.class);
                startActivity(intent);
            }
        });

        imageBottom2 = findViewById(R.id.imageBottom2);
        imageBottom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bottoms.this, Shoes.class);
                startActivity(intent);
            }
        });

        imageBottom3 = findViewById(R.id.imageBottom3);
        imageBottom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bottoms.this, Shoes.class);
                startActivity(intent);
            }
        });
    }
}