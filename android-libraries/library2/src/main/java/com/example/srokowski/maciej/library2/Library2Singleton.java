package com.example.srokowski.maciej.library2;

/**
 * Created by maciek on 23.07.16.
 */
public class Library2Singleton {
    private static class INSTANCE {
        private static Library2Singleton mockRepCallback = new Library2Singleton();
    }

    private Library2Singleton() {
    }

    public static Library2Singleton getInstance() {
        return INSTANCE.mockRepCallback;
    }

    public String getConfigurableField() {
        return BuildConfig.LIBRARY_2_CONFIGURABLE_FIELD;
    }
}
