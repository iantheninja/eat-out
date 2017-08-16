package com.moringaschool.eatout;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //public static final String TAG = MainActivity.class.getSimpleName();
    Button mFindRestaurantButton;
    private EditText mFindZipEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvEatOut;

        tvEatOut = (TextView) findViewById(R.id.tv_eat_out);
        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrichregular.ttf");
        tvEatOut.setTypeface(ostrichFont);

        mFindZipEditText = (EditText) findViewById(R.id.et_zip_code);
        mFindRestaurantButton = (Button) findViewById(R.id.btn_find_restaurant);

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
