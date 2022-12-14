package com.example.mycloset.db;

import android.provider.BaseColumns;

public class DBContract {

    private DBContract() {}

    public static final class ClothingEntry implements BaseColumns {
        public static final String TABLE_TOPS = "tops";
        public static final String TABLE_BOTTOMS = "bottoms";
        public static final String TABLE_SHOES = "shoes";
        public static final String TABLE_ACCESSORIES = "accessories";
        public static final String TABLE_CLOSET = "closet";
        public static final String TABLE_USERS = "users";
        public static final String COLUMN_TITLE = "description";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_COLOR = "color";
        public static final String COLUMN_ACCESSORIES = "accessories";
        public static final String COLUMN_TOPS = "tops";
        public static final String COLUMN_BOTTOMS = "bottoms";
        public static final String COLUMN_SHOES = "shoes";


    }

}
