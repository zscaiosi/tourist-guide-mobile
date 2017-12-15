package com.example.caio.touristguideapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
    private ArrayList<Place> placesList = null;
    private Place p = null;
    private ArrayList<String> placesNames = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list);

        Intent intent = getIntent();

        int counter = 0;
        placesList = new ArrayList<Place>();


        while( intent.getSerializableExtra("seriazable_place"+counter) != null ){

            Place p = (Place) intent.getSerializableExtra("seriazable_place"+counter);
            placesList.add(p);
            placesNames.add(placesList.get(counter).getName());
            counter += 1;

        }

        arrAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, placesNames);
        lvPlaces = (ListView) findViewById(R.id.lvPlaces);
        lvPlaces.setAdapter(arrAdapter);

        lvPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent in = new Intent(PlacesListActivity.this, PlaceActivity.class);
                // Pega o objeto clicado, através da instância de PlacesListActivity
                in.putExtra("clicked_place", PlacesListActivity.this.placesList.get(i));
                //Inicia outra Activity
                startActivity(in);
            }
        });


    }

}
