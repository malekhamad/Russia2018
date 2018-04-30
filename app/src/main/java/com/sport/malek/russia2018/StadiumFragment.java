package com.sport.malek.russia2018;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


/**
 * A simple {@link Fragment} subclass.
 */
public class StadiumFragment extends Fragment {
    ListView listView;
    View view;
    AdView mAdView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
         view= inflater.inflate(R.layout.fragment_stadium, container, false);

        MobileAds.initialize(view.getContext(), getResources().getString(R.string.admobapp));


        mAdView=(AdView)view.findViewById(R.id.adView);
         AdRequest request=new AdRequest.Builder().build();
         mAdView.loadAd(request);





        listView =(ListView)view.findViewById(R.id.list_stadium);

        StadiumAdapter stadiumAdapter=new StadiumAdapter(getActivity(),R.layout.stadium_layout_design,Stadium_information.stadium);

        listView.setAdapter(stadiumAdapter);










        return view;
    }


}
