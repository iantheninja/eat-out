package com.moringaschool.eatout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class RestaurantsActivity extends AppCompatActivity {
    TextView mTvLocation;
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        mTvLocation = (TextView) findViewById(R.id.tv_location);

        Intent intent = getIntent();
        String zip = intent.getStringExtra("location");

        String loc = getString(R.string.location_text, zip);
        mTvLocation.setText(loc);

        mListView = (ListView) findViewById(R.id.lv_restaurants);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        mListView.setAdapter(adapter);

    }
}
