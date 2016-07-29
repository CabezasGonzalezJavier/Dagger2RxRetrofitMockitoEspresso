package com.thedeveloperworldisyours.rxretrofit;

import android.os.SystemClock;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import com.thedeveloperworldisyours.rxretrofit.model.GeoNames;
import com.thedeveloperworldisyours.rxretrofit.rest.ApiClient;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javax.inject.Inject;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.thedeveloperworldisyours.rxretrofit.RecyclerViewActionAndMatcher.atPosition;

/**
 * Created by javierg on 28/07/16.
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Inject
    ApiClient apiClient;

    @Before
    public void setUp() {
        ((TestApp) activityTestRule.getActivity().getApplication()).appComponent().inject(this);
    }

    @Test
    public void correctDataDisplayed() {
        GeoNames data = apiClient.getAllCountriesGeoNames("en", "antriksh").toBlocking().first();

        onView(withId(R.id.coordinatorLayout)).perform(click());
        onView(withId(R.id.activity_main_floating_action)).perform(click());
        SystemClock.sleep(5000);
        onView(withId(R.id.activity_main_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, RecyclerViewActionAndMatcher.clickChildViewWithId(R.id.list_item_country)));
        SystemClock.sleep(1500);
        onView(withId(R.id.activity_main_recycler_view))
                .perform(scrollToPosition(1))
                .check(matches(atPosition(1, hasDescendant(withText("Spain")))));
        SystemClock.sleep(1500);

    }




}
