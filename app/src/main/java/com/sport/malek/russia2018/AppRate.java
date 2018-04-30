package com.sport.malek.russia2018;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by MALEK on 23/04/2018.
 */
 class AppRater {

    private final static String APP_TITLE ="Russia 2018";// App Name
    private final static String APP_PNAME = "com.sport.malek.russia2018";// Package Name

    private final static int DAYS_UNTIL_PROMPT = 3;//Min number of days
    private final static int LAUNCHES_UNTIL_PROMPT = 3;//Min number of launches

    public static void app_launched(Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("apprater", 0);
        if (prefs.getBoolean("dontshowagain", false)) { return ; }

        SharedPreferences.Editor editor = prefs.edit();

        // Increment launch counter
        long launch_count = prefs.getLong("launch_count", 0) + 1;
        editor.putLong("launch_count", launch_count);

        // Get date of first launch
        Long date_firstLaunch = prefs.getLong("date_firstlaunch", 0);
        if (date_firstLaunch == 0) {
            date_firstLaunch = System.currentTimeMillis();
            editor.putLong("date_firstlaunch", date_firstLaunch);
        }

        // Wait at least n days before opening
        if (launch_count >= LAUNCHES_UNTIL_PROMPT) {
            if (System.currentTimeMillis() >= date_firstLaunch + (DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000) ) {
                showRateDialog(mContext, editor);
            }
        }

        editor.commit();
    }

    public static void showRateDialog(final Context mContext, final SharedPreferences.Editor editor) {
        final Dialog dialog = new Dialog(mContext);
        dialog.setTitle("Rate " + APP_TITLE);
        LinearLayout ll = new LinearLayout(mContext);
        ll.setBackground(mContext.getDrawable(R.drawable.side_nav_bar));

        ll.setOrientation(LinearLayout.VERTICAL);

        TextView tv = new TextView(mContext);
        tv.setText(mContext.getString(R.string.appratemessage));
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        tv.setWidth(800);
        tv.setTextSize(20);
        tv.setTextColor(Color.WHITE);
        tv.setPadding(8, 5, 8, 5);
        ll.addView(tv);



        Button b1 = new Button(mContext);
        b1.setText(mContext.getString(R.string.Rate) + APP_TITLE);
        b1.setBackground(mContext.getDrawable(R.drawable.side_nav_bar));
        b1.setTextColor(Color.WHITE);
        b1.setPadding(2, 2, 2, 2);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME)));
                dialog.dismiss();
            }
        });
        ll.addView(b1);

        Button b2 = new Button(mContext);
        b2.setText(mContext.getString(R.string.remind));
        b2.setBackground(mContext.getDrawable(R.drawable.side_nav_bar));
        b2.setTextColor(Color.WHITE);
        b2.setPadding(2, 2, 2, 2);

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        ll.addView(b2);

        Button b3 = new Button(mContext);
        b3.setText(mContext.getString(R.string.nothanks));
        b3.setBackground(mContext.getDrawable(R.drawable.side_nav_bar));
        b3.setTextColor(Color.WHITE);
        b3.setPadding(2, 2, 2, 2);

        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (editor != null) {
                    editor.putBoolean("dontshowagain", true);
                    editor.commit();
                }
                dialog.dismiss();
            }
        });
        ll.addView(b3);

        dialog.setContentView(ll);
        dialog.show();
    }
}
