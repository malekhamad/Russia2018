package com.sport.malek.russia2018;


import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class News_fragment extends Fragment {
    DatabaseReference dref;
    FirebaseDatabase fb;
    RecyclerView recyclerView;
    ConnectiveDetector cd;
    boolean a = false;

    ProgressDialog progressDialog;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_news_fragment, container, false);

        final SwipeRefreshLayout srl=(SwipeRefreshLayout)view.findViewById(R.id.swiperefresh);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srl.setRefreshing(true);
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        srl.setRefreshing(false);
                        if(cd.isConnected()) {
                            dref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    ArrayList<NewsInformation> information = new ArrayList<>();
                                    for (DataSnapshot a : dataSnapshot.getChildren()) {

                                        NewsInformation ns = a.getValue(NewsInformation.class);
                                        information.add(ns);

                                    }
                                    Collections.reverse(information);
                                    recycle_news_card recycle_news_card = new recycle_news_card(getActivity(), information);
                                    recyclerView.setAdapter(recycle_news_card);
                                   progressDialog.dismiss();
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                    progressDialog.dismiss();
                                    Toast.makeText(getActivity(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            });

                        }
                        else{
                            // if Not connected with internet ............  ;
                             progressDialog.dismiss();
                            Toast.makeText(getActivity(),"Please Check Your Connection",Toast.LENGTH_LONG).show();
 }

                    }
                },2000);
            }
        });

 progressDialog = ProgressDialog.show(getActivity(), "Processing", "Please Wait ...", false, true, new DialogInterface.OnCancelListener() {
     @Override
     public void onCancel(DialogInterface dialog) {
         progressDialog.dismiss();
     }
 });
        fb = FirebaseDatabase.getInstance();
        dref = fb.getReference("News");
        dref.keepSynced(true);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        cd = new ConnectiveDetector(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);


        //Check if the internet is connected before get date from firebase .... ;
        final ArrayList<NewsInformation> information = new ArrayList<>();



        if(cd.isConnected()) {
            dref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot a : dataSnapshot.getChildren()) {

                        NewsInformation ns = a.getValue(NewsInformation.class);
                        information.add(ns);

                    }
                    Collections.reverse(information);



                    recycle_news_card recycle_news_card = new recycle_news_card(getActivity(), information);
                    recyclerView.setAdapter(recycle_news_card);
                    progressDialog.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                   progressDialog.dismiss();
                    Toast.makeText(getActivity(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        }
        else{
            // if Not connected with internet ............  ;

            Toast.makeText(getActivity(),"Please Check Your Connection",Toast.LENGTH_LONG).show();

            recycle_news_card recycle_news_card = new recycle_news_card(getActivity(), information);
            recyclerView.setAdapter(recycle_news_card);
          progressDialog.dismiss();
        }



        // Inflate the layout for this fragment
        return view;

    }
    

}

