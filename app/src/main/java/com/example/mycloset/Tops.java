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
import com.example.mycloset.db.DBHandler;
import com.example.mycloset.utility.ImageManager;
import com.example.mycloset.CreateOutfit;

public class Tops extends AppCompatActivity {
    public Button backButton;
    ImageManager im;
    public Bitmap imageTop;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tops);

        DBHandler db = new DBHandler(this);
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
        long size = db.getNumEntries("tops");
        Cursor cursor = db.fetch("tops");


        for (int i = 0; i < size; i++) {
            ImageButton image = new ImageButton(this);
            image.setId(i);
            ImageManager imageManager = new ImageManager(cursor);
            Bitmap pic = imageManager.getImage();
            String picString = imageManager.bitmapToString(pic);
            image.setImageBitmap(pic);
            layout.addView(image);
            int index = i;


           ImageButton deleteButton = new ImageButton(this);
//
//            deleteButton.setImageDrawable(getDrawable(delete_icon));
//            layout.addView(deleteButton);

            String uri = "@drawable/delete_icon";
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());

            //deleteButton = (ImageButton) findViewById(R.id.);
            Drawable res = getResources().getDrawable(imageResource);
            deleteButton.setImageDrawable(res);



            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CreateOutfit.createOutfitArray[0] = picString;
                    Log.d("poop", "Top string: " + CreateOutfit.createOutfitArray[0]);
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



