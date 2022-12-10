package com.example.mycloset;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mycloset.utility.ImageManager;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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

    ArrayList <String> bottomChosen;
    ArrayList <String> shoeChosen;
    ArrayList <String> accChosen;


    ArrayList <String> randChosen;
    private ImageView image;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_me);

       this.image = (ImageView) findViewById(R.id.imageView4);
       this.image2 = (ImageView) findViewById(R.id.imageView5);
       this.image3 = (ImageView) findViewById(R.id.imageView6);
       this.image4 = (ImageView) findViewById(R.id.imageView7);
    }

    public void GetCompare(long size, Cursor topCursor, Cursor cursor, ArrayList <String> chosen){

        for (int i = 0; i < size; i++) {
            //finds position of the cloth stored
            cursor.moveToPosition(i);
            //The id of the cloth
            String Id = cursor.getString(0);
            //Log.d(TAG, "ID: " + Id);
            //the color of the cloth
            String color = cursor.getString(3);
            //Log.d(TAG, "Color: " + color);
            //the random color that was chosen from tops
            String randColor = topCursor.getString(3);
            //Log.d(TAG, "Random Color: " + randColor);

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
        //Log.d(TAG, "Array Size: " + chosen.size());

        //Displaying the Array order
     /*   for (int j = 0; j < chosen.size(); j++) {
            Log.d(TAG, "Array ID's: " + chosen.get(j));
        }*/

        //Grab Random number of Bottoms that was chosen
        int randBottom = new Random().nextInt(chosen.size());
        //Log.d(TAG, "Bottoms Random Number: " + randBottom);

        cursor.moveToPosition(randBottom);
        //String IdBottom = cursor.getString(0);
        //String imageBottom = cursor.getString(1); //Image bottom
        //String imageTop = topCursor.getString(1); //Image top
    }



    public void styleMe(View v) throws FileNotFoundException {
        //Log.d("hi", "hello");

        //Size of the Tops table and Bottoms Table
        long s = new DBHandler(this).getNumEntries("tops");
        long b = new DBHandler(this).getNumEntries("bottoms");
        long sh = new DBHandler(this).getNumEntries("shoes");
        long acc = new DBHandler(this).getNumEntries("accessories");

      /*  Log.d("size", "Table Top size is: " + s);
        Log.d("size", "Table Bottom size is: " + b);
        Log.d("size", "Table Shoes size is: " + sh);
        Log.d("size", "Tbale Accessories size is "+ acc);*/

        //random number chosen for Tops
        int n = new Random().nextInt((int)s);
        //Log.d("size", "Tops Random number: " + n);

        //fetch the cursor of Tops and Bottoms
        Cursor topCursor = new DBHandler(this).fetch("tops");
        Cursor bottomCursor = new DBHandler(this).fetch("bottoms");
        Cursor shoeCursor = new DBHandler(this).fetch("shoes");
        Cursor accCursor = new DBHandler(this).fetch("accessories");


        //position of the random cloth
        topCursor.moveToPosition(n);
        String IdTop = topCursor.getString(0);

        //Initialize the arrays, so that we can store the matching ones in array
        bottomChosen = new ArrayList<String>();
        shoeChosen = new ArrayList<String>();
        accChosen = new ArrayList<String>();

        GetCompare(b, topCursor, bottomCursor, bottomChosen);
        GetCompare(sh, topCursor, shoeCursor, shoeChosen);
        GetCompare(acc, topCursor, accCursor, accChosen);

       //Grab the first image and set it on StyleMe for TOps
        ImageView image1 = findViewById(R.id.imageView4);
        ImageManager imageManager1 = new ImageManager(topCursor);
        //Log.d(TAG, "Top Cursor: " + topCursor);
        Bitmap imageDisplay1 = imageManager1.getImage();
        //Log.d(TAG, "Bitmap: " + imageDisplay1);
        image1.setImageBitmap(imageDisplay1);

        //Grab the second image and set to Style me for Bottoms
        ImageView image2 = findViewById(R.id.imageView5);
        ImageManager imageManager2 = new ImageManager(bottomCursor);
        Bitmap imageDisplay2 = imageManager2.getImage();
        image2.setImageBitmap(imageDisplay2);

        //Grab the third image and set to Style me for Shoes
        ImageView image3 = findViewById(R.id.imageView6);
        ImageManager imageManager3 = new ImageManager(shoeCursor);
        Bitmap imageDisplay3 = imageManager3.getImage();
        image3.setImageBitmap(imageDisplay3);

        //Grab the fourth and final image and set to Style me for Accessories
        ImageView image4 = findViewById(R.id.imageView7);
        ImageManager imageManager4 = new ImageManager(accCursor);
        Bitmap imageDisplay4 = imageManager4.getImage();
        image4.setImageBitmap(imageDisplay4);

    }

}