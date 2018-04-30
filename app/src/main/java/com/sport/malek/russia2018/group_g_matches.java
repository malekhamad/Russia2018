package com.sport.malek.russia2018;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class group_g_matches extends Fragment {

    ListView listView;
    FirebaseDatabase fd;
    DatabaseReference dref;
   ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.match_layout, container, false);
        listView=(ListView)view.findViewById(R.id.list_match_group);

        progressBar=(ProgressBar)view.findViewById(R.id.progresswait);

        progressBar.setVisibility(View.VISIBLE);

        //to retrieve data from firebase ......... ;
        fd=FirebaseDatabase.getInstance();
        dref=fd.getReference("groups").child("g").child("matches");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final ArrayList<match_information> match_info=new ArrayList<>();

                for(DataSnapshot b:dataSnapshot.getChildren()){
                    match_information mi=b.getValue(match_information.class);
                    match_info.add(mi);
                }

                // to pass data to match adapter ............ ;
                match_adapter match_adapter=new match_adapter(getActivity(),R.layout.list_match_design,match_info);
                listView.setAdapter(match_adapter);
                progressBar.setVisibility(View.INVISIBLE);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return view;
    }

}
