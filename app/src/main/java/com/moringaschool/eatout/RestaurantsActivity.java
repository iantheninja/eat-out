package com.moringaschool.eatout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class RestaurantsActivity extends AppCompatActivity {
    TextView mTvLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        mTvLocation = (TextView) findViewById(R.id.tv_location);

        Intent intent = getIntent();
        String zip = intent.getStringExtra("location");

        String loc = getString(R.string.location_text, zip);
        mTvLocation.setText(loc);
        // place holder set up from the strings resource file.
        // zip will be concatenated to location text
    }
}
