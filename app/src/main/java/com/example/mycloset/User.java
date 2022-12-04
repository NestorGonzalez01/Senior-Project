package com.example.mycloset;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class User extends Activity {
    public Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        button = findViewById(R.id.buttonUser);
    }

    public void newUser(View view) {

    }

    public void addUser(View view) {
        startActivity(new Intent(this, AddUser.class));

    }


   /* button =(Button)

    findViewById(R.id.buttonUser);
        button.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        Intent intent = new Intent(User.this, AddUser.class);
        startActivity(intent);
    }
    });*/
}

