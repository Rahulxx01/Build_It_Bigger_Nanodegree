package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.main.EndpointsAsyncTask;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       root = inflater.inflate(R.layout.fragment_main, container, false);

        root.findViewById(R.id.joke_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root.findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
                new EndpointsAsyncTask(getContext(), root.findViewById(R.id.progressBar)).execute();
            }
        });

        return root;
    }
}
