package com.maad.phablet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        int receivedAnimalPicture = getIntent().getIntExtra(Constants.ANIMAL_KEY, -1);

        Bundle data = new Bundle();
        data.putInt(Constants.ANIMAL_KEY, receivedAnimalPicture);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(data);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_two_container, detailFragment)
                .commit();
    }
}
