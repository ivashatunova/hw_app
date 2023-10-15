package com.netology.tabbedapplication;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        String tab1Text = "TAB 1";
        String tab2Text = "TAB 2";

        String text1 ="Page: 1";
        String text2 ="Page: 2";

        ViewInteraction tab1View = onView(withText(tab1Text));
        tab1View.check(matches(isDisplayed()));
        tab1View.check(matches(withText(tab1Text)));


        ViewInteraction textView1 = onView(withText(text1));
        textView1.check(matches(isDisplayed()));
        textView1.check(matches(withText(text1)));

        ViewInteraction tab2View = onView(withText(tab2Text));
        tab2View.perform(click());
        tab2View.check(matches(isDisplayed()));
        tab2View.check(matches(withText(tab2Text)));

        ViewInteraction textView2 = onView(withText(text2));
        textView2.check(matches(isDisplayed()));
        textView2.check(matches(withText(text2)));
    }
}
