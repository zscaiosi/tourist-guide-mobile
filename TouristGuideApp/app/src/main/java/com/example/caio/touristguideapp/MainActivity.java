package com.example.caio.touristguideapp;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> placesList = null;
    private ArrayAdapter<String> arrAdapter = null;
    private Button btnAddPlaces = null;
    private ListView lvPlaces = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPlaces = (ListView) findViewById(R.id.lvPlaces);
        placesList = new ArrayList<String>();
        btnAddPlaces = (Button) findViewById(R.id.btnAdd);
        arrAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, placesList);
        lvPlaces.setAdapter(arrAdapter);

        btnAddPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                placesList.add("Museu Nacional");
                arrAdapter.notifyDataSetChanged();

            }
        });

    }


}
