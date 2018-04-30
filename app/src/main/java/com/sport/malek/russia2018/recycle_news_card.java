package com.sport.malek.russia2018;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by MALEK on 06/02/2018.
 */

public class recycle_news_card extends RecyclerView.Adapter<recycle_news_card.ViewHolder> {
    private InterstitialAd mInterstitialAd;
    int count=0;

    ArrayList<NewsInformation>info=new ArrayList<>();
private Context context;
int lastposition=-1;

    public recycle_news_card(Context context,ArrayList<NewsInformation> info) {
        this.info = info;
        this.context=context;
    }


    @Override
    public recycle_news_card.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv=(CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card,parent,false);

        // initialize the interstitialAd .... ;
        MobileAds.initialize(parent.getContext(),
                parent.getContext().getResources().getString(R.string.admobapp));

        // Loaded Ads ..... ;;
        mInterstitialAd = new InterstitialAd(parent.getContext());
        mInterstitialAd.setAdUnitId(parent.getContext().getResources().getString(R.string.addunitinteristial));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        // Relod advertise when click exit in previous advs .... ;
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(recycle_news_card.ViewHolder holder, int position) {
        final CardView cardView=holder.cv;
        TextView textname=(TextView)cardView.findViewById(R.id.textNews);
        ImageView imgtext=(ImageView)cardView.findViewById(R.id.imageNews);
        TextView txtdate=(TextView)cardView.findViewById(R.id.textdate);
        TextView txtsource=(TextView)cardView.findViewById(R.id.textsource);
      final NewsInformation ni=info.get(position);

        //These line to put picture from url in the image view .... ;
        Picasso.with(cardView.getContext()).load(ni.getImageurl()).into(imgtext);

        textname.setText(ni.getTitle());
        txtsource.setText(ni.getFrom());
        txtdate.setText(ni.getTime());


        setAnimation(cardView,position);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // if count is 2 and ads is loaded then showen ........ ;
                count++;
                if(mInterstitialAd.isLoaded()&&count==2){
                    mInterstitialAd.show();
                    count=0;
                }


                Intent intent=new Intent(cardView.getContext(),News_Detail.class);
                intent.putExtra("title",ni.getTitle());
                intent.putExtra("imagenews",ni.getImageurl());
                intent.putExtra("desc",ni.getDesc());
                intent.putExtra("from",ni.getFrom());
                intent.putExtra("time",ni.getTime());
                intent.putExtra("path",ni.getPath());
                cardView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return info.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        public ViewHolder(CardView v) {
            super(v);
            cv=v;
        }
    }
    public void setAnimation(View viewToAnimate, int position){
        if(position>lastposition){
            Animation animation= AnimationUtils.loadAnimation(viewToAnimate.getContext(),android.R.anim.fade_in);
            viewToAnimate.startAnimation(animation);
            lastposition=position;
        }}
}
