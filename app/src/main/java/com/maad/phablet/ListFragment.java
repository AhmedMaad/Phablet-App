package com.maad.phablet;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private String[] animalNames = {"Bird", "Camel", "Cat", "Dog", "Elephant", "Fish", "Monkey"
            , "Turtle"};
    private int[] animalPictures = {R.drawable.bird, R.drawable.camel, R.drawable.cat
            , R.drawable.dog, R.drawable.elephant, R.drawable.fish, R.drawable.monkey
            , R.drawable.turtle};

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ArrayAdapter adapter = new ArrayAdapter<>(getContext(), R.layout.list_item, animalNames);
        ListView listView = view.findViewById(R.id.lv);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int id, long l) {

                /*Checking whether the current running device is a phone or tablet from a file
                created by me under res/values/booleans, this file has only one boolean value
                with the key "isTablet"
                 */
                boolean isTablet = getResources().getBoolean(R.bool.isTablet);

                if (isTablet) {
                    switchFragmentForTablets(animalPictures[id]);
                } else {
                    openSecondActivityForMobile(animalPictures[id]);
                }

            }
        });
        return view;
    }

    private void switchFragmentForTablets(int currentAnimal) {
        Bundle data = new Bundle();
        data.putInt(Constants.ANIMAL_KEY, currentAnimal);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(data);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_two_container, detailFragment)
                .commit();
    }

    private void openSecondActivityForMobile(int currentAnimal) {
        Intent i = new Intent(getContext(), SecondActivity.class);
        i.putExtra(Constants.ANIMAL_KEY, currentAnimal);
        startActivity(i);
    }

}
