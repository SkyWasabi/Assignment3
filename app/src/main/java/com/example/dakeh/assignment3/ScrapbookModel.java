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

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private static final String CREATE_TABLE_COLLECTION = "CREATE TABLE " + CollectionContract.CollectionEntry.TABLE_NAME + " (" +
            CollectionContract.CollectionEntry.COLUMN_NAME_COLLECTION_ID + " INTEGER PRIMARY KEY," +
            CollectionContract.CollectionEntry.COLUMN_NAME_NAME + TEXT_TYPE + ")";

    private static final String CREATE_TABLE_CLIPPING = "CREATE TABLE " + ClippingContract.ClippingEntry.TABLE_NAME + " (" +
            ClippingContract.ClippingEntry.COLUMN_NAME_CLIPPING_ID + " INTEGER PRIMARY KEY," +
            ClippingContract.ClippingEntry.COLUMN_NAME_NOTES + TEXT_TYPE + COMMA_SEP +
            ClippingContract.ClippingEntry.COLUMN_NAME_DRAWABLEID + " INTEGER" + COMMA_SEP +
            ClippingContract.ClippingEntry.COLUMN_NAME_DATE + TEXT_TYPE + COMMA_SEP +
            ClippingContract.ClippingEntry.COLUMN_NAME_FK_COLLECTION_ID + " INTEGER" + COMMA_SEP +
            "FOREIGN KEY" + "(" + ClippingContract.ClippingEntry.COLUMN_NAME_FK_COLLECTION_ID + ") " + "REFERENCES " +
            CollectionContract.CollectionEntry.TABLE_NAME + "(" + CollectionContract.CollectionEntry.COLUMN_NAME_COLLECTION_ID + "))";

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
        db.execSQL("DROP TABLE IF EXISTS " + CollectionContract.CollectionEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ClippingContract.ClippingEntry.TABLE_NAME);

        onCreate(db);
    }
    public long createNewCollection(Collection collection) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CollectionContract.CollectionEntry.COLUMN_NAME_NAME, collection.getName());

        long collection_id = db.insert(CollectionContract.CollectionEntry.TABLE_NAME, null, values);

        return collection_id;
    }

    public List<Collection> getallcollection() {
        List<Collection> collections = new ArrayList<Collection>();
        String selectQuery = "SELECT * FROM " + CollectionContract.CollectionEntry.TABLE_NAME;

        Log.d("Check:", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Collection collect = new Collection();
                collect.setID(c.getInt((c.getColumnIndex(CollectionContract.CollectionEntry.COLUMN_NAME_COLLECTION_ID))));
                collect.setName(c.getString(c.getColumnIndex(CollectionContract.CollectionEntry.COLUMN_NAME_NAME)));

                //Log.d("getallcollection: ", collect.getName());

                collections.add(collect);
            }while (c.moveToNext());
        }

        return collections;
    }

    public long createNewClipping(Clipping clipping) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ClippingContract.ClippingEntry.COLUMN_NAME_NOTES, clipping.getNotes());
        values.put(ClippingContract.ClippingEntry.COLUMN_NAME_DRAWABLEID, clipping.getDrawableid());
        values.put(ClippingContract.ClippingEntry.COLUMN_NAME_DATE, clipping.getDate());
        values.put(ClippingContract.ClippingEntry.COLUMN_NAME_FK_COLLECTION_ID, clipping.getFkid());

        long clipping_id = db.insert(ClippingContract.ClippingEntry.TABLE_NAME, null, values);

        return clipping_id;

    }

    public List<Clipping> getallClipping() {
        List<Clipping> clippings = new ArrayList<Clipping>();
        String selectQuery = "SELECT * FROM " + ClippingContract.ClippingEntry.TABLE_NAME;

        Log.d("Check:", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Clipping clipping = new Clipping();
                clipping.setID(c.getInt(c.getColumnIndex(ClippingContract.ClippingEntry.COLUMN_NAME_CLIPPING_ID)));
                clipping.setNotes(c.getString(c.getColumnIndex(ClippingContract.ClippingEntry.COLUMN_NAME_NOTES)));
                clipping.setDrawableid(c.getInt(c.getColumnIndex(ClippingContract.ClippingEntry.COLUMN_NAME_DRAWABLEID)));
                clipping.setDate(c.getString(c.getColumnIndex(ClippingContract.ClippingEntry.COLUMN_NAME_DATE)));
                clipping.setFkid(c.getInt(c.getColumnIndex(ClippingContract.ClippingEntry.COLUMN_NAME_FK_COLLECTION_ID)));

                clippings.add(clipping);
            }while (c.moveToNext());
        }

        return clippings;
    }

    public long AddClipping(Clipping clipping) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ClippingContract.ClippingEntry.COLUMN_NAME_FK_COLLECTION_ID, clipping.getFkid());
        Log.d("Check", String.valueOf(clipping.getFkid()));
        return db.update(ClippingContract.ClippingEntry.TABLE_NAME, values, ClippingContract.ClippingEntry.COLUMN_NAME_CLIPPING_ID +
                " = ?", new String[]{String.valueOf(clipping.getId())});
    }

    public List<Clipping> getClippingBasedOnCollection(long collectionid) {
        List<Clipping> clippings = new ArrayList<Clipping>();

        String selectQuery = "SELECT * FROM " + ClippingContract.ClippingEntry.TABLE_NAME + " clp " +
                "WHERE clp." + ClippingContract.ClippingEntry.COLUMN_NAME_FK_COLLECTION_ID + " = " + collectionid;

        Log.d("Check", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Clipping clipping = new Clipping();
                clipping.setID(c.getInt(c.getColumnIndex(ClippingContract.ClippingEntry.COLUMN_NAME_CLIPPING_ID)));
                clipping.setNotes(c.getString(c.getColumnIndex(ClippingContract.ClippingEntry.COLUMN_NAME_NOTES)));
                clipping.setDrawableid(c.getInt(c.getColumnIndex(ClippingContract.ClippingEntry.COLUMN_NAME_DRAWABLEID)));
                clipping.setDate(c.getString(c.getColumnIndex(ClippingContract.ClippingEntry.COLUMN_NAME_DATE)));
                clipping.setFkid(c.getInt(c.getColumnIndex(ClippingContract.ClippingEntry.COLUMN_NAME_FK_COLLECTION_ID)));

                clippings.add(clipping);
            }while (c.moveToNext());
        }

        return clippings;
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
