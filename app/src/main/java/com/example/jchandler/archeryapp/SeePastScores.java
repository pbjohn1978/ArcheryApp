package com.example.jchandler.archeryapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SeePastScores extends android.app.Fragment{
    Button backToMainMenu;
    TextView scores;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vw = inflater.inflate(R.layout.fragment_see_past_scores, container, false);
        backToMainMenu = (Button)vw.findViewById(R.id.SeePastScoresDoneButton);

        //TODO: this is where you left off at...
        SetListDB db = new SetListDB(vw.getContext());
        StringBuilder sb = new StringBuilder();

        scores = (TextView) vw.findViewById(R.id.textForPastScoresReplaceMe);

        ArrayList<Set> sets = db.getAllSets();

        sb.append("These are your past scores: \n");
        int i = 1;
        int total = 0;
        double avg;
        for (Set s: sets) {
            for (int n: s.GetSetArrows()) {
                total += n;
            }
            avg = total / 10.0;
            total = 0;
            sb.append(i + ":\t\t" + s.toString() + "\t\t" + avg + "\n");
            i++;
        }

        if(sets == null)
        {
            sb.append("null null null");
        }
        String output = String.valueOf(sb);
        scores.setText(output);

        backToMainMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                MainScreenOptionsMenu f1 = new MainScreenOptionsMenu();
                ft.replace(R.id.mainReplaceMe, f1);
                ft.commit();
            }
        });

        return vw;
    }
}
