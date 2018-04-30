package com.sport.malek.russia2018;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by MALEK on 25/03/2018.
 */

public class match_adapter extends ArrayAdapter<match_information> {
    Context context;
    int resource;




    public match_adapter( Context context, int resource, ArrayList<match_information> objects) {
        super(context, resource , objects);
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String datenow;
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        datenow=simpleDateFormat.format(calendar.getTime());





        int wayteam=getItem(position).getAway_team();
        int hometeam=getItem(position).getHome_team();
        String date=getItem(position).getDate();
        boolean finished =getItem(position).isFinished();
        int stadium=getItem(position).getStadium();
        String type=getItem(position).getType();
        String date1=getItem(position).getDate1();
        String time=getItem(position).getTime();

        match_information match_information=new match_information(wayteam,date,finished,hometeam,stadium,type,date1,time);

        LayoutInflater inflater=LayoutInflater.from(context);
        convertView= inflater.inflate(resource,parent,false);

        ImageView imgway=(ImageView)convertView.findViewById(R.id.imageway);
        ImageView imghome=(ImageView)convertView.findViewById(R.id.imagehome);
        TextView textwayteam=(TextView)convertView.findViewById(R.id.textway);
        TextView texthometeam=(TextView)convertView.findViewById(R.id.texthome);
        TextView textdatea=(TextView)convertView.findViewById(R.id.textdate);
        TextView textres=(TextView)convertView.findViewById(R.id.textresult);

        imgway.setImageDrawable(convertView.getResources().getDrawable(Team.team[wayteam].getImageResourceId()));
        imghome.setImageDrawable(convertView.getResources().getDrawable(Team.team[hometeam].getImageResourceId()));



        textwayteam.setText(Team.team[wayteam].getName());

        texthometeam.setText(Team.team[hometeam].getName());
     if(date1.equals(datenow)){
         textdatea.setText("Today");
     }else{
       textdatea.setText(date1);}



       textres.setText(time);

       



        return convertView;
    }
}
