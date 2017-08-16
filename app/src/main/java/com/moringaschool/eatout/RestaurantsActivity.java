package com.moringaschool.eatout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RestaurantsActivity extends AppCompatActivity {
    String[] restaurants = new String[]{"Midland", "Ole Sereni",
            "Hilton", "Highlands", "White Rhino", "White waters",
            "Anghiti", "Spur Steak Ranches", "Java", "Subway",
            "Senate", "Blue Post Hotel", "Blue Springs Hotel", "Sportman Arms"};
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
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, restaurants);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
