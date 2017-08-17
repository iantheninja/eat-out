package com.moringaschool.eatout;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.btn_find_restaurant) Button mFindRestaurantButton;
    @Bind(R.id.et_zip_code) EditText mFindZipEditText;
    @Bind(R.id.tv_eat_out) TextView tvEatOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrichregular.ttf");
        tvEatOut.setTypeface(ostrichFont);

        mFindRestaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zip = mFindZipEditText.getText().toString();
                Intent intent = new Intent(getBaseContext(), RestaurantsActivity.class);
                intent.putExtra("location", zip);
                startActivity(intent);
            }
        });

    }
}
