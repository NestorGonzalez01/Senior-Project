package com.example.mycloset;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

import com.example.mycloset.db.DBHandler;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class User extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private Button button;
    private Button backButton;
    private Button btnDelete;
    private EditText inputUser;
    private DBHandler dbHandler;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        spinner = findViewById(R.id.spinnerUser);
        button = findViewById(R.id.buttonUser);
        inputUser = findViewById(R.id.editUserName);
        btnDelete = findViewById(R.id.buttonDelete);

        loadSpinnerData();

        backButton = (Button) findViewById(R.id.buttonBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btnDelete = (Button) findViewById(R.id.buttonDelete);
        btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                delete();
            }
        });

        button = findViewById(R.id.buttonUser);

        dbHandler = new DBHandler(User.this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = inputUser.getText().toString();

                if (user.trim().length()>0) {
                    DBHandler db = new DBHandler(getApplicationContext());
                    Log.d("User", "Inserted");
                    db.insertUser(user);
                    Log.d("User", "Added");
                    inputUser.setText("");

                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(inputUser.getWindowToken(),0);

                    loadSpinnerData();

                }else{
                    Toast.makeText(getApplicationContext(), "Please enter a valid Name", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void loadSpinnerData() {
        DBHandler db = new DBHandler(getApplicationContext());
        List<String>user = db.getAllUsers();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, user);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String user = parent.getItemAtPosition(i).toString();

        Toast.makeText(parent.getContext(), "You Selected: " + user, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void delete(){
        int i = spinner.getSelectedItemPosition();

        if(i > -1)
        {
            DBHandler db = new DBHandler(getApplicationContext());
            String user = spinner.getItemAtPosition(i).toString();
            Log.d("User", "Insert:  " + user);
            db.deleteName(user);
            Log.d("User", user + " Deleted: ");
        }
    }
}

