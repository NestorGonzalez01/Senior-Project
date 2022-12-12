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
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.mycloset.db.DBHandler;
import com.example.mycloset.utility.ImageManager;
import com.example.mycloset.CreateOutfit;

import java.lang.reflect.AccessibleObject;


public class Accessories extends AppCompatActivity {
    public Button button;
    public ImageView topsImageView, bottomsImageView, shoesImageView, accessoriesImageView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottoms);

        DBHandler db = new DBHandler(this);
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
        long size = db.getNumEntries("accessories");
        Cursor cursor = db.fetch("accessories");

        for (int i = 0; i < size; i++) {
            ImageButton image = new ImageButton(this);
            image.setId(i);
            ImageManager imageManager = new ImageManager(cursor);
            Bitmap pic = imageManager.getImage();
            String picString = imageManager.bitmapToString(pic);
            image.setImageBitmap(pic);
            layout.addView(image);
            int index = i;


            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CreateOutfit.createOutfitArray[3] = picString;
                    CreateOutfit.createOutfitArray[4] = "yes";
                    Log.d("Array4:", "Array 4 should be: " + CreateOutfit.createOutfitArray[4]);

                    Intent intent = new Intent(Accessories.this, CreateOutfit.class);
                    startActivity(intent);

                }
            });
            cursor.moveToNext();
        }

        //back button
        button = (Button) findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Accessories.this, ViewCloset.class);
                startActivity(intent);
            }
        });

    }

}