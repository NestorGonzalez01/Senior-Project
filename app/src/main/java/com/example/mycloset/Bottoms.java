package com.example.mycloset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Bottoms extends AppCompatActivity {
    public Button button;
    ImageButton imageBottom1, imageBottom2, imageBottom3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottoms);

        button = (Button) findViewById(R.id.buttonBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bottoms.this, ViewCloset.class);
                startActivity(intent);
            }
        });

        imageBottom1 = findViewById(R.id.imageBottom1);
        imageBottom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bottoms.this, Shoes.class);
                startActivity(intent);
            }
        });

        imageBottom2 = findViewById(R.id.imageBottom2);
        imageBottom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bottoms.this, Shoes.class);
                startActivity(intent);
            }
        });

        imageBottom3 = findViewById(R.id.imageBottom3);
        imageBottom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bottoms.this, Shoes.class);
                startActivity(intent);
            }
        });
    }
}