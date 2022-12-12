package com.example.mycloset;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.mycloset.utility.ImageManager;


public class CreateOutfit extends AppCompatActivity {


    public static String[] createOutfitArray = new String[5];
    public Button button;
    ImageView imageView3;
    ImageManager im;
    ImageView topsImageView, bottomsImageView, shoesImageView, accessoriesImageView;



   // ImageView imageView = (ImageView)findViewById(R.id.imageButton);
    //int resourceId = getIntent().getIntExtra("Top_1",R.drawable.ic_launcher_background);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_outfit);

        Log.d("Array4:", "Array 4 should be blank:" + createOutfitArray[4]);
        if(createOutfitArray[4] != null) {
            Log.d("Array4", "This should display images " + createOutfitArray[4]);
            String topString = CreateOutfit.createOutfitArray[0];
            Log.d("test", "Top string: " + topString);
            Bitmap topBitmap = im.stringToBitmap(topString);
            Log.d("test", "Top");
            ImageView topsImageView = findViewById(R.id.topImageView);
            topsImageView.setImageBitmap(topBitmap);

            String bottomString = CreateOutfit.createOutfitArray[1];
            Bitmap bottomBitmap = im.stringToBitmap(bottomString);
            ImageView bottomsImageView = findViewById(R.id.bottomImageView);
            bottomsImageView.setImageBitmap(bottomBitmap);

            String shoesString = CreateOutfit.createOutfitArray[2];
            Bitmap shoesBitmap = im.stringToBitmap(shoesString);
            ImageView shoesImageView = findViewById(R.id.shoesImageView);
            shoesImageView.setImageBitmap(shoesBitmap);

            String accessoriesString = CreateOutfit.createOutfitArray[3];
            Bitmap accessoriesBitmap = im.stringToBitmap(accessoriesString);
            ImageView accessoriesImageView = findViewById(R.id.accessoriesImageView);
            accessoriesImageView.setImageBitmap(accessoriesBitmap);
        }



            //Adding Action to go Back to Home
            button = (Button) findViewById(R.id.backButton);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CreateOutfit.this, HomeActivity.class);
                    startActivity(intent);
                }
            });

            //Adding Action to Save
            button = (Button) findViewById(R.id.button3);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CreateOutfit.this, ViewOutfits.class);
                    startActivity(intent);
                }
            });

            //Adding Action to Add From Closet
            imageView3 = findViewById(R.id.imageView3);
            imageView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CreateOutfit.this, Tops.class);
                    startActivity(intent);
                }
            });

    }
}