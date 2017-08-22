package com.moringaschool.eatout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RestaurantsActivity extends AppCompatActivity {
    String[] restaurants = new String[]{"Midland", "Ole Sereni",
            "Hilton", "Highlands", "White Rhino", "White waters",
            "Anghiti", "Spur Steak Ranches", "Java", "Subway",
            "Senate", "Blue Post Hotel", "Blue Springs Hotel", "Sportman Arms"};
    String[] cuisines = new String[]{"Vegan Food", "Breakfast", "Asian Food",
            "Coffee", "Tea", "Mexican Food", "West African", "Noodle Soups",
            "English Food", "Burgers", "East African", "Fast Food", "Salads", "Drinks" };
    @Bind(R.id.tv_location) TextView mTvLocation;
    @Bind(R.id.lv_restaurants) ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String zip = intent.getStringExtra("location");

        String loc = getString(R.string.location_text, zip);
        mTvLocation.setText(loc);

        MyRestaurantsArrayAdapter adapter = new MyRestaurantsArrayAdapter(this,
                android.R.layout.simple_list_item_1, restaurants, cuisines);
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
