package com.example.mycloset;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class ViewOutfits extends AppCompatActivity {
    ImageView image;
    public Button button;
    boolean image1Displaying = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_outfits);
        image = findViewById(R.id.imageView2);

        button = (Button) findViewById(R.id.buttonBack1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewOutfits.this, ViewCloset.class);
                startActivity(intent);
            }
        });

       /* image = (ImageView) findViewById(R.id.imageView2);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            int resId = bundle.getInt("image2");
            image.setImageResource(resId);

        }*/
    }

}


       /* image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(image1Displaying){
                    image.setImageBitmap(BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.top1));

                }else{
                    image.setImageBitmap(BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.tops5));

                }
                return false;
            }


        });*/





/* image = (ImageView)findViewById(R.id.imageView2);

        Bundle bundle = getIntent().getExtras();
        if(bundle!= null)
        {
            int resId = bundle.getInt("resId");
            image.setImageResource(resId);
        }*/