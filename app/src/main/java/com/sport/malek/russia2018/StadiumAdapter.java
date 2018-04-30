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

/**
 * Created by MALEK on 14/04/2018.
 */

public class StadiumAdapter extends ArrayAdapter<Stadium_information> {
    Context context;
    int resource;



    public StadiumAdapter( Context context, int resource,  Stadium_information[] objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



       LayoutInflater inflater=LayoutInflater.from(context);
        convertView= inflater.inflate(resource,parent,false);
        ImageView imageView=(ImageView)convertView.findViewById(R.id.imageStadium);
        TextView textname=(TextView)convertView.findViewById(R.id.stadium_name_text);
        TextView textcapacity=(TextView)convertView.findViewById(R.id.stadium_capacity_text);
        TextView textlocation=(TextView)convertView.findViewById(R.id.stadium_location_text);
        TextView textopening=(TextView)convertView.findViewById(R.id.stadium_opening_text);
        TextView textViewheader=(TextView)convertView.findViewById(R.id.textheaderStadium);

        textViewheader.setText(Stadium_information.stadium[position].getName());
        textname.setText(Stadium_information.stadium[position].getName());
        textcapacity.setText(Stadium_information.stadium[position].getCapacity());
        textlocation.setText(Stadium_information.stadium[position].getLocation());
        textopening.setText(Stadium_information.stadium[position].getOpening());
        imageView.setImageDrawable(convertView.getResources().getDrawable(Stadium_information.stadium[position].getImgres()));


        return convertView;
    }
}
