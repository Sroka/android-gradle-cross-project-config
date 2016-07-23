package com.example.srokowski.maciej.androidcrossprojectconfig;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.srokowski.maciej.library1.Library1Singleton;
import com.example.srokowski.maciej.library2.Library2Singleton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.text);
        Library1Singleton library1Singleton = Library1Singleton.getInstance();
        Library2Singleton library2Singleton = Library2Singleton.getInstance();
        String string = "Application configurable field value: %s\n\n" +
                "Library1 configurable field: %s\n\n" +
                "Library1 transient configurable field: %s\n\n" +
                "Library2 configurable field: %s";
        String text = String.format(string,
                BuildConfig.APP_CONFIGURABLE_FIELD,
                library1Singleton.getConfigurableField(),
                library1Singleton.getTransientConfigurableField(),
                library2Singleton.getConfigurableField());
        textView.setText(text);
    }
}
