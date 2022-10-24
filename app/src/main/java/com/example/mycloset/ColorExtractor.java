package com.example.mycloset;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

public class ColorExtractor extends AppCompatActivity {
    private LinearLayout rootLayout;
    private TextView textViewTitle;
    private TextView textViewBody;
    private ImageView imageView;

    private Palette.Swatch vibrantSwatch;
    private Palette.Swatch lightVibrantSwatch;
    private Palette.Swatch darkVibrantSwatch;
    private Palette.Swatch mutedSwatch;
    private Palette.Swatch lightMutedSwatch;
    private Palette.Swatch darkMutedSwatch;

    private int swatchNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        rootLayout = findViewById(R.id.root);
        textViewTitle = findViewById(R.id.text_view_title);
        textViewBody = findViewById(R.id.text_view_body);
        imageView = findViewById(R.id.image_view);

        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();

//        int color = bitmap.getPixel(bitmap.getWidth()-1, bitmap.getHeight()-1);
//
//        int red = Color.red(color);
//        int green = Color.green(color);
//        int blue = Color.blue(color);
//        int alpha = Color.alpha(color);
//
//        Log.d("color", String.valueOf(red));
//        Log.d("color", String.valueOf(green));
//        Log.d("color", String.valueOf(blue));
//        Log.d("color", String.valueOf(alpha));
//
//        float hsv[] = new float[3];
//        Color.RGBToHSV(red, green, blue, hsv);
//        float hue = hsv[0];
//        float sat = hsv[1];
//        float val = hsv[2];
//
//        Log.d("color", String.valueOf(hue));
//        Log.d("color", String.valueOf(sat));
//        Log.d("color", String.valueOf(val));




        Palette.from(bitmap).maximumColorCount(32).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                vibrantSwatch = palette.getVibrantSwatch();
                lightVibrantSwatch = palette.getLightVibrantSwatch();
                darkVibrantSwatch = palette.getDarkVibrantSwatch();
                mutedSwatch = palette.getMutedSwatch();
                lightMutedSwatch = palette.getLightMutedSwatch();
                darkMutedSwatch = palette.getDarkMutedSwatch();
            }
        });
    }
    public void nextSwatch(View v) {
        Palette.Swatch currentSwatch = null;
        switch (swatchNumber) {
            case 0:
                currentSwatch = vibrantSwatch;
                textViewTitle.setText("Vibrant");
                break;
            case 1:
                currentSwatch = lightVibrantSwatch;
                textViewTitle.setText("LightVibrant");
                break;
            case 2:
                currentSwatch = darkVibrantSwatch;
                textViewTitle.setText("Dark Vibrant");
                break;
            case 3:
                currentSwatch = mutedSwatch;
                textViewTitle.setText("Muted");
                break;
            case 4:
                currentSwatch = lightMutedSwatch;
                textViewTitle.setText("Light Muted");
                break;
            case 5:
                currentSwatch = darkMutedSwatch;
                textViewTitle.setText("Dark Muted");
                break;
        }
        if (currentSwatch != null) {
            rootLayout.setBackgroundColor(currentSwatch.getRgb());
            textViewTitle.setTextColor(currentSwatch.getTitleTextColor());
            textViewBody.setTextColor(currentSwatch.getBodyTextColor());

            int color = currentSwatch.getRgb();

            int red = Color.red(color);
            int green = Color.green(color);
            int blue = Color.blue(color);
            int alpha = Color.alpha(color);

            Log.d("color", String.valueOf(red));
            Log.d("color", String.valueOf(green));
            Log.d("color", String.valueOf(blue));
            Log.d("color", String.valueOf(alpha));

            float hsv[] = new float[3];
            Color.RGBToHSV(red, green, blue, hsv);
            float hue = hsv[0];
            float sat = hsv[1];
            float val = hsv[2];

            Log.d("color", "Hue: " + String.valueOf(hue));
            Log.d("color", "Sat: " + String.valueOf(sat));
            Log.d("color", "Val: " + String.valueOf(val));

            //Log.d("color", String.valueOf(currentSwatch.getRgb()));
//            if (color >= -495592) {
//                Log.d("color", "It's Orange");
//            }
//            else if (color < -495592 && color > -989152) {
//                Log.d("color", "It's Red");
//            } else if (color <= -989152 && color > -12576688){
//                Log.d("color", "It's Yellow");
//            } else if (color <= -12576688 && color > -14125032){ //Dark Vibrant
//                Log.d("color", "It's Purple");
//            } else if (color <= -14125032 && color > -16776968) { //Dark Vibrant
//                Log.d("color", "It's Green");
//            } else if (color <= -16776968){
//                Log.d("color", "It's Blue");
//            }

//            if (((hue >= 0 && hue <= 20) || (hue > 330 && hue <= 360)) && (val > 0.1)) {
//                Log.d("color", "It's Red");
//            } else if ((hue > 20 && hue <= 45) && (val > 0.1)){
//                Log.d("color", "It's Orange");
//            } else if ((hue > 45 && hue <= 75) && (val > 0.1)){
//                Log.d("color", "It's Yellow");
//            } else if ((hue > 75 && hue <= 165) && (val > 0.1)){
//                Log.d("color", "It's Green");
//            } else if ((hue > 165 && hue <= 260) && (val > 0.1)){
//                Log.d("color", "It's Blue");
//            } else if ((hue > 260 && hue <= 330) && (val > 0.1)){
//                Log.d("color", "It's Purple");
//            } else if (val <= 0.1) {
//                Log.d("color", "It's Black");
//            } else if (sat > 0.9 && val < 0.1) {
//                Log.d("color", "It's White");
//            }


            if (sat < 0.1 && val > 0.9) {
                Log.d("color", "It's White");
            } else if (val < 0.1) {
                Log.d("color", "It's Black");
            }
            else if ((hue >= 0 && hue <= 20) || (hue > 330 && hue <= 360)) {
                Log.d("color", "It's Red");
            } else if (hue > 20 && hue <= 45){
                Log.d("color", "It's Orange");
            } else if (hue > 45 && hue <= 70){
                Log.d("color", "It's Yellow");
            } else if (hue > 70 && hue <= 165){
                Log.d("color", "It's Green");
            } else if (hue > 165 && hue <= 260){
                Log.d("color", "It's Blue");
            } else if (hue > 260 && hue <= 330){
                Log.d("color", "It's Purple");
            }


        } else {
            rootLayout.setBackgroundColor(Color.WHITE);
            textViewTitle.setTextColor(Color.RED);
            textViewTitle.setTextColor(Color.RED);
        }
        if (swatchNumber < 5) {
            swatchNumber++;
        } else {
            swatchNumber = 0;
        }
    }
}
