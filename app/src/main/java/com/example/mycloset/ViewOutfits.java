package com.example.mycloset;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
<<<<<<< HEAD
import android.widget.Space;
import android.widget.TextView;
=======
>>>>>>> 2ff06ff98f0573db275a6e37471c769f4de07dcc

import com.example.mycloset.db.DBHandler;
import com.example.mycloset.utility.ImageManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class ViewOutfits extends AppCompatActivity {
    //ImageView image;
    /*ImageView image2;
    ImageView image3;
    ImageView image4;*/
    public Button button;
    //ArrayList <String> viewOutfits;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_outfits);

<<<<<<< HEAD

        /*this.image = (ImageView) findViewById(R.id.imageView);
        this.image2 = (ImageView) findViewById(R.id.imageView2);
        this.image3 = (ImageView) findViewById(R.id.imageView8);
        this.image4 = (ImageView) findViewById(R.id.imageView9);*/

        button = (Button) findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewOutfits.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
        long closetSize = new DBHandler(this).getNumEntries("closet");
        Cursor closetCursor = new DBHandler(this).fetch1("closet");

        for (int i = 0; i < closetSize; i++) {
            ImageView image = new ImageView(this);
            ImageView image2 = new ImageView(this);
            ImageView image3 = new ImageView(this);
            ImageView image4 = new ImageView(this);

            image.setId(i);
            image2.setId(i);
            image3.setId(i);
            image4.setId(i);

            ImageManager imageManager = new ImageManager(closetCursor);

            closetCursor.moveToPosition(i);
            String Acc = closetCursor.getString(1);
            String Tops = closetCursor.getString(2);
            String Bottoms = closetCursor.getString(3);
            String Shoes = closetCursor.getString(4);


            Bitmap imageDisplay = imageManager.stringToBitmap(Acc);
            Bitmap imageDisplay2 = imageManager.stringToBitmap(Tops);
            Bitmap imageDisplay3 = imageManager.stringToBitmap(Bottoms);
            Bitmap imageDisplay4 = imageManager.stringToBitmap(Shoes);

            image.setImageBitmap(imageDisplay);
            image2.setImageBitmap(imageDisplay2);
            image3.setImageBitmap(imageDisplay3);
            image4.setImageBitmap(imageDisplay4);

            TextView outfit = new TextView(this);
            int n = i+1;
            outfit.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            outfit.getLineSpacingExtra();
            outfit.getLineSpacingExtra();
            outfit.setText("Outfit: " + n);
            outfit.setTextColor(getResources().getColor(R.color.black));
            outfit.setTextSize(24);
            layout.addView(outfit);
            layout.addView(image);
            layout.addView(image2);
            layout.addView(image3);
            layout.addView(image4);

            int index = i;

        }

//
//        long closetSize = new DBHandler(this).getNumEntries("closet");
//        Log.d(TAG, "Closet Size: " + closetSize);
//
//        Cursor closetCursor = new DBHandler(this).fetch1("closet");
//
//        closetCursor.moveToPosition(0);
//        String ID = closetCursor.getString(0);
//        String Acc = closetCursor.getString(1);
//        String Tops = closetCursor.getString(2);
//        String Bottoms = closetCursor.getString(3);
//        String Shoes = closetCursor.getString(4);
//


=======
//        this.image = (ImageView) findViewById(R.id.imageView);
//        this.image2 = (ImageView) findViewById(R.id.imageView2);
//        this.image3 = (ImageView) findViewById(R.id.imageView8);
//        this.image4 = (ImageView) findViewById(R.id.imageView9);
//
//        button = (Button) findViewById(R.id.buttonBack1);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ViewOutfits.this, HomeActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        long closetSize = new DBHandler(this).getNumEntries("closet");
//        Log.d(TAG, "Closet Size: " + closetSize);
//
//        Cursor closetCursor = new DBHandler(this).fetch1("closet");
//
//        closetCursor.moveToPosition(0);
//        String ID = closetCursor.getString(0);
//        String Acc = closetCursor.getString(1);
//        String Tops = closetCursor.getString(2);
//        String Bottoms = closetCursor.getString(3);
//        String Shoes = closetCursor.getString(4);
//
//
//        Log.d(TAG, "Image for Accessories: "+ ID);
//        Log.d(TAG, "Image for Accessories: "+ Acc);
//        Log.d(TAG, "Image for Tops: "+ Tops);
//        Log.d(TAG, "Image for Bottoms: "+ Bottoms);
//        Log.d(TAG, "Image for Shoes: " + Shoes);
//
//
//        ImageView image = findViewById(R.id.imageView);
//        ImageManager imageManager = new ImageManager(closetCursor);
//        Bitmap imageDisplay = imageManager.stringToBitmap(Acc);
//        image.setImageBitmap(imageDisplay);
//
//        ImageView image2 = findViewById(R.id.imageView2);
//        ImageManager imageManager2 = new ImageManager (closetCursor);
//        Bitmap imageDisplay2 = imageManager2.stringToBitmap(Tops);
//        image2.setImageBitmap(imageDisplay2);
//
//        ImageView image3 = findViewById(R.id.imageView8);
//        ImageManager imageManager3 = new ImageManager (closetCursor);
//        Bitmap imageDisplay3 = imageManager3.stringToBitmap(Bottoms);
//        image3.setImageBitmap(imageDisplay3);
//
//        ImageView image4 = findViewById(R.id.imageView9);
//        ImageManager imageManager4 = new ImageManager (closetCursor);
//        Bitmap imageDisplay4 = imageManager4.stringToBitmap(Shoes);
//        image4.setImageBitmap(imageDisplay4);
//


        if (CreateOutfit.createOutfitArray[4] != null) {


            DBHandler db = new DBHandler(this);
            LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
            long size = db.getNumEntries("closet");
            Cursor cursor = db.fetch("closet");


            for (int i = 0; i < size; i++)
            {

                //Displaying closet button for each image button displayed
                ImageButton closetButton = new ImageButton(this);
                String uri = "@drawable/mycloset";
                int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                Drawable res = getResources().getDrawable(imageResource);
                closetButton.setImageDrawable(res);
                layout.addView((closetButton));



                cursor.moveToNext();
        }


        }
>>>>>>> 2ff06ff98f0573db275a6e37471c769f4de07dcc


            //closetCursor.moveToNext()
        }
    }


