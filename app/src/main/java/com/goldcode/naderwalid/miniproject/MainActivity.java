package com.goldcode.naderwalid.miniproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    Toolbar toolbar;
    FragmentTransaction fragmentTransaction;
    static int[] drawables = {
            R.drawable.ic_android_mood_angry,
            R.drawable.ic_android_mood_crying,
            R.drawable.ic_android_mood_dead,
            R.drawable.ic_android_mood_happy,
            R.drawable.ic_android_mood_happy_successful,
            R.drawable.ic_android_mood_joke,
            R.drawable.ic_android_mood_love,
            R.drawable.ic_android_mood_normal,
            R.drawable.ic_android_mood_sad,
            R.drawable.ic_android_mood_sad_tear,
            R.drawable.ic_android_mood_sick,
            R.drawable.ic_android_mood_smile_successful,
            R.drawable.ic_android_mood_tired,

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.home));

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container,new HomeFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
         int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the home action
            toolbar.setTitle(getResources().getString(R.string.home));
            FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
            fragmentTransaction1.replace(R.id.main_container,new HomeFragment());
            fragmentTransaction1.commit();
            fragmentTransaction1.addToBackStack(null);
            drawer.closeDrawer(GravityCompat.START);

        }  else if (id == R.id.nav_people_list) {
            toolbar.setTitle(getResources().getString(R.string.peoplelist));
            FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
            fragmentTransaction2.replace(R.id.main_container,new PeopleListFragment());
            fragmentTransaction2.commit();
            fragmentTransaction2.addToBackStack(null);
            drawer.closeDrawer(GravityCompat.START);

        } else if (id == R.id.nav_contact_us) {
            toolbar.setTitle(getResources().getString(R.string.contact_us));
            FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
            fragmentTransaction3.replace(R.id.main_container,new ContactUsFragment());
            fragmentTransaction3.commit();
            fragmentTransaction3.addToBackStack(null);
            drawer.closeDrawer(GravityCompat.START);


        } else if (id == R.id.nav_logout) {
            //intent to start login activity. and finish this activity
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
            drawer.closeDrawer(GravityCompat.START);
        }



//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
