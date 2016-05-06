package com.example.dakeh.assignment3;

import android.provider.BaseColumns;

/**
 * Created by dakeh on 5/6/2016.
 */
public class ClippingContract {

    public ClippingContract () {};

    public static abstract class ClippingEntry implements BaseColumns {
        public static final String TABLE_NAME = "clipping";
        public static final String COLUMN_NAME_CLIPPING_ID = "clippingid";
        public static final String COLUMN_NAME_NOTES = "note";
        public static final String COLUMN_NAME_DRAWABLEID = "drawableid";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_FK_COLLECTION_ID = "fkcollectionid";
    }
}
