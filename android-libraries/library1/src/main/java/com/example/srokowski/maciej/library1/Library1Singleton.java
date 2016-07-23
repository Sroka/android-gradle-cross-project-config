package com.example.srokowski.maciej.library1;

import com.example.srokowski.maciej.library2.Library2Singleton;

/**
 * Created by maciek on 23.07.16.
 */
public class Library1Singleton {

    private static class INSTANCE {
        private static Library1Singleton mockRepCallback = new Library1Singleton();
    }

    private Library1Singleton() {
    }

    public static Library1Singleton getInstance() {
        return INSTANCE.mockRepCallback;
    }

    public String getConfigurableField() {
        return BuildConfig.LIBRARY_1_CONFIGURABLE_FIELD;
    }

    public String getTransientConfigurableField() {
        return Library2Singleton.getInstance().getConfigurableField();
    }
}
