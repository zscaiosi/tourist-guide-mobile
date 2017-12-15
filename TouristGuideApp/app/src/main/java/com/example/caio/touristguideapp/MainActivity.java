package com.example.caio.touristguideapp;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.caio.touristguideapp.Model.Place;
import com.example.caio.touristguideapp.View.PlacesListActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Place> placesList = null;
    private Button btnAddPlaces = null, btnShow =null;
    private EditText etPlace = null, etAddress = null;
    private Place place = null;
    private ArrayAdapter<CharSequence> countriesAdapter = null;
    private Spinner spCountries = null;
    private String selectedCountry = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPlace = (EditText) findViewById(R.id.etPlace);
        etAddress = (EditText) findViewById(R.id.etAddress);
        countriesAdapter = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
        spCountries = (Spinner) findViewById(R.id.spCountries);
        placesList = new ArrayList<Place>();
        btnAddPlaces = (Button) findViewById(R.id.btnAdd);
        btnShow = (Button) findViewById(R.id.btnShow);

        countriesAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spCountries.setAdapter(countriesAdapter);

        spCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedCountry =  adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnAddPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                place = new Place(etPlace.getText().toString(), etAddress.getText().toString(), selectedCountry);
                placesList.add(place);
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PlacesListActivity.class);

                for(int f = 0; f < placesList.size(); f++){
                    i.putExtra("seriazable_place"+f, placesList.get(f));
                }

                startActivity(i);
            }
        });

    }


}
