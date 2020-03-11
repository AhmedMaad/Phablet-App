package com.maad.phablet;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        //Receiving the data from the bundle
        Bundle receivedData = getArguments();
        ImageView imageView = view.findViewById(R.id.iv);
        imageView.setImageResource(receivedData.getInt(Constants.ANIMAL_KEY));
        return view;
    }


}
