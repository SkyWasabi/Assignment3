package com.example.dakeh.assignment3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dakeh on 5/2/2016.
 */
public class ScrapbookModel extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "ScrapBook";

    private static final String TABLE_COLLECTION = "collection";
    private static final String TABLE_CLIPPING = "clipping";

    private static final String COLLECTION_ID = "collectionid";

    private static final String KEY_NAME = "name";

    private static final String CLIPPING_ID = "clippingid";
    private static final String KEY_NOTES = "note";
    private static final String KEY_DRAWABLEID = "drawableid";
    private static final String KEY_DATE = "date";
    private static final String FK_COLLECTION_ID = "fkcollectionid";

    private static final String CREATE_TABLE_COLLECTION = "CREATE TABLE " + TABLE_COLLECTION + "(" + COLLECTION_ID
            + "PRIMARY KEY," + KEY_NAME + "NAME" + ")";

    private static final String CREATE_TABLE_CLIPPING = "CREATE TABLE " + TABLE_CLIPPING + "(" + CLIPPING_ID
            + "PRIMARY KEY," + KEY_NOTES + "NOTES," + KEY_DRAWABLEID + "DRAWABLE ID," + KEY_DATE + "DATE," + FK_COLLECTION_ID
            + "REFERENCES " + TABLE_COLLECTION + "(" + COLLECTION_ID + ")" + ")";


    public ScrapbookModel(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_COLLECTION);
        db.execSQL(CREATE_TABLE_CLIPPING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COLLECTION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIPPING);

        onCreate(db);
    }
    public void createNewCollection(String n) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, n);

        long collection_id = db.insert(TABLE_COLLECTION, null, values);
    }

    public List<Collection> getallcollection() {
        List<Collection> collections = new ArrayList<Collection>();
        String selectQuery = "SELECT * FROM " + TABLE_COLLECTION;

        Log.d("Check:", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Collection collect = new Collection();
                collect.setID(c.getInt((c.getColumnIndex(COLLECTION_ID))));
                collect.setName(c.getString(c.getColumnIndex(KEY_NAME)));

                collections.add(collect);
            }while (c.moveToNext());
        }

        return collections;
    }

    public void createNewClipping() {

    }

    public void GetClippingFromCollection() {

    }

    public void AddClipping() {

    }

    public void DeleteCollection() {

    }

    public void DeleteClipping() {

    }

    public Clipping[] searchfunc() {
        Clipping [] clippings = new Clipping[100];

        return clippings;
    }


}
