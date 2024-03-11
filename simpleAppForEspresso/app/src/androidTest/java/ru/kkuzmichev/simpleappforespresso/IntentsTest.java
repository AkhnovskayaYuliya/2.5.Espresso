package ru.kkuzmichev.simpleappforespresso;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


import android.content.Intent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class IntentsTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest2() {
        Intents.init();

        ViewInteraction overflowMenuButton = onView(withContentDescription("More options"));

        overflowMenuButton.check(matches(isDisplayed()));
        overflowMenuButton.perform(click());

        ViewInteraction linearLayout = onView(withId(androidx.constraintlayout.widget.R.id.content));
        linearLayout.check(matches(isDisplayed()));

        ViewInteraction materialTextView = onView(withId(androidx.recyclerview.R.id.title));
        materialTextView.check(matches(isDisplayed()));
        materialTextView.perform(click());

        Intents.intended(Matchers.allOf(IntentMatchers.hasAction(Intent.ACTION_VIEW),
        IntentMatchers.hasData("https://google.com")));
        Intents.release();
    }

}
