package com.example.mycloset;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

import com.example.mycloset.db.DBHandler;


import androidx.appcompat.app.AppCompatActivity;

public class User extends AppCompatActivity {
    private EditText userNameEdt;
    private Button button;
    private Button back;
    private DBHandler dbHandler;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        back = (Button) findViewById(R.id.buttonBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User.this, HomeActivity.class);
                startActivity(intent);


            }
        });

        //userNameEdt = findViewById(R.id.editUserName);
        button = findViewById(R.id.buttonUser);

        dbHandler = new DBHandler(User.this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = userNameEdt.getText().toString();

                if (userName.isEmpty()) {
                    Toast.makeText(User.this, "Please enter a new name", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.insertUser(userName);

                Toast.makeText(User.this, "Name has been added.", Toast.LENGTH_SHORT).show();
                userNameEdt.setText("");
            }
        });


    }

}




//    public void newUser(View view) {
//
//    }
//
//    public void addUser(View view) {
//        startActivity(new Intent(this, AddUser.class));
//
//    }


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