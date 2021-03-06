package com.moringaschool.eatout;


import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.IsNot.not;

public class RestaurantActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<RestaurantsActivity> activityTestRule =
        new ActivityTestRule<>(RestaurantsActivity.class);

    @Test
    public void listItemClickDisplaysRestaurantNameToast() {
        View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
        String restaurantName = "Midland";
        onData(anything()).inAdapterView(withId(R.id.lv_restaurants))
                .atPosition(0)
                .perform(click());
        onView(withText(restaurantName)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(restaurantName)));
    }
}
