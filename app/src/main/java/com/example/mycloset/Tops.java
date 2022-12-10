package com.example.mycloset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.example.mycloset.CreateOutfit;
import com.example.mycloset.db.DBHandler;
import com.example.mycloset.utility.ImageManager;
import androidx.annotation.Nullable;

import java.io.InputStream;
import java.net.URI;


public class Tops extends AppCompatActivity {
    ImageButton imgButton;
    public Button button;
    ImageView img;
    ImageButton imageButton, imageButton5, imageButton4, imageButton3, imageButton2;
    private ImageButton selectedImageButton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tops);
        this.selectedImageButton = (ImageButton) findViewById(R.id.imageButton);

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

        imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tops.this, Bottoms.class);
                startActivity(intent);
            }
        });


        imageButton5 = findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Cursor cursor = new DBHandler(Tops.this).fetch("tops");
//                cursor.moveToFirst();
//                String id = cursor.getString(0);
//                String image = cursor.getString(1);

//                Log.d("size", "ID: "+ id);
//                Log.d("size", "Image: "+ image);
                Intent intent = new Intent(Tops.this, Bottoms.class);
                startActivity(intent);
            }
        });

        imageButton4 = findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tops.this, Bottoms.class);
                startActivity(intent);
            }
        });

        imageButton3 = findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tops.this, Bottoms.class);
                startActivity(intent);
            }
        });
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tops.this, Bottoms.class);
                startActivity(intent);
            }
        });
    }
}


