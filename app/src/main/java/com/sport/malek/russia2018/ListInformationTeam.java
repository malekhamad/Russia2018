package com.sport.malek.russia2018;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListInformationTeam extends Fragment {
    ListView listView;
    String listitem[];

    // initialize interstitial add . ...... ;
    private InterstitialAd mInterstitialAd;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view=inflater.inflate(R.layout.fragment_information_team, container, false);


        MobileAds.initialize(view.getContext(),getString(R.string.admobapp));

        // Create Object of Interstitial ads ....  and add idunit .......... ;
        mInterstitialAd = new InterstitialAd(view.getContext());
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




        listitem=new String[Team.team.length];
        listView=(ListView)view.findViewById(R.id.listInformationTeam);

        for(int i=0;i<listitem.length;i++){
            listitem[i]=getResources().getString(Team.team[i].getName());
        }


        ArrayAdapter<String>adapter=new ArrayAdapter<String>(view.getContext(),R.layout.teamitem,listitem);
        listView.setAdapter(adapter);


        // onclick statement to list view ................ ;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // if ads loaded showen ..... ;
                if(mInterstitialAd.isLoaded()){
                    mInterstitialAd.show();
                }
               Intent intent=new Intent(view.getContext(),Team_Information.class);
               intent.putExtra("p",position);
               startActivity(intent);
            }
        });


        return view;
    }

}
