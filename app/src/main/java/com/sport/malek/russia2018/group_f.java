package com.sport.malek.russia2018;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class group_f extends Fragment {


    public group_f() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View  v=inflater.inflate(R.layout.group_a, container, false);
        TextView textView=(TextView)v.findViewById(R.id.g_a);
        textView.setText(getResources().getString(R.string.group6));
        ListView listView=(ListView)v.findViewById(R.id.listTable);
        GroupF f=new GroupF();
        listView.setAdapter(f);

        return  v;    }
    class GroupF extends BaseAdapter {
        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }


        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.table_info,null);

            ImageView imageView=view.findViewById(R.id.imageTable);
            TextView nameImage=view.findViewById(R.id.nameflag);
            imageView.setImageDrawable(getResources().getDrawable(Team_Table_Group.group_F[i].getImgId()));
            nameImage.setText(Team_Table_Group.group_F[i].getNamef());
            return view;
        }
    }
}
