package com.example.jchandler.archeryapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainScreenOptionsMenu extends android.app.Fragment {

    Button newSet;
    Button seePastSets;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vw = inflater.inflate(R.layout.fragment_main_screen_options_menu, container, false);
        newSet = (Button) vw.findViewById(R.id.NEWSET);
        seePastSets = (Button)vw.findViewById(R.id.SEEPASTSETS);

        newSet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              FragmentManager fm = getFragmentManager();
              FragmentTransaction ft = fm.beginTransaction();
              NewSetScreen f1 = new NewSetScreen();
              ft.replace(R.id.mainReplaceMe, f1);
              ft.commit();
            }
        });

        seePastSets.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                SeePastScores f1 = new SeePastScores();
                ft.replace(R.id.mainReplaceMe, f1);
                ft.commit();
            }
        });


        return vw;
    }
}
