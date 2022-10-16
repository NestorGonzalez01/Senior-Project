package com.example.mycloset;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class ViewCloset extends AppCompatActivity {
    public Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_closet);
        button = findViewById(R.id.buttonTops);


        button = (Button) findViewById(R.id.buttonTops);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewCloset.this, Tops.class);
                startActivity(intent);
            }
        });

        button = findViewById(R.id.buttonBottoms);
        button = (Button) findViewById(R.id.buttonBottoms);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewCloset.this, Bottoms.class);
                startActivity(intent);
            }
        });

        button = findViewById(R.id.buttonShoes);
        button = (Button) findViewById(R.id.buttonShoes);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewCloset.this, Shoes.class);
                startActivity(intent);
            }
        });

        button = findViewById(R.id.buttonAccess);
        button = (Button) findViewById(R.id.buttonAccess);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewCloset.this, Accessories.class);
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewCloset.this, HomeActivity.class);
                startActivity(intent);
            }
        });


    }
}

