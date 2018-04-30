package com.sport.malek.russia2018;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class ProfileActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int position;
    Fragment fragment;
    ConnectiveDetector cd;
    NavigationView navigationView;
    private InterstitialAd mInterstitialAd;
    int count=0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        cd = new ConnectiveDetector(getApplicationContext());

        AppRater.app_launched(this);

        // Initialize the ads and load it ..... ;
        MobileAds.initialize(this,getString(R.string.admobapp));

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.addunitinteristial));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        // Relod advertise when click exit in previous advs .... ;
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });


        //to get position from Flag .. in recycler view ...... ;;
        SharedPreferences preferences = getSharedPreferences("SaveFile", Context.MODE_PRIVATE);
        position = preferences.getInt("FlagPosition", 100);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (cd.isConnected()) {
            fragment = new News_fragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

            ft.commit();
            getSupportActionBar().setTitle(getString(R.string.news));
        } else {
            fragment = new ConnectionError();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
            getSupportActionBar().setTitle(getString(R.string.news));
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.getMenu().getItem(0).setChecked(true);


        // Set navigagation header options ....... ;
        View nView = navigationView.getHeaderView(0);

        // set image ....... ;
        ImageView imageView = (ImageView) nView.findViewById(R.id.imageflag);
        imageView.setImageDrawable(getResources().getDrawable(Team.team[position].getImageResourceId()));


        TextView textView = (TextView) nView.findViewById(R.id.flagprofile);
        textView.setText(Team.team[position].getName());
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (fragment instanceof News_fragment == false) {
            navigationView.getMenu().getItem(0).setChecked(true);
            if (cd.isConnected()) {
                fragment = new News_fragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

                ft.commit();
                getSupportActionBar().setTitle(getString(R.string.news));
            } else {
                fragment = new ConnectionError();
              this.finish();
            }

        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile, menu);
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
            fragment = new SettingFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
            getSupportActionBar().setTitle(R.string.setting);

            return true;

        }else if(id==R.id.action_share){
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT,getString(R.string.applicationPath));
            startActivity(Intent.createChooser(intent,"Share Using ..."));
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // home Fragment ......... ;
        if (id == R.id.nav_Home) {
            fragment = new StadiumFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
            getSupportActionBar().setTitle(R.string.home);

            //Show the ads if count = 3 and isLoaded .... ;
            count++;
            if (mInterstitialAd.isLoaded()&&count>=2) {
                mInterstitialAd.show();
            count=0;
            }


                //for Scores and time of match .......... ;
        } else if (id == R.id.nav_Score) {
            // if connected... ;
            if (cd.isConnected()) {

                //Show the ads if count = 3 and isLoaded .... ;
                count++;
                if (mInterstitialAd.isLoaded()&&count>=2) {
                    mInterstitialAd.show();
                    count=0;
                }

                Intent intent = new Intent(getApplicationContext(), Matches.class);
                startActivity(intent);


            } else {
                fragment = new ConnectionError();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
                getSupportActionBar().setTitle(getString(R.string.scores));

            }

            //For Group Table..... ;
        } else if (id == R.id.nav_table) {
            Intent intent = new Intent(ProfileActivity.this, tabbed_group_team.class);
            navigationView.getMenu().getItem(3).setChecked(false);
            startActivity(intent);

            //Show the ads if count = 3 and isLoaded .... ;
            count++;
            if (mInterstitialAd.isLoaded()&&count>=2) {
                mInterstitialAd.show();
                count=0;
            }

            //for Information Team.... ;
        } else if (id == R.id.nav_information) {
            fragment = new ListInformationTeam();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
            getSupportActionBar().setTitle(getString(R.string.informationteam));

            //Show the ads if count = 3 and isLoaded .... ;
            count++;
            if (mInterstitialAd.isLoaded()&&count>=2) {
                mInterstitialAd.show();
                count=0;
            }


        } else if (id == R.id.nav_news) {
            if (cd.isConnected()) {

                count++;
                if (mInterstitialAd.isLoaded()&&count>=2) {
                    mInterstitialAd.show();
                    count=0;}

                fragment = new News_fragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
                getSupportActionBar().setTitle(getString(R.string.news));

                //Show the ads if count = 3 and isLoaded .... ;

            } else {
                fragment = new ConnectionError();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
                getSupportActionBar().setTitle(getString(R.string.news));
            }

        } else if (id == R.id.nav_player) {
            if (cd.isConnected()) {
                fragment = new DayMatch_fragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
                getSupportActionBar().setTitle(getString(R.string.player));

                //Show the ads if count = 3 and isLoaded .... ;
                count++;
                if (mInterstitialAd.isLoaded()&&count>=2) {
                    mInterstitialAd.show();
                    count=0;}


            } else {

                fragment = new ConnectionError();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
                getSupportActionBar().setTitle(getString(R.string.player));

            }


        } else if (id == R.id.nav_info) {
            AlertDialog.Builder dialog=new AlertDialog.Builder(this,R.style.Theme_AppCompat_DayNight_Dialog_MinWidth);
            dialog.setMessage(getResources().getString(R.string.aboutdesc)+"\n"+"\n"+getString(R.string.appdeveloper)+" "+getString(R.string.malek)+"\n"+getString(R.string.release)+" "+getString(R.string.releasenumber))
                    .setTitle(getResources().getString(R.string.about))
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert=dialog.create();
            alert.show();

            //Show the ads if count = 3 and isLoaded .... ;
            count++;
            if (mInterstitialAd.isLoaded()&&count>=2) {
                mInterstitialAd.show();
                count=0;}


        } else if (id == R.id.nav_exit) {
            exitApplication();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void exitApplication() {
        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}