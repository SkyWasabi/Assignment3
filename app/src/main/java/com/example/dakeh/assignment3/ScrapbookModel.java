package com.example.dakeh.assignment3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dakeh on 5/2/2016.
 */
public class ScrapbookModel extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "ScrapBook";


    public ScrapbookModel(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onCreate(db);
    }
    public void createNewCollection() {

    }

    public Collection[] getallcollection() {

        Collection[] collect = new Collection[100];

        return collect;
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
