package com.example.mycloset;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class ViewOutfits extends AppCompatActivity {
    //ImageView i1;
    public Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_outfits);

        //Adding Action to go Back to Home
        button = (Button) findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewOutfits.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        /*i1 = (ImageView)findViewById(R.id.imageView2);

        Bundle bundle = getIntent().getExtras();
        if(bundle!= null)
        {
            int resId = bundle.getInt("resId");
            i1.setImageResource(resId);
        }
*/

    }
}