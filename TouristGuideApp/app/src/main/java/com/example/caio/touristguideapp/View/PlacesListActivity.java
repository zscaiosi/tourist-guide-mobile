package com.example.caio.touristguideapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.caio.touristguideapp.Model.Place;
import com.example.caio.touristguideapp.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PlacesListActivity extends AppCompatActivity {

    private ListView lvPlaces = null;
    private ArrayAdapter<String> arrAdapter = null;
    private ArrayList<String> placesList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        int counter = 0;
        Log.i( "BUNDLE", String.valueOf(bundle.getString(String.valueOf(counter))) );
        placesList = new ArrayList<String>();

        while( bundle.getString(String.valueOf(counter)) != null ){

            Log.i("DOING.....", String.valueOf(bundle.getString(String.valueOf(counter))));
            placesList.add( String.valueOf(bundle.getString(String.valueOf(counter))) );
            counter += 1;
            Log.i("Counter", String.valueOf(counter));

        }

        arrAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, placesList);
        lvPlaces = (ListView) findViewById(R.id.lvPlaces);
        lvPlaces.setAdapter(arrAdapter);

    }

}
