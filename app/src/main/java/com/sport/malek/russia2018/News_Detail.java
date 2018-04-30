package com.sport.malek.russia2018;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;

import java.io.FileNotFoundException;

public class News_Detail extends AppCompatActivity {
    ImageView imageView;
    TextView texttitle, textdescription, textfrom, texttime;
    AdView mAdView;
    String title, image, description, source, time, path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news__detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);



        getSupportActionBar().setTitle(getString(R.string.news));


        MobileAds.initialize(this,getString(R.string.addunit));

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




        //Initialize component .....  ;
        imageView = (ImageView) findViewById(R.id.imgNewsDetail);
        texttitle = (TextView) findViewById(R.id.textNewsDetail);
        textdescription = (TextView) findViewById(R.id.textNewsDescription);
        textfrom = (TextView) findViewById(R.id.textnewsfrom);
        texttime = (TextView) findViewById(R.id.textNewstime);

        //get data from recycler_new_card class ...... ;
        title = (String) getIntent().getExtras().get("title");
        image = (String) getIntent().getExtras().get("imagenews");
        description = (String) getIntent().getExtras().get("desc");
        source = (String) getIntent().getExtras().get("from");
        time = (String) getIntent().getExtras().get("time");
        path = (String) getIntent().getExtras().get("path");

        Picasso.with(this).load(image).into(imageView);

        texttitle.setText(title);
        textdescription.setText(description);
        textfrom.setText(source);
        texttime.setText(time);

    }

    public void sharenews(View view) throws FileNotFoundException {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String textTitle = texttitle.getText().toString();
        intent.putExtra(Intent.EXTRA_SUBJECT, textTitle);
        intent.putExtra(Intent.EXTRA_TEXT, path+"\n"+getString(R.string.downloadapp)+"\n"+getString(R.string.applicationPath));
        startActivity(Intent.createChooser(intent, "Share Using ..."));


    }


    public void textreadmore(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(path));
        startActivity(intent);
    }
}
