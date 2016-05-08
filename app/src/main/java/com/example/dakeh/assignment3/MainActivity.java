package com.example.dakeh.assignment3;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.CalendarView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {

    Fragment contentFragment;
    CollectionListFragment collectionListFragment;
    FragmentManager fm = getSupportFragmentManager();
    ScrapbookModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new ScrapbookModel(getApplicationContext());

        Collection collection1 = new Collection("A");
        Collection collection2 = new Collection("B");

        long collectid1 = model.createNewCollection(collection1);
        long collectid2 = model.createNewCollection(collection2);

        Log.d("Collection count", "Collection count: " + model.getallcollection().size());

        List<Collection> collections = model.getallcollection();
        for (Collection collection : collections) {
            Log.d("Collection name", collection.getName());
        }

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String date = df.format(calendar.getTime());

        int drawid1 = R.drawable.baldhill;
        int drawid2 = R.drawable.cathedral;
        int drawid3 = R.drawable.lake;

        Clipping clipping1 = new Clipping("1 foo", drawid1, date);
        Clipping clipping2 = new Clipping("2 foo", drawid2, date);
        Clipping clipping3 = new Clipping("3 bar", drawid3, date);

        long clippingid1 = model.createNewClipping(clipping1);
        long clippingid2 = model.createNewClipping(clipping2);
        long clippingid3 = model.createNewClipping(clipping3);


        Log.d("Clipping count", "Clipping count: " + model.getallClipping().size());

        List<Clipping> clippings = model.getallClipping();
        for (Clipping clipping : clippings) {
            Log.d("Clipping note", clipping.getNotes());
            Log.d("Drawable ID", String.valueOf(clipping.getDrawableid()));
            Log.d("Date", clipping.getDate());
        }

        model.AddClipping(model.getallClipping().get(0), collectid1);
        model.AddClipping(model.getallClipping().get(1), collectid1);


        Log.d("Clipping count from A", "Clipping count: " + model.getClippingBasedOnCollection(collectid1).size());
        List<Clipping> clippings1 = model.getClippingBasedOnCollection(collectid1);
        for (Clipping clipping : clippings1) {
            Log.d("Clipping note", clipping.getNotes());
            Log.d("Drawable ID", String.valueOf(clipping.getDrawableid()));
            Log.d("Date", clipping.getDate());
        }

        model.DeleteClipping(clippingid1);

        List<Clipping> clippings2 = model.getClippingBasedOnCollection(collectid1);
        for (Clipping clipping : clippings1) {
            Log.d("Clipping note", clipping.getNotes());
            Log.d("Drawable ID", String.valueOf(clipping.getDrawableid()));
            Log.d("Date", clipping.getDate());
        }

        List<Clipping> search = model.searchfunc("bar");
        List<Clipping> searchcol = model.searchfromcollection("foo", collectid1);

        Log.d("Search count", String.valueOf(search.size()));

        for (Clipping clipping : search) {
            Log.d("Clipping note", clipping.getNotes());
            Log.d("Drawable ID", String.valueOf(clipping.getDrawableid()));
            Log.d("Date", clipping.getDate());
        }

        model.DeleteCollection(collectid1, true);
        model.DeleteCollection(collectid2, false);

        model.DeleteClipping(clippingid3);

        FragmentManager fm = getSupportFragmentManager();

        collectionListFragment = new CollectionListFragment();

        showDialog();

        model.closeDB();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_list, menu);
        return true;
    }

    public List<Collection> getcollection() {
        return model.getallcollection();
    }

    public void showDialog() {
        AlertDialogFragment collist = new AlertDialogFragment();
        collist.show(fm, "Alert Dialog Fragment");
    }

    protected void setFragmentTitle(int resourseId) {
        setTitle(resourseId);
        getActionBar().setTitle(resourseId);

    }

}
