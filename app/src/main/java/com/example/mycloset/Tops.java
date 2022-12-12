package com.example.mycloset;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mycloset.db.DBHandler;
import com.example.mycloset.utility.ImageManager;
import com.example.mycloset.CreateOutfit;

import java.io.FileNotFoundException;

public class Tops extends AppCompatActivity {
    public Button backButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tops);

        DBHandler db = new DBHandler(this);
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
        long size = db.getNumEntries("tops");
        Cursor cursor = db.fetch("tops");


        for (int i = 0; i < size; i++) 
        {
            //Displaying images from database
            ImageButton image = new ImageButton(this);
            image.setId(i);
            ImageManager imageManager = new ImageManager(cursor);
            Bitmap pic = imageManager.getImage();
            String picString = imageManager.bitmapToString(pic);
            image.setImageBitmap(pic);
            layout.addView(image);
            int index = i;

            //Displaying delete button for each image button displayed
            ImageButton deleteButton = new ImageButton(this);
            String uri = "@drawable/delete_icon";
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            deleteButton.setImageDrawable(res);
            layout.addView((deleteButton));

//            deleteButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    DBHandler db1 = new DBHandler(getApplicationContext());
//                    db1.deleteClothing(picString);
//                    Log.d("hi", "delete button works");
//                    Intent intent = new Intent(Tops.this, Tops.class);
//                    startActivity(intent);
//                }
//            });



            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CreateOutfit.createOutfitArray[0] = picString;
                    Intent intent = new Intent(Tops.this, Bottoms.class);
                    startActivity(intent);
                }
            });
            cursor.moveToNext();
        }


        //back button
        backButton = (Button) findViewById(R.id.button8);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Tops.this, ViewCloset.class);
                startActivity(intent);
            }
        });

    }

}




