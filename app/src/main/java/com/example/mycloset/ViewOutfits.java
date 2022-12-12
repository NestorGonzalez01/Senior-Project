package com.example.mycloset;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mycloset.db.DBHandler;
import com.example.mycloset.utility.ImageManager;

import java.util.ArrayList;


public class ViewOutfits extends AppCompatActivity {
    ImageView image;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    public Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_outfits);

        this.image = (ImageView) findViewById(R.id.imageView);
        this.image2 = (ImageView) findViewById(R.id.imageView2);
        this.image3 = (ImageView) findViewById(R.id.imageView8);
        this.image4 = (ImageView) findViewById(R.id.imageView9);

        button = (Button) findViewById(R.id.buttonBack1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewOutfits.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        long closetSize = new DBHandler(this).getNumEntries("closet");
        Log.d(TAG, "Closet Size: " + closetSize);

        Cursor closetCursor = new DBHandler(this).fetch1("closet");

        closetCursor.moveToPosition(0);
        String ID = closetCursor.getString(0);
        String Acc = closetCursor.getString(1);
        String Tops = closetCursor.getString(2);
        String Bottoms = closetCursor.getString(3);
        String Shoes = closetCursor.getString(4);


        Log.d(TAG, "Image for Accessories: "+ ID);
        Log.d(TAG, "Image for Accessories: "+ Acc);
        Log.d(TAG, "Image for Tops: "+ Tops);
        Log.d(TAG, "Image for Bottoms: "+ Bottoms);
        Log.d(TAG, "Image for Shoes: " + Shoes);


        ImageView image = findViewById(R.id.imageView);
        ImageManager imageManager = new ImageManager(closetCursor);
        Bitmap imageDisplay = imageManager.stringToBitmap(Acc);
        image.setImageBitmap(imageDisplay);

        ImageView image2 = findViewById(R.id.imageView2);
        ImageManager imageManager2 = new ImageManager (closetCursor);
        Bitmap imageDisplay2 = imageManager2.stringToBitmap(Tops);
        image2.setImageBitmap(imageDisplay2);

        ImageView image3 = findViewById(R.id.imageView8);
        ImageManager imageManager3 = new ImageManager (closetCursor);
        Bitmap imageDisplay3 = imageManager3.stringToBitmap(Bottoms);
        image3.setImageBitmap(imageDisplay3);

        ImageView image4 = findViewById(R.id.imageView9);
        ImageManager imageManager4 = new ImageManager (closetCursor);
        Bitmap imageDisplay4 = imageManager4.stringToBitmap(Shoes);
        image4.setImageBitmap(imageDisplay4);


    }



}


