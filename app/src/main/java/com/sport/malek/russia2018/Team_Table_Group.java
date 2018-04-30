package com.sport.malek.russia2018;

/**
 * Created by MALEK on 13/01/2018.
 */

public class Team_Table_Group {
    int namef,imgId,p,w,d,l,pt;

    // put data in group_a Object ........ ;
    public static Team_Table_Group[]group_A={
            new Team_Table_Group(R.string.russiaa,R.drawable.russia,0,0,0,0,0),
            new Team_Table_Group(R.string.saudi,R.drawable.saudi,0,0,0,0,0),
            new Team_Table_Group(R.string.egypt,R.drawable.egypt,0,0,0,0,0),
            new Team_Table_Group(R.string.uruguay,R.drawable.uruguay,0,0,0,0,0)
    };

    // put data in group_b Object ...... ;
    public static  Team_Table_Group[]group_B={
            new Team_Table_Group(R.string.portogal,R.drawable.portugal,0,0,0,0,0),
            new Team_Table_Group(R.string.spain,R.drawable.spain,0,0,0,0,0),
            new Team_Table_Group(R.string.moroco,R.drawable.moroco,0,0,0,0,0),
            new Team_Table_Group(R.string.iran,R.drawable.iran,0,0,0,0,0)
    };
    // put data in group_c Object ...... ;
    public static  Team_Table_Group[]group_C={
            new Team_Table_Group(R.string.france,R.drawable.france,0,0,0,0,0),
            new Team_Table_Group(R.string.australia,R.drawable.australia,0,0,0,0,0),
            new Team_Table_Group(R.string.peru,R.drawable.peru,0,0,0,0,0),
            new Team_Table_Group(R.string.danmark,R.drawable.danimark,0,0,0,0,0)
    };
    // put data in group_D Object ...... ;
    public static  Team_Table_Group[]group_D={
            new Team_Table_Group(R.string.argentina,R.drawable.argentina,0,0,0,0,0),
            new Team_Table_Group(R.string.island,R.drawable.island,0,0,0,0,0),
            new Team_Table_Group(R.string.coroatia,R.drawable.koroatia,0,0,0,0,0),
            new Team_Table_Group(R.string.nigeria,R.drawable.nigeria,0,0,0,0,0)
    };
    // put data in group_e Object ...... ;
    public static  Team_Table_Group[]group_E={
            new Team_Table_Group(R.string.brazil,R.drawable.brazil,0,0,0,0,0),
            new Team_Table_Group(R.string.switzerland,R.drawable.switzerland,0,0,0,0,0),
            new Team_Table_Group(R.string.costarica,R.drawable.costarica,0,0,0,0,0),
            new Team_Table_Group(R.string.serbia,R.drawable.serbia,0,0,0,0,0)
    };

    // put data in group_F Object ...... ;
    public static  Team_Table_Group[]group_F={
            new Team_Table_Group(R.string.germany,R.drawable.germany,0,0,0,0,0),
            new Team_Table_Group(R.string.mexico,R.drawable.mexico,0,0,0,0,0),
            new Team_Table_Group(R.string.sweden,R.drawable.sweden,0,0,0,0,0),
            new Team_Table_Group(R.string.southkora,R.drawable.southkorea,0,0,0,0,0)
    };

    // put data in group_G Object ...... ;
    public static  Team_Table_Group[]group_G={
            new Team_Table_Group(R.string.belgium,R.drawable.bulgiam,0,0,0,0,0),
            new Team_Table_Group(R.string.panama,R.drawable.panama,0,0,0,0,0),
            new Team_Table_Group(R.string.tunisa,R.drawable.tunisia,0,0,0,0,0),
            new Team_Table_Group(R.string.england,R.drawable.england,0,0,0,0,0)
    };

    // put data in group_H Object ...... ;
    public static  Team_Table_Group[]group_H={
            new Team_Table_Group(R.string.poland,R.drawable.poland,0,0,0,0,0),
            new Team_Table_Group(R.string.senegal,R.drawable.senegal,0,0,0,0,0),
            new Team_Table_Group(R.string.colombia,R.drawable.colombia,0,0,0,0,0),
            new Team_Table_Group(R.string.japan,R.drawable.japan,0,0,0,0,0)
    };

   // Create Custructor to pass data ....... ;
    public Team_Table_Group(int namef, int imgId, int p, int w, int d, int l, int pt) {
        this.namef=namef;
        this.imgId=imgId;
        this.p=p;
        this.w=w;
        this.d=d;
        this.l=l;
        this.pt=pt;
    }



    //Getter Method to get Data from this object ........ ;
    public int getNamef() {
        return namef;
    }

    public int getImgId() {
        return imgId;
    }

    public int getP() {
        return p;
    }

    public int getW() {
        return w;
    }

    public int getD() {
        return d;
    }

    public int getL() {
        return l;
    }

    public int getPt() {
        return pt;
    }

    //Setter Method to set data from firebase ..... ;


    public void setNamef(int namef) {
        this.namef = namef;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setP(int p) {
        this.p = p;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void setL(int l) {
        this.l = l;
    }

    public void setPt(int pt) {
        this.pt = pt;
    }
}
