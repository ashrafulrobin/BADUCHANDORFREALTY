package com.example.ashra.badu_chandorfrealty;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.*;
import android.support.v4.app.ListFragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

///// connection code

        if(!isConnected(MainActivity.this)) buildDialog(MainActivity.this).show();
        else {
            // Intent intent = new Intent(InternetConnection.this,MainActivity.class);
            // startActivity(intent);
        }


        ////end of connection code


        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer= findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    ///connecttion code start



    public boolean isConnected(Context context) {
        this.context = context;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) return true;
            else return false;
        } else
            return false;
    }

    //2nd method

    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have Mobile Data or wifi to access this. Press ok to Exit");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();

            }
        });

        return builder;

    }

///end of code (internet connection )


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;

            case R.id.nav_create_property:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CreateFragment()).commit();
                break;

            case R.id.nav_home_for_sale:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LoginFragment()).commit();
                break;

            case R.id.nav_list:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ListFragment()).commit();
                break;
            case R.id.nav_rent_your_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeRentFragment()).commit();
                break;

            case R.id.nav_commercial_rent:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CommRentFragment()).commit();
                break;

            case R.id.nav_commercial_for_sale:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CommSaleFragment()).commit();
                break;

            case R.id.nav_for_lease:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CommLeaseFragment()).commit();
                break;

            case R.id.nav_contactus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContactFragment()).commit();
                break;

            case R.id.nav_office:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new OfficeFragment()).commit();
                break;

            case R.id.nav_career:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CareerFragment()).commit();
                break;



            case R.id.nav_blog:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BlogFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


@Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
           drawer.closeDrawer(GravityCompat.START);

        }
        else {
            super.onBackPressed();
        }
    }


    }



