package com.example.mycloset;

import android.content.Intent;
import android.graphics.Bitmap;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.net.Uri;
import com.example.mycloset.db.DBHandler;
import com.example.mycloset.utility.ColourExtractor;
import com.example.mycloset.utility.ImageManager;
import java.io.IOException;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.io.InputStream;
import java.util.List;
import com.example.mycloset.db.DBHandler;

public class Camera extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;

    private static final int GALLERY_REQUEST = 100;
    private static final int CAMERA_REQUEST = 200;

    private ImageView selectedImageView;
    private EditText titleEditText;

    ColourExtractor colourExtractor = new ColourExtractor();
    String color = colourExtractor.getColor();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_closet);
        this.selectedImageView = (ImageView) findViewById(R.id.new_clothing);
        spinner = findViewById(R.id.spinnerUser);

        loadSpinnerData();
        //this.titleEditText = (EditText) findViewById(R.id.new_memory_title);

    }

    private void loadSpinnerData() {
        DBHandler db = new DBHandler(getApplicationContext());
        List<String> user = db.getAllUsers();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, user);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }


    public void openGallery(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), GALLERY_REQUEST);
    }

    public void openCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CAMERA_REQUEST);
        }
    }

    public void cancel(View view) {
        Intent home = new Intent(Camera.this, HomeActivity.class);
        startActivity(home);
    }

    public void tops(View view) {

        Bitmap image = ((BitmapDrawable)selectedImageView.getDrawable()).getBitmap();
        Spinner spinner = (Spinner) findViewById(R.id.spinnerUser);
        String user = "";
        user = spinner.getSelectedItem().toString();
        Log.d("user", user);
        ImageManager imageManager = new ImageManager(user, image);

        //Log.d("color", "testing");

        colourExtractor.paletteAsync(image);
        color = colourExtractor.getColor();

        Log.d("color", "From Tops: " + color);
//        Log.d("color", "testing_2");


        new DBHandler(this).addClothing(imageManager, 0, color, user);

        Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_LONG).show();
        Intent reload = new Intent(Camera.this, Camera.class);
        startActivity(reload);

    }

    public void bottoms(View view) {
        Bitmap image = ((BitmapDrawable)selectedImageView.getDrawable()).getBitmap();
        Spinner spinner = (Spinner) findViewById(R.id.spinnerUser);
        String user = "";
        user = spinner.getSelectedItem().toString();
        Log.d("user", user);
        ImageManager imageManager = new ImageManager(user, image);

        colourExtractor.paletteAsync(image);
        color = colourExtractor.getColor();

        new DBHandler(this).addClothing(imageManager, 1, color, user);

        Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_LONG).show();
        Intent reload = new Intent(Camera.this, Camera.class);
        startActivity(reload);
    }

    public void shoes(View view) {
        Bitmap image = ((BitmapDrawable)selectedImageView.getDrawable()).getBitmap();
        Spinner spinner = (Spinner) findViewById(R.id.spinnerUser);
        String user = "";
        user = spinner.getSelectedItem().toString();
        Log.d("user", user);
        ImageManager imageManager = new ImageManager(user, image);

        colourExtractor.paletteAsync(image);
        color = colourExtractor.getColor();

        new DBHandler(this).addClothing(imageManager, 2, color, user);

        Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_LONG).show();
        Intent reload = new Intent(Camera.this, Camera.class);
        startActivity(reload);
    }

    public void accessories(View view) {
        Bitmap image = ((BitmapDrawable)selectedImageView.getDrawable()).getBitmap();
        Spinner spinner = (Spinner) findViewById(R.id.spinnerUser);
        String user = "";
        user = spinner.getSelectedItem().toString();
        Log.d("user", user);
        ImageManager imageManager = new ImageManager(user, image);

        new DBHandler(this).addClothing(imageManager, 3, "any",user);

        Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_LONG).show();
        Intent reload = new Intent(Camera.this, Camera.class);
        startActivity(reload);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK) {
            try {
                Uri selectedImage = data.getData();
                InputStream imageStream = getContentResolver().openInputStream(selectedImage);
                selectedImageView.setImageBitmap(BitmapFactory.decodeStream(imageStream));
            } catch (IOException exception){
                exception.printStackTrace();
            }
        }

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap image = (Bitmap)extras.get("data");
            selectedImageView.setImageBitmap(image);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String user = parent.getItemAtPosition(i).toString();
        Toast.makeText(parent.getContext(), "You Selected: " + user, Toast.LENGTH_LONG).show();


    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}