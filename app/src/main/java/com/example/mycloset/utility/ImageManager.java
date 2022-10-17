package com.example.mycloset.utility;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class ImageManager {

    private String title;
    private String image;

    public static final int COL_ID = 0;
    public static final int COL_TITLE = 1;
    public static final int COL_IMAGE = 2;

    public static final float NEW_WIDTH = 200;
    public static final float NEW_HEIGHT = 200;

    public ImageManager(Cursor cursor) {
        this.title = cursor.getString(COL_TITLE);
        this.image = cursor.getString(COL_IMAGE);
    }

    public ImageManager(String title, Bitmap image) {
        this.title = title;
        this.image = bitmapToString(resizeImage(image));
    }

    public Bitmap getImage() {
        return stringToBitmap(this.image);
    }

    public String getTitle() {
        return this.title;
    }

    public String getImageString() {
        return this.image;
    }

    private String bitmapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte [] b = baos.toByteArray();
        return Base64.encodeToString(b, Base64.DEFAULT);
    }

    private Bitmap stringToBitmap(String string) {
        Bitmap bitmap = null;

        try {
            byte[] eByte = Base64.decode(string, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(eByte, 0 , eByte.length);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return bitmap;
    }

    public Bitmap resizeImage(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float sWidth = NEW_WIDTH / width;
        float sHeight = NEW_HEIGHT / height;

        Matrix matrix = new Matrix();
        matrix.postScale(sWidth, sHeight);

        Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        //newBitmap.recycle();

        return newBitmap;
    }
}
