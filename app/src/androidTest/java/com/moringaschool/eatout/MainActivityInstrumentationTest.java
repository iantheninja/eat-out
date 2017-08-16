package com.moringaschool.eatout;


import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateText() {
        onView(withId(R.id.et_zip_code)).perform(typeText("Nairobi"))
                .check(matches(withText("Nairobi")));
    }

    @Test
    public void locationSentToRestaurantActivity() {
        String location = "Nairobi";
        onView(withId(R.id.et_zip_code)).perform(typeText(location));
        onView(withId(R.id.btn_find_restaurant)).perform(click());
        onView(withId(R.id.tv_location)).check(matches(withText("Here are all restaurants near: " + location)));
    }

}
