package org.pursuit.fragmentcallbackcommunication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.pursuit.fragmentcallbackcommunication.fragments.DisplayFragment;
import org.pursuit.fragmentcallbackcommunication.fragments.FirstFragment;

public class MainActivity extends AppCompatActivity implements FragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment firstFragment = FirstFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_activity_container, firstFragment)
                .commit();
    }

    @Override
    public void toDisplayFragment(String name, String number, String image) {
        DisplayFragment displayFragment = DisplayFragment.newInstance(name, number, image);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_activity_container, displayFragment)
                .addToBackStack(null)
                .commit();
    }
}
