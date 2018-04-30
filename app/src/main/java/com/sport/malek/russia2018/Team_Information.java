package com.sport.malek.russia2018;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Locale;

public class Team_Information extends AppCompatActivity {

    int item;
    private AdView mAdView;


    TextView textname,Description,PlayerBest;
    ImageView imageView,img1,img2,img3,img4,img5;
    TextView textappearance,textfinal,textrank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);

        MobileAds.initialize(this, getResources().getString(R.string.admobapp));


        mAdView =findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

if(Locale.getDefault().getDisplayLanguage().equals("English")){
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });}else {
    toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp));
    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    });
}



        item=(int)getIntent().getExtras().get("p");
        getSupportActionBar().setTitle(Team.team[item].getName());




        NestedScrollView nestedScrollView=(NestedScrollView)findViewById(R.id.detail);

        textname=(TextView)nestedScrollView.findViewById(R.id.flagtext);
        textname.setText(Team.team[item].getName());





        imageView=(ImageView)findViewById(R.id.teamimage);
        imageView.setImageDrawable(getResources().getDrawable(Team.team[item].getImageTeamId()));


        Description=(TextView)findViewById(R.id.description);
        Description.setText(getString(Team.team[item].getDescription()));

        textappearance=(TextView)findViewById(R.id.appearance);
        textfinal=(TextView)findViewById(R.id.finals);
        textrank=(TextView)findViewById(R.id.rank);


        textappearance.setText(String.valueOf(Team.team[item].getAppearances()));
        textfinal.setText(String.valueOf(Team.team[item].getFinal_match()));
        textrank.setText(String.valueOf(Team.team[item].getRanking()));


        PlayerBest=(TextView)findViewById(R.id.bestPlayer);
        PlayerBest.setText(getString(Team.team[item].getBestPlayer()));

        img1=(ImageView)findViewById(R.id.win1);
        img2=(ImageView)findViewById(R.id.win2);
        img3=(ImageView)findViewById(R.id.win3);
        img4=(ImageView)findViewById(R.id.win4);
        img5=(ImageView)findViewById(R.id.win5);


        switch (item){
            case 0 :
                img1.setImageResource(R.drawable.star);
                img2.setImageResource(R.drawable.star);
                break;
            case 2:
                img1.setImageResource(R.drawable.star);
                img2.setImageResource(R.drawable.star);
                img3.setImageResource(R.drawable.star);
                img4.setImageResource(R.drawable.star);
                img5.setImageResource(R.drawable.star);
                break;
            case 8:
                img1.setImageResource(R.drawable.star);
                break;
            case 9:
                img1.setImageResource(R.drawable.star);
                break;
            case 10:
                img1.setImageResource(R.drawable.star);
                img2.setImageResource(R.drawable.star);
                img3.setImageResource(R.drawable.star);
                img4.setImageResource(R.drawable.star);
                break;
            case 27:
                img1.setImageResource(R.drawable.star);
                break;
            case 31:
                img1.setImageResource(R.drawable.star);
                img2.setImageResource(R.drawable.star);
                break;

        }


    }
}
