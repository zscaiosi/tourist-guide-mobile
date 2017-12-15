package com.example.caio.touristguideapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.caio.touristguideapp.Model.Place;
import com.example.caio.touristguideapp.R;

public class PlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        Intent intent = getIntent();
        Place p = (Place) intent.getSerializableExtra("clicked_place");

        Log.i("!!@@@!!", p.getName());
    }
}
