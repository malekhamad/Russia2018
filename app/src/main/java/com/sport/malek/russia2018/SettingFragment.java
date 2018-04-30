package com.sport.malek.russia2018;


import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {
    View view;
    TextView textteam,textabout,textshare;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_setting, container, false);

        textshare=(TextView)view.findViewById(R.id.settingShare);
        textteam=(TextView)view.findViewById(R.id.settingPictyourteam);
        textabout=(TextView)view.findViewById(R.id.settingabout);




selectTeam();
selectAbout();
selectShare();






        return view;
    }


// when click in about .....  ;
    private void selectAbout() {
   textabout.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           AlertDialog.Builder dialog=new AlertDialog.Builder(getActivity(),R.style.Theme_AppCompat_DayNight_Dialog_MinWidth);
           dialog.setMessage(getResources().getString(R.string.aboutdesc)+"\n"+"\n"+getString(R.string.appdeveloper)+" "+getString(R.string.malek)+"\n"+getString(R.string.release)+" "+getString(R.string.releasenumber))
                   .setTitle(getResources().getString(R.string.about))
                   .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           dialog.cancel();
                       }
                   });
           AlertDialog alert=dialog.create();
           alert.show();
       }
   });
    }

    // when click in select item ...... ;
    private void selectTeam(){
        textteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ChooseTeam.class);
                startActivity(intent);
            }
        });
    }

    //when click in share button .... ;
    private void selectShare(){
        textshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,getString(R.string.applicationPath));
                startActivity(Intent.createChooser(intent,"Share Using ..."));
            }
        });
    }



}
