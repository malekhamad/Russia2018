package com.sport.malek.russia2018;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class DayMatch_fragment extends Fragment {
    ListView listView;
    ProgressBar progressBar;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String date;
    ImageView imageView;
    TextView textView;

    AdView mAdView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_day_match_fragment, container, false);


        MobileAds.initialize(view.getContext(), getResources().getString(R.string.admobapp));

        mAdView=(AdView)view.findViewById(R.id.adView);
        AdRequest request=new AdRequest.Builder().build();
        mAdView.loadAd(request);

        listView = (ListView) view.findViewById(R.id.listdayMatch);
        progressBar = (ProgressBar) view.findViewById(R.id.progressdaymatch);
        imageView = (ImageView) view.findViewById(R.id.imgnoMatch);
        imageView.setVisibility(View.INVISIBLE);
        textView = (TextView) view.findViewById(R.id.texttoday);
        textView.setVisibility(View.INVISIBLE);

        // get time and put in date variable .......  ;
        date= DateNow();


       // retrive Today match From Search of nodes in firebase ...... ;
       getDataFromFirebase();


        return view;
    }

    //get Date from calendar Method ...... ;
    public String DateNow(){
        String b;
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        b = simpleDateFormat.format(calendar.getTime());
        return b;

    }




     //retrive data from firebase in method ....... ;
      public void getDataFromFirebase(){
          // get search for today match and put him in ArrayList...... ;
          firebaseDatabase = FirebaseDatabase.getInstance();
          databaseReference = firebaseDatabase.getReference();
          databaseReference.addValueEventListener(new ValueEventListener() {
              @Override
              public void onDataChange(DataSnapshot dataSnapshot) {
                  ArrayList<match_information> arrayList = new ArrayList<>();

                  for (DataSnapshot a : dataSnapshot.child("groups").child("a").child("matches").getChildren()) {
                      match_information matcha = a.getValue(match_information.class);
                      if (matcha.getDate1().equals(date)) {
                          arrayList.add(matcha);
                      }
                  }

                  for (DataSnapshot b : dataSnapshot.child("groups").child("b").child("matches").getChildren()) {
                      match_information matchb = b.getValue(match_information.class);
                      if (matchb.getDate1().equals(date)) {
                          arrayList.add(matchb);
                      }
                  }

                  for (DataSnapshot c : dataSnapshot.child("groups").child("c").child("matches").getChildren()) {
                      match_information matchc = c.getValue(match_information.class);
                      if (matchc.getDate1().equals(date)) {
                          arrayList.add(matchc);
                      }
                  }

                  for (DataSnapshot d : dataSnapshot.child("groups").child("d").child("matches").getChildren()) {
                      match_information matchd = d.getValue(match_information.class);
                      if (matchd.getDate1().equals(date)) {
                          arrayList.add(matchd);
                      }
                  }
                  for (DataSnapshot e : dataSnapshot.child("groups").child("a").child("matches").getChildren()) {
                      match_information matche = e.getValue(match_information.class);
                      if (matche.getDate1().equals(date)) {
                          arrayList.add(matche);
                      }
                  }

                  for (DataSnapshot f : dataSnapshot.child("groups").child("f").child("matches").getChildren()) {
                      match_information matchf = f.getValue(match_information.class);
                      if (matchf.getDate1().equals(date)) {
                          arrayList.add(matchf);
                      }
                  }

                  for (DataSnapshot g : dataSnapshot.child("groups").child("g").child("matches").getChildren()) {
                      match_information matchg = g.getValue(match_information.class);
                      if (matchg.getDate1().equals(date)) {
                          arrayList.add(matchg);
                      }
                  }

                  for (DataSnapshot h : dataSnapshot.child("groups").child("h").child("matches").getChildren()) {
                      match_information matchh = h.getValue(match_information.class);
                      if (matchh.getDate1().equals(date)) {
                          arrayList.add(matchh);
                      }
                  }
                  for (DataSnapshot round16 : dataSnapshot.child("knockout").child("round_16").child("matches").getChildren()) {
                      match_information round16Value = round16.getValue(match_information.class);
                      if (round16Value.getDate1().equals(date)) {
                          arrayList.add(round16Value);
                      }
                  }


                  for (DataSnapshot round8 : dataSnapshot.child("knockout").child("round_8").child("matches").getChildren()) {
                      match_information round8Value = round8.getValue(match_information.class);
                      if (round8Value.getDate1().equals(date)) {
                          arrayList.add(round8Value);
                      }
                  }

                  for (DataSnapshot round4 : dataSnapshot.child("knockout").child("round_4").child("matches").getChildren()) {
                      match_information round4Value = round4.getValue(match_information.class);
                      if (round4Value.getDate1().equals(date)) {
                          arrayList.add(round4Value);
                      }
                  }

                  for (DataSnapshot round2_loser : dataSnapshot.child("knockout").child("round_2_loser").child("matches").getChildren()) {
                      match_information round2_loserValue = round2_loser.getValue(match_information.class);
                      if (round2_loserValue.getDate1().equals(date)) {
                          arrayList.add(round2_loserValue);
                      }
                  }

                  for (DataSnapshot round2 : dataSnapshot.child("knockout").child("round_2").child("matches").getChildren()) {
                      match_information round2Value = round2.getValue(match_information.class);
                      if (round2Value.getDate1().equals(date)) {
                          arrayList.add(round2Value);
                      }
                  }


                  if (arrayList.isEmpty()) {
                      imageView.setVisibility(View.VISIBLE);
                      textView.setVisibility(View.VISIBLE);
                  } else {
                      imageView.setVisibility(View.INVISIBLE);
                      textView.setVisibility(View.INVISIBLE);

                  }
                  match_adapter match_adapter = new match_adapter(getActivity(), R.layout.list_match_design, arrayList);
                  listView.setAdapter(match_adapter);
                  progressBar.setVisibility(View.INVISIBLE);
              }


              @Override
              public void onCancelled(DatabaseError databaseError) {

              }
          });
      }
}
