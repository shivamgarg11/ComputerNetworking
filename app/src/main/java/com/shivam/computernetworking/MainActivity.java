package com.shivam.computernetworking;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.shivam.computernetworking.fragments.AOVD;
import com.shivam.computernetworking.fragments.DiffieHellman;
import com.shivam.computernetworking.fragments.DistanceVector;
import com.shivam.computernetworking.fragments.GoBackN;
import com.shivam.computernetworking.fragments.Home;
import com.shivam.computernetworking.fragments.LinkState;
import com.shivam.computernetworking.fragments.RSA;
import com.shivam.computernetworking.fragments.SelectiveRepeat;
import com.shivam.computernetworking.fragments.StopAndWait;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.app.FragmentManager fragmentManager = getFragmentManager();
        Home frag = new Home();
        fragmentManager.beginTransaction().replace(R.id.frame, frag).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            new AlertDialog.Builder(this)
                    .setMessage("Do You Want To Exit")
                    .setPositiveButton("YES", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finishAffinity();
                        }

                    })
                    .setNegativeButton("NO", null)
                    .show();
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
            android.app.FragmentManager fragmentManager = getFragmentManager();
            Home frag = new Home();
            fragmentManager.beginTransaction().replace(R.id.frame, frag).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.RSA) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            RSA frag = new RSA();
            fragmentManager.beginTransaction().replace(R.id.frame, frag).commit();

        } else if (id == R.id.DiffieHellman) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            DiffieHellman frag = new DiffieHellman();
            fragmentManager.beginTransaction().replace(R.id.frame, frag).commit();

        } else if (id == R.id.LinkState) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            LinkState frag = new LinkState();
            fragmentManager.beginTransaction().replace(R.id.frame, frag).commit();

        } else if (id == R.id.DistanceVector) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            DistanceVector frag = new DistanceVector();
            fragmentManager.beginTransaction().replace(R.id.frame, frag).commit();

        } else if (id == R.id.AODV) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            AOVD frag = new AOVD();
            fragmentManager.beginTransaction().replace(R.id.frame, frag).commit();

        } else if (id == R.id.SelectiveRepeat) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            SelectiveRepeat frag = new SelectiveRepeat();
            fragmentManager.beginTransaction().replace(R.id.frame, frag).commit();

        }
        else if (id == R.id.GoBackN) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            GoBackN frag = new GoBackN();
            fragmentManager.beginTransaction().replace(R.id.frame, frag).commit();


        }
        else if (id == R.id.StopAndWait) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            StopAndWait frag = new StopAndWait();
            fragmentManager.beginTransaction().replace(R.id.frame, frag).commit();

        }

        else{
            android.app.FragmentManager fragmentManager = getFragmentManager();
        Home frag = new Home();
        fragmentManager.beginTransaction().replace(R.id.frame, frag).commit();}


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
