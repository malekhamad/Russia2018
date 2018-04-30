package com.sport.malek.russia2018;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MALEK on 03/12/2017.
 */

public class recycle_flag_card extends RecyclerView.Adapter<recycle_flag_card.ViewHolder> {

int lastposition=-1;



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_team, parent, false);
        return new ViewHolder(cv);

    }

    // we need these variable to hold team data ............. ;
    String name[];
    int img[];

    public recycle_flag_card(String[] name, int[] img) {
        this.name = name;
        this.img = img;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final CardView cardView = holder.cardView;
        final ImageView imageView = (ImageView) cardView.findViewById(R.id.imageteam);
        Drawable drawable = cardView.getResources().getDrawable(img[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(name[position]);
        TextView textView = (TextView) cardView.findViewById(R.id.textteam);
        textView.setText(name[position]);
        setAnimation(holder.itemView,position);

        holder.cardView.setTag(position);




        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //set position from card view ..... ;;
                int position = (int) view.getTag();

                // save position of flag ........ ;
                SharedPreferences sharedPreferences=view.getContext().getSharedPreferences("SaveFile",view.getContext().MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt("FlagPosition",position);
                editor.apply();


                Intent intent = new Intent(view.getContext(), ProfileActivity.class);

                // to destroy chooseTeam activity when i pressed back button from profile layout ......... ;
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                view.getContext().startActivity(intent);



            }
        });


    }

    @Override
    public int getItemCount() {
        return name.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;


        public ViewHolder(CardView v) {
            super(v);
            cardView = v;


        }


    }
    public void setAnimation(View viewToAnimate,int position){
        if(position>lastposition){
        Animation animation= AnimationUtils.loadAnimation(viewToAnimate.getContext(),android.R.anim.slide_in_left);
        viewToAnimate.startAnimation(animation);
        lastposition=position;
    }}

}
