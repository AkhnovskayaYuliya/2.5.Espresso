package ru.kkuzmichev.simpleappforespresso;

import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.idling.CountingIdlingResource;

public class EspressoIdlingResources {
    private static final String RESOURCES = "GLOBAL";
    public static CountingIdlingResource idlingResources = new CountingIdlingResource(RESOURCES);
    public static void increment() {
        idlingResources.increment();
    }

    public static void decrement() {
        if(!idlingResources.isIdleNow())
            idlingResources.decrement();
    }

    public IdlingResource getIdlingResource() {
        return idlingResources;
    }
}
