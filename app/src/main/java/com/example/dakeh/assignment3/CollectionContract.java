package com.example.dakeh.assignment3;

import android.provider.BaseColumns;

/**
 * Created by dakeh on 5/6/2016.
 */
public class CollectionContract {

    public CollectionContract() {};

    public static abstract class CollectionEntry implements BaseColumns {
        public static final String TABLE_NAME = "collection";
        public static final String COLUMN_NAME_COLLECTION_ID = "collectionid";
        public static final String COLUMN_NAME_NAME = "name";
    }
}
