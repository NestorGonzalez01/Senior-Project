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

//    private static final String CREATE_TABLE =
//            "CREATE TABLE " + DBContract.ClothingEntry.TABLE_NAME + " (" +
//                    DBContract.ClothingEntry._ID + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
//                    DBContract.ClothingEntry.COLUMN_IMAGE + TEXT_TYPE + COMMA_SEP +
//                    DBContract.ClothingEntry.COLUMN_TITLE + TEXT_TYPE + " )";

    public String createTable(String table) {
        final String CREATE_TABLE =
                "CREATE TABLE " + table + " (" +
                        DBContract.ClothingEntry._ID + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                        DBContract.ClothingEntry.COLUMN_IMAGE + TEXT_TYPE + COMMA_SEP +
                        DBContract.ClothingEntry.COLUMN_TITLE + TEXT_TYPE + " )";
        return CREATE_TABLE;
    }

    public DBHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Test", "Testing");
    }

//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_TABLE);
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable(DBContract.ClothingEntry.TABLE_TOPS));
        db.execSQL(createTable(DBContract.ClothingEntry.TABLE_BOTTOMS));
        db.execSQL(createTable(DBContract.ClothingEntry.TABLE_SHOES));
        db.execSQL(createTable(DBContract.ClothingEntry.TABLE_ACCESSORIES));
        db.execSQL(createTable(DBContract.ClothingEntry.TABLE_CLOSET));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //This method has been intentionally left empty. There is only one version of the database.
    }

    public Cursor location() {
        SQLiteDatabase db = getReadableDatabase();

        return db.query(
                DBContract.ClothingEntry.TABLE_ACCESSORIES,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

//    public boolean addClothing(ImageManager imageManager) {
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(DBContract.ClothingEntry.COLUMN_TITLE, imageManager.getTitle());
//        values.put(DBContract.ClothingEntry.COLUMN_IMAGE, imageManager.getImageString());
//
//        return db.insert(DBContract.ClothingEntry.TABLE_NAME, null, values) != -1;
//    }

    public boolean addClothing(ImageManager imageManager, int dbName) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBContract.ClothingEntry.COLUMN_TITLE, imageManager.getTitle());
        values.put(DBContract.ClothingEntry.COLUMN_IMAGE, imageManager.getImageString());

        String TABLE_NAME = null;

        switch (dbName) {
            case 0: TABLE_NAME = DBContract.ClothingEntry.TABLE_TOPS;
            break;
            case 1: TABLE_NAME = DBContract.ClothingEntry.TABLE_BOTTOMS;
            break;
            case 2: TABLE_NAME = DBContract.ClothingEntry.TABLE_SHOES;
            break;
            case 3: TABLE_NAME = DBContract.ClothingEntry.TABLE_ACCESSORIES;
            break;
            case 4: TABLE_NAME = DBContract.ClothingEntry.TABLE_CLOSET;
            break;
        }

        Log.d("Test", TABLE_NAME);

        return db.insert(TABLE_NAME, null, values) != -1;
    }

}
