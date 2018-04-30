package com.sport.malek.russia2018;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by MALEK on 26/02/2018.
 */

public class ConnectiveDetector {
    Context context;

    public ConnectiveDetector(Context context) {
        this.context=context;
    }

    public boolean isConnected(){
        ConnectivityManager cm=(ConnectivityManager)context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if(cm!=null){
            NetworkInfo ni=cm.getActiveNetworkInfo();
            if(ni!=null){
                if(ni.getState()== NetworkInfo.State.CONNECTED){
                    return true;
                }
            }
        }
        return false;
    }

}
