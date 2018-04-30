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

import java.util.ArrayList;

/**
 * Created by MALEK on 19/04/2018.
 */

public class TableAdapter extends ArrayAdapter<TableInfo> {
    Context context;
    int resource;

    public TableAdapter(@NonNull Context context, int resource, @NonNull ArrayList<TableInfo> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


       int play = getItem(position).getPlay();
        int point=getItem(position).getPoint();
        int win=getItem(position).getCount();
        int imgid=getItem(position).getImgid();

        TableInfo tableInfo=new TableInfo(play,point,win,imgid);

        LayoutInflater inflater= LayoutInflater.from(context);
        convertView=inflater.inflate(resource,parent,false);

        ImageView imageView=(ImageView)convertView.findViewById(R.id.imageTable);
        TextView textimg=(TextView) convertView.findViewById(R.id.nameflag);
        TextView textplay=(TextView)convertView.findViewById(R.id.p);
        TextView textpoint=(TextView)convertView.findViewById(R.id.pt);
        TextView textcount=(TextView)convertView.findViewById(R.id.c);

        imageView.setImageDrawable(convertView.getResources().getDrawable(Team.team[imgid].getImageResourceId()));
        textimg.setText(Team.team[imgid].getName());

        textplay.setText(String.valueOf(play));
        textpoint.setText(String.valueOf(point));
        textcount.setText(String.valueOf(win));




        return convertView;
    }
}
