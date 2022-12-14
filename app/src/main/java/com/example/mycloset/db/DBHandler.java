package com.example.mycloset.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.core.database.DatabaseUtilsCompat;

import com.example.mycloset.User;
import com.example.mycloset.utility.ImageManager;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String DATABASE_NAME = "closet.db";
    private static final int DATABASE_VERSION = 1;
    //private static final String NAME_COL = "user";

    private SQLiteDatabase database = getReadableDatabase();

    public String createTable(String table) {
        final String CREATE_TABLE =
                "CREATE TABLE " + table + " (" +
                        DBContract.ClothingEntry._ID + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                        DBContract.ClothingEntry.COLUMN_IMAGE + TEXT_TYPE + COMMA_SEP +
                        DBContract.ClothingEntry.COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
                        DBContract.ClothingEntry.COLUMN_COLOR + TEXT_TYPE + " )";
        return CREATE_TABLE;
    }

    final String CREATE_CLOSET = "CREATE TABLE closet (_id INTEGER PRIMARY KEY, accessories TEXT, tops TEXT, bottoms TEXT, shoes TEXT)";

    final String CREATE_USERS = "CREATE TABLE users (_id INTEGER PRIMARY KEY, user TEXT)";

    final String CREATE_OUTFITS = "CREATE TABLE outfits (accessories TEXT, tops TEXT, bottoms TEXT, shoes TEXT)";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable(DBContract.ClothingEntry.TABLE_TOPS));
        db.execSQL(createTable(DBContract.ClothingEntry.TABLE_BOTTOMS));
        db.execSQL(createTable(DBContract.ClothingEntry.TABLE_SHOES));
        db.execSQL(createTable(DBContract.ClothingEntry.TABLE_ACCESSORIES));
        db.execSQL(CREATE_CLOSET);
        db.execSQL(CREATE_USERS);
        db.execSQL(CREATE_OUTFITS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

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

    public Cursor location_accessories() {
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

    public Cursor location_tops() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(
                DBContract.ClothingEntry.TABLE_TOPS,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public Cursor location_bottoms() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(
                DBContract.ClothingEntry.TABLE_BOTTOMS,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public Cursor location_shoes() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(
                DBContract.ClothingEntry.TABLE_SHOES,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public Cursor location_closet() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(
                DBContract.ClothingEntry.TABLE_CLOSET,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public Cursor location_users() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(
                DBContract.ClothingEntry.TABLE_USERS,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public boolean addClothing(ImageManager imageManager, int dbName, String color, String userName) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBContract.ClothingEntry.COLUMN_TITLE, userName);
        values.put(DBContract.ClothingEntry.COLUMN_IMAGE, imageManager.getImageString());
        values.put(DBContract.ClothingEntry.COLUMN_COLOR, color);

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

        return db.insert(TABLE_NAME, null, values) != -1;
    }

    public boolean addOutfit (String image, String image2, String image3, String image4){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBContract.ClothingEntry.COLUMN_ACCESSORIES, image);
        values.put(DBContract.ClothingEntry.COLUMN_TOPS, image2);
        values.put(DBContract.ClothingEntry.COLUMN_BOTTOMS, image3);
        values.put(DBContract.ClothingEntry.COLUMN_SHOES, image4);

        return db.insert(DBContract.ClothingEntry.TABLE_CLOSET, null, values) != -1;
    }

    public void deleteClothing(String deleteImage)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("TABLE_TOPS", "COLUMN_IMAGE=?", new String[]{deleteImage});
        db.close();
    }



    public long getNumEntries(String table) {
        SQLiteDatabase db = getReadableDatabase();
        long size = DatabaseUtils.queryNumEntries(db, table);
        return size;
    }

    public Cursor fetch(String table) {
        Cursor cursor = this.database.query(table, new String[]{"_id", "image", "description", "color"}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public boolean insertUser(String userName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user", userName);

        return db.insert("users", null, values) != -1;
    }

    public List<String> getAllUsers(){
        List<String>list = new ArrayList<String>();

        String selectQuery = "SELECT * FROM users";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                list.add(cursor.getString(1));
            }while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return  list;
    }

    public void deleteName(String userName)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("users", "user=?", new String[]{userName});
        db.delete("tops", "description=?", new String[]{userName});
        db.delete("bottoms", "description=?", new String[]{userName});
        db.delete("accessories", "description=?", new String[]{userName});
        db.delete("shoes", "description=?", new String[]{userName});
        //db.delete("outfits", "description=?", new String[]{userName});
        db.close();
    }


}
