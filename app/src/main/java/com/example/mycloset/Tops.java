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
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import com.example.mycloset.CreateOutfit;
import com.example.mycloset.db.DBHandler;
import com.example.mycloset.utility.ImageManager;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.Console;
import java.io.InputStream;
import java.net.URI;
import com.example.mycloset.db.DBHandler;
import android.util.Log;

public class Tops extends AppCompatActivity {
    ImageButton imgButton;
    public Button button;
    ImageButton imageButton, imageButton5, imageButton4, imageButton3, imageButton2;
    private ImageButton selectedImageButton;
    //ImageManager im;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tops);

        DBHandler db = new DBHandler(this);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        long size = db.getNumEntries("tops");
        Cursor cursor = db.fetch("tops");
        //ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < size; i++) {
            ImageButton image = new ImageButton(this);
            ImageManager imageManager = new ImageManager(cursor);
            Bitmap pic = imageManager.getImage();
//            ConstraintLayout.LayoutParams ly = new ConstraintLayout.LayoutParams();
//            image.setLayoutParams(params);
//            image.setMaxHeight(20);
//            image.setMaxWidth(20);
            //Bitmap bImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.bottoms1);
            image.setImageBitmap(pic);
//            if(image.getParent() != null) {
//                ((ViewGroup)image.getParent()).removeView(image);
//            }
//            Log.d("test", "hell");
            layout.addView(image);
            //ly = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.MATCH_PARENT);

            cursor.moveToNext();
        }

//        //back button
//        button = (Button) findViewById(R.id.button8);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Tops.this, ViewCloset.class);
//                startActivity(intent);
//            }
//        });

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
//
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


