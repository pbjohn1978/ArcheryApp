package com.example.jchandler.archeryapp;

import android.os.Bundle;
import android.app.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        MainScreenOptionsMenu f1 = new MainScreenOptionsMenu();
        ft.replace(R.id.mainReplaceMe, f1);
        ft.commit();
    }
}
