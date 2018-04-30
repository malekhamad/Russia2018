package com.sport.malek.russia2018;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ChooseTeam extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_team);

        RecyclerView teamRecycler=(RecyclerView)findViewById(R.id.team_recyle);

        // Create For Team name ........ ;
        String teamName[]=new String[Team.team.length];
        for(int i=0;i<teamName.length;i++){
            teamName[i]=getResources().getString(Team.team[i].getName());
        }

        //Create For Team ImageResourceId .......... ;
        int teamImgid[]=new int[Team.team.length];
        for(int i=0;i<teamImgid.length;i++){
            teamImgid[i]=Team.team[i].getImageResourceId();
        }

        // Set Value to constructor in Recycler class to set team name and team image resource id ....... ;
        recycle_flag_card adapter=new recycle_flag_card(teamName,teamImgid);


        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        teamRecycler.setLayoutManager(layoutManager);

        teamRecycler.setAdapter(adapter);
    }


}
