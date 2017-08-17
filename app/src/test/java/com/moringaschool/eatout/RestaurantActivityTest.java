package com.moringaschool.eatout;

import android.widget.ListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@Config(constants = BuildConfig.class, sdk = android.os.Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class RestaurantActivityTest {
    @SuppressWarnings("FieldCanBeLocal")
    private RestaurantsActivity activity;
    private ListView mListView;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(RestaurantsActivity.class);
        mListView = (ListView) activity.findViewById(R.id.lv_restaurants);
    }

    @Test
    public void restaurantListViewPopulates() {
        assertNotNull(mListView.getAdapter());
        assertEquals(mListView.getAdapter().getCount(), 14);
    }
}
