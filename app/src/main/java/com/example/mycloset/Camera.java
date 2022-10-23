package com.example.mycloset;

//

import static android.app.PendingIntent.getActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycloset.Fragments.CameraFragment;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
//////////////////////

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.net.Uri;

import com.example.mycloset.R;
import com.example.mycloset.db.DBHandler;
import com.example.mycloset.utility.ImageManager;
//////////////////////


//import com.example.mycloset.Fragments.CameraFragment;
//import com.example.mycloset.db.DBHandler;

import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;

public class Camera extends AppCompatActivity {

//    FrameLayout frameLayout;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.camera);
//
//        loadFragment(new CameraFragment(), false);
//
//    }
//
//    public void loadFragment(Fragment fragment, Boolean bool) {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.frameLayout, fragment);
//        if (bool)
//            transaction.addToBackStack(null);
//        transaction.commit();
//    }

    private static final int GALLERY_REQUEST = 100;
    private static final int CAMERA_REQUEST = 200;

    private ImageView selectedImageView;
    private EditText titleEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_closet);
        this.selectedImageView = (ImageView) findViewById(R.id.new_clothing);
        this.titleEditText = (EditText) findViewById(R.id.new_memory_title);
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

//    public void save(View view) {
//        Bitmap image = ((BitmapDrawable)selectedImageView.getDrawable()).getBitmap();
//        ImageManager imageManager = new ImageManager(titleEditText.getText().toString(), image);
//
//        new DBHandler(this).addClothing(imageManager);
//        finish();
//    }

    public void tops(View view) {
        Bitmap image = ((BitmapDrawable)selectedImageView.getDrawable()).getBitmap();
        ImageManager imageManager = new ImageManager(titleEditText.getText().toString(), image);
        new DBHandler(this).addClothing(imageManager, 0);

        Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_LONG).show();
        Intent reload = new Intent(Camera.this, Camera.class);
        startActivity(reload);
    }

    public void bottoms(View view) {
        Bitmap image = ((BitmapDrawable)selectedImageView.getDrawable()).getBitmap();
        ImageManager imageManager = new ImageManager(titleEditText.getText().toString(), image);
        new DBHandler(this).addClothing(imageManager, 1);

        Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_LONG).show();
        Intent reload = new Intent(Camera.this, Camera.class);
        startActivity(reload);
    }

    public void shoes(View view) {
        Bitmap image = ((BitmapDrawable)selectedImageView.getDrawable()).getBitmap();
        ImageManager imageManager = new ImageManager(titleEditText.getText().toString(), image);
        new DBHandler(this).addClothing(imageManager, 2);

        Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_LONG).show();
        Intent reload = new Intent(Camera.this, Camera.class);
        startActivity(reload);
    }

    public void accessories(View view) {
        Bitmap image = ((BitmapDrawable)selectedImageView.getDrawable()).getBitmap();
        ImageManager imageManager = new ImageManager(titleEditText.getText().toString(), image);
        new DBHandler(this).addClothing(imageManager, 3);

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
}