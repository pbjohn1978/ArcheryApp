package com.example.jchandler.archeryapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NewSetScreen extends android.app.Fragment {
    Button doneEnteringSet;
    EditText a0;
    EditText a1;
    EditText a2;
    EditText a3;
    EditText a4;
    EditText a5;
    EditText a6;
    EditText a7;
    EditText a8;
    EditText a9;

    int b0;
    int b1;
    int b2;
    int b3;
    int b4;
    int b5;
    int b6;
    int b7;
    int b8;
    int b9;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vw = inflater.inflate(R.layout.fragment_new_set_screen, container, false);
        doneEnteringSet = (Button)vw.findViewById(R.id.NewSetDoneButton);
        a0 = (EditText)vw.findViewById(R.id.arrow0);
        a1 = (EditText)vw.findViewById(R.id.arrow1);
        a2 = (EditText)vw.findViewById(R.id.arrow2);
        a3 = (EditText)vw.findViewById(R.id.arrow3);
        a4 = (EditText)vw.findViewById(R.id.arrow4);
        a5 = (EditText)vw.findViewById(R.id.arrow5);
        a6 = (EditText)vw.findViewById(R.id.arrow6);
        a7 = (EditText)vw.findViewById(R.id.arrow7);
        a8 = (EditText)vw.findViewById(R.id.arrow8);
        a9 = (EditText)vw.findViewById(R.id.arrow9);


        final SetListDB db = new SetListDB(vw.getContext());


        doneEnteringSet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //TODO: these lines crash if no data is entered into the editTexts... // FIXME: 12/1/2016
                if(!a0.getText().toString().equals(""))
                {
                    b0 = Integer.parseInt(a0.getText().toString());
                }
                else
                {
                    b0 = 0;
                }
                if(!a1.getText().toString().equals(""))
                {
                    b1 = Integer.parseInt(a1.getText().toString());
                }
                else
                {
                    b1 = 0;
                }
                if(!a2.getText().toString().equals(""))
                {
                    b2 = Integer.parseInt(a2.getText().toString());
                }
                else
                {
                    b2 = 0;
                }
                if(!a3.getText().toString().equals(""))
                {
                    b3 = Integer.parseInt(a3.getText().toString());
                }
                else
                {
                    b3 = 0;
                }
                if(!a4.getText().toString().equals(""))
                {
                    b4 = Integer.parseInt(a4.getText().toString());
                }
                else
                {
                    b4 = 0;
                }
                if(!a5.getText().toString().equals(""))
                {
                    b5 = Integer.parseInt(a5.getText().toString());
                }
                else
                {
                    b5 = 0;
                }
                if(!a6.getText().toString().equals(""))
                {
                    b6 = Integer.parseInt(a6.getText().toString());
                }
                else
                {
                    b6 = 0;
                }
                if(!a7.getText().toString().equals(""))
                {
                    b7 = Integer.parseInt(a7.getText().toString());
                }
                else
                {
                    b7 = 0;
                }
                if(!a8.getText().toString().equals(""))
                {
                    b8 = Integer.parseInt(a8.getText().toString());
                }
                else
                {
                    b8 = 0;
                }
                if(!a9.getText().toString().equals(""))
                {
                    b9 = Integer.parseInt(a9.getText().toString());
                }
                else
                {
                    b9 = 0;
                }



                Set s = new Set();
                s.setTheArrows( b0,b1,b2,b3,b4,b5,b6,b7,b8,b9 );


                db.insertSet(s);

                

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
