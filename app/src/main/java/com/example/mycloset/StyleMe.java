package com.example.mycloset;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mycloset.utility.ImageManager;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.example.mycloset.db.DBHandler;
import com.example.mycloset.utility.ColourExtractor;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.URI;
import java.util.ArrayList;
import java.util.Random;

public class StyleMe extends AppCompatActivity {

    ArrayList <String> chosen;
    ArrayList <String> randChosen;
    //private ImageView image;
    //private ImageView image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_me);

       // this.image2 = (ImageView) findViewById(R.id.imageView4);
    }

    public void styleMe(View v) throws FileNotFoundException {
        //Log.d("hi", "hello");

        //Size of the Tops table and Bottoms Table
        long s = new DBHandler(this).getNumEntries("tops");
        long b = new DBHandler(this).getNumEntries("bottoms");

        Log.d("size", "Table Top size is: " + s);
        Log.d("size", "Table Bottom size is: " + b);

        //random number chosen for Tops
        int n = new Random().nextInt((int)s);
        Log.d("size", "Tops Random number: " + n);

        //fetch the cursor of Tops and Bottoms
        Cursor topCursor = new DBHandler(this).fetch("tops");
        Cursor bottomCursor = new DBHandler(this).fetch("bottoms");

        //position of the random cloth
        topCursor.moveToPosition(n);
        String IdTop = topCursor.getString(0);

        //Initialize the arrays, so that we can store the matching ones in array
        chosen = new ArrayList<String>();
        randChosen = new ArrayList<String>();

        for (int i = 0; i < b; i++) {
            //finds position of the cloth stored
            bottomCursor.moveToPosition(i);
            //The id of the cloth
            String Id = bottomCursor.getString(0);
            Log.d(TAG, "ID: " + Id);
            //the color of the cloth
            String color = bottomCursor.getString(3);
            Log.d(TAG, "Color: " + color);
            //the random color that was chosen from tops
            String randColor = topCursor.getString(3);
            Log.d(TAG, "Random Color: " + randColor);

            //Compare the colors using complementary colors
            if (randColor.equals("any") || color.equals("any")){
                chosen.add(Id);
            }
            else if(randColor.equals("red") && color.equals("green")){
                chosen.add(Id);
            }
            else if(randColor.equals("orange") && color.equals("blue")){
                chosen.add(Id);
            }
            else if(randColor.equals("yellow") && color.equals("purple")){
                chosen.add(Id);
            }
            else if(randColor.equals("green") && color.equals("red")){
                chosen.add(Id);
            }
            else if(randColor.equals("blue") && color.equals("orange")){
                chosen.add(Id);
            }
            else if(randColor.equals("purple") && color.equals("yellow")){
                chosen.add(Id);
            } else{}
        }
        //Array Size
        Log.d(TAG, "Array Size: " + chosen.size());

        //Displaying the Array order
        for (int j = 0; j < chosen.size(); j++) {
            Log.d(TAG, "Array ID's: " + chosen.get(j));
        }

        //Grab Random number of Bottoms that was chosen
        int randBottom = new Random().nextInt(chosen.size());
        Log.d(TAG, "Bottoms Random Number: " + randBottom);

        bottomCursor.moveToPosition(randBottom);
        String IdBottom = bottomCursor.getString(0);
        String imageBottom = bottomCursor.getString(1); //Image bottom
        String imageTop = topCursor.getString(1); //Image top

        randChosen.add(IdTop);
        randChosen.add(IdBottom);

        //Size of random array
        Log.d(TAG, "Random Array Size: " + randChosen.size());

        //What id is stored in Random Array
       for (int k = 0; k < randChosen.size() ; k++) {
            Log.d(TAG, "Stored Random Array Id: " + randChosen.get(k));
        }



       //Grab the first image and set it on StyleMe for TOps
     /*   ImageView image1 = findViewById(R.id.imageView4);
        image1 = new ImageView(this);
        ImageManager imageManager1 = new ImageManager(topCursor);
        Bitmap imageDisplay1 = imageManager1.getImage();
        image1.setImageBitmap(imageDisplay1);*/

        //Grab the second image and set to Style me for Bottoms
      /*  ImageView image2;
        image2 = new ImageView(this);
        ImageManager imageManager2 = new ImageManager(bottomCursor);
        Bitmap imageDisplay2 = imageManager2.getImage();
        image2.setImageBitmap(imageDisplay2);*/












        /* Cursor cursor = new DBHandler(this).fetch("tops");
        cursor.moveToPosition(n);
        String id = cursor.getString(0);
        String image = cursor.getString(1);
        String description = cursor.getString(2);
        String color = cursor.getString(3);

        Log.d("size", "ID: "+ id);
        Log.d("size", "Image: "+ image);
        Log.d("size", "Des: "+ description);
        Log.d("size", "Color: "+ color);*/
    }

}