package com.goldcode.naderwalid.miniproject;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class AuthActivity extends AppCompatActivity {
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        progressBar = findViewById(R.id.progress);


        FragmentManager manager = getSupportFragmentManager();
        NoUIFragment fragment = (NoUIFragment) manager.findFragmentByTag("MyProgressFragment");
        if(fragment == null) {
            fragment = new NoUIFragment();
            manager.beginTransaction().add(fragment, "MyProgressFragment").commit();
        }
        fragment.setProgressBar(progressBar);
    }
}
