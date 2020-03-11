package com.maad.phablet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Replacing the list fragment with its container
          at the start of our Phablet "Phone + Tablet" application
        */
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_one_container, new ListFragment())
                .commit();
    }
}
