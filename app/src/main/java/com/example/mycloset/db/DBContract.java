package com.example.mycloset.db;

import android.provider.BaseColumns;

public class DBContract {

    private DBContract() {}

    public static final class ClothingEntry implements BaseColumns {
        public static final String TABLE_NAME = "closet";
        public static final String TABLE_TOPS = "tops";
        public static final String TABLE_BOTTOMS_ = "bottoms";
        public static final String TABLE_SHOES = "shoes";
        public static final String TABLE_ACCESSORIES = "accessories";
        public static final String TABLE_CLOSET = "closet";
        public static final String COLUMN_TITLE = "clothing";
        public static final String COLUMN_IMAGE = "clothe";

    }

}
