package com.sport.malek.russia2018;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {


    int n ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);




        SharedPreferences preferences=getSharedPreferences("SaveFile", Context.MODE_PRIVATE);
        n=preferences.getInt("FlagPosition",100);

        // Splash Screen After 3 minute Intent to MainActivity ......... ;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

if(n==100){
                Intent intent = new Intent(SplashScreen.this, ChooseTeam.class);
                startActivity(intent);
                finish();}
                else {
    Intent intent=new Intent(SplashScreen.this,ProfileActivity.class);
    intent.putExtra("pp",n);
    startActivity(intent);
    finish();

}


            }


        }, 3000);

    }


}
