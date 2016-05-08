package com.example.dakeh.assignment3;

import android.app.Fragment;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by dakeh on 5/7/2016.
 */
public class CollectionListFragment extends Fragment {

    ListView collectionListView;
    ArrayList<String> mycollection;
    ArrayAdapter<String> listviewadapter;
    ScrapbookModel model;
    SQLiteDatabase database;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collectionlistfrag, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        model = new ScrapbookModel(getActivity().getApplicationContext());
//
//        mycollection = getlistitem(model);
//
//        listviewadapter = new ArrayAdapter<>(
//                getActivity().getApplicationContext(),
//                android.R.layout.simple_list_item_1,
//                mycollection);
//
//        collectionListView.setAdapter(listviewadapter);

    }

    public ArrayList<String> getlistitem(ScrapbookModel model) {
        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < model.getallcollection().size(); i++) {
            result.add(model.getallcollection().get(i).getName());
        }

        return result;
    }

}
