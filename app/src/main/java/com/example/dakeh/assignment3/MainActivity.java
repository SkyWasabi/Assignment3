package com.example.dakeh.assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScrapbookModel model = new ScrapbookModel(getApplicationContext());

        Collection collection1 = new Collection("A");
        Collection collection2 = new Collection("B");

        long collectid1 = model.createNewCollection(collection1);
        long collectid2 = model.createNewCollection(collection2);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String date = df.format(calendar.getTime());

        int drawid1 = R.drawable.baldhill;
        int drawid2 = R.drawable.cathedral;
        int drawid3 = R.drawable.lake;

        Clipping clipping1 = new Clipping("1 foo", drawid1, date, 0);
        Clipping clipping2 = new Clipping("2 foo", drawid2, date, 0);
        Clipping clipping3 = new Clipping("3 bar", drawid3, date, 0);

        long clippingid1 = model.createNewClipping(clipping1);
        long clippingid2 = model.createNewClipping(clipping2);
        long clippingid3 = model.createNewClipping(clipping3);

        Log.d("Collection count", "Collection count: " + model.getallcollection().size());
        Log.d("Clipping count", "Clipping count: " + model.getallClipping().size());

        clipping1.setFkid(collectid1);
        clipping2.setFkid(collectid1);

        long update1 = model.AddClipping(clipping1);
        long update2 = model.AddClipping(clipping2);

        Log.d("Clipping count from A", "Clipping count: " + model.getClippingBasedOnCollection(collectid1).size());
    }
}
