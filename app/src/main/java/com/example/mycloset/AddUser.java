package com.example.mycloset;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AddUser extends Activity {
    EditText ET_NAME;
    String name;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adduser);
        ET_NAME = (EditText)findViewById(R.id.personName);
    }

    public void userName(View view){

        name = ET_NAME.getText().toString();
        String method = "add";
        BackgroundText backgroundText = new BackgroundText(this);
        backgroundText.execute(method,name);
    }
}
