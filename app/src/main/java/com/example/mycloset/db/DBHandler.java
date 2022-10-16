package com.example.mycloset.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mycloset.utility.ImageManager;

public class DBHandler extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String DATABASE_NAME = "closet.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE =
            "CREATE TABLE " + DBContract.ClothingEntry.TABLE_NAME + " (" +
                    DBContract.ClothingEntry._ID + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    DBContract.ClothingEntry.COLUMN_IMAGE + TEXT_TYPE + COMMA_SEP +
                    DBContract.ClothingEntry.COLUMN_TITLE + TEXT_TYPE + " )";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //This method has been intentionally left empty. There is only one version of the database.
    }

    public Cursor location() {
        SQLiteDatabase db = getReadableDatabase();

        return db.query(
                DBContract.ClothingEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public boolean addClothing(ImageManager imageManager) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBContract.ClothingEntry.COLUMN_TITLE, imageManager.getTitle());
        values.put(DBContract.ClothingEntry.COLUMN_IMAGE, imageManager.getImageString());

        return db.insert(DBContract.ClothingEntry.TABLE_NAME, null, values) != -1;
    }

}
