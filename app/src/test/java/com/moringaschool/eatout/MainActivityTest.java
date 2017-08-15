package com.moringaschool.eatout;

import android.content.Intent;
import android.os.Build;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@Config(constants = BuildConfig.class,sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class MainActivityTest {
    @SuppressWarnings("FieldCanBeLocal")
    private MainActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTextViewContent() {
        TextView tvEatOut = (TextView) activity.findViewById(R.id.tv_eat_out);
        assertNotNull("TextView could not be found", tvEatOut);
        assertTrue("Eat Out Kenya".equals(tvEatOut.getText().toString()));
    }

    @Test
    public void restaurantActivityStarted() {
        activity.findViewById(R.id.btn_find_restaurant).performClick();

        //the intent we expect to be launched when a user performs the click
        Intent launchRestaurantActivity = new Intent(activity, RestaurantsActivity.class);

        //Robolectic's shadow activity keeps track of all launched activities and exposes this information
        // through the 'getNextStartedActivity' method
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();

        // Determine if two intents are the same for the purposes of intent resolution (filtering).
        // That is, if their action, data, type, class, and categories are the same. This does
        // not compare any extra data included in the intents
        assertTrue(actualIntent.filterEquals(launchRestaurantActivity));
    }
}
