package com.example.mycloset.utility;

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

public class ColourExtractor {

    private Palette.Swatch vibrantSwatch;
    private Palette.Swatch lightVibrantSwatch;
    private Palette.Swatch darkVibrantSwatch;
    private Palette.Swatch mutedSwatch;
    private Palette.Swatch lightMutedSwatch;
    private Palette.Swatch darkMutedSwatch;
    private static String color = "any";

    public void paletteAsync(Bitmap bitmap) {

        Palette p = createPaletteSync(bitmap);

        vibrantSwatch = p.getVibrantSwatch();
        lightVibrantSwatch = p.getLightVibrantSwatch();
        darkVibrantSwatch = p.getDarkVibrantSwatch();
        mutedSwatch = p.getMutedSwatch();
        lightMutedSwatch = p.getLightMutedSwatch();
        darkMutedSwatch = p.getDarkMutedSwatch();

        if(vibrantSwatch != null) {
            color = isColor(vibrantSwatch);
        } else if (lightVibrantSwatch != null) {
            color = isColor(lightVibrantSwatch);
        } else if (darkVibrantSwatch != null) {
            color = isColor(darkVibrantSwatch);
        } else if (mutedSwatch != null) {
            color = isColor(mutedSwatch);
        } else if (lightMutedSwatch != null) {
            color = isColor(lightMutedSwatch);
        } else if (darkMutedSwatch != null) {
            color = isColor(darkMutedSwatch);
        }

        Log.d("color", "From Colour: " + color);
    };

    public String getColor() {
        return this.color;
    };

    public Palette createPaletteSync(Bitmap bitmap) {
        Palette p = Palette.from(bitmap).maximumColorCount(32).generate();
        return p;
    }

    public String isColor(Palette.Swatch swatch) {

        int color = swatch.getRgb();
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = Color.alpha(color);

//        Log.d("color", String.valueOf(red));
//        Log.d("color", String.valueOf(green));
//        Log.d("color", String.valueOf(blue));
//        Log.d("color", String.valueOf(alpha));

        float hsv[] = new float[3];
        Color.RGBToHSV(red, green, blue, hsv);
        float hue = hsv[0];
        float sat = hsv[1];
        float val = hsv[2];

//        Log.d("color", "Hue: " + String.valueOf(hue));
//        Log.d("color", "Sat: " + String.valueOf(sat));
//        Log.d("color", "Val: " + String.valueOf(val));

        if (sat < 0.1 && val > 0.9) {
            return "any";
        } else if (sat < 0.2 && val < 0.6)
            return "any";
        else if ((hue >= 0 && hue <= 20) || (hue > 330 && hue <= 360)) {
            return "red";
        } else if (hue > 20 && hue <= 45){
            return "orange";
        } else if (hue > 45 && hue <= 70){
            return "yellow";
        } else if (hue > 70 && hue <= 165){
            return "green";
        } else if (hue > 165 && hue <= 260){
            return "blue";
        } else if (hue > 260 && hue <= 330){
            return "purple";
        }

        return "error";
    }
}
