package com.sport.malek.russia2018;

/**
 * Created by MALEK on 14/04/2018.
 */

public class Stadium_information {
    int Name;
    int Capacity;
    int Location ;
    int Opening ;
    int imgres;

    public static final Stadium_information[]stadium={
            new Stadium_information(R.string.Luzhniki_Stadium,R.string.luzhniki_capacity,R.string.luzhiniki_location,R.string.luzhiniki_opening,R.drawable.lushniki),//0
            new Stadium_information(R.string.otkrytiye_stadium,R.string.otkrytiye_capacity,R.string.otkrytiye_location,R.string.otkrytiye_opening,R.drawable.otkritie),//1
            new Stadium_information(R.string.krestovsky_stadium,R.string.krestovsky_capacity,R.string.krestovsky_location,R.string.krestovsky_opening,R.drawable.saint_petersburg),//2
            new Stadium_information(R.string.kaliningrad_stadium,R.string.kaliningrad_capacity,R.string.kaliningrad_location,R.string.kaliningrad_opening,R.drawable.kaliningrad),//3
            new Stadium_information(R.string.kazan_stadium,R.string.kazan_capacity,R.string.kazan_location,R.string.kazan_opening,R.drawable.kazan),//4
            new Stadium_information(R.string.nizhny_stadium,R.string.nizhny_capacity,R.string.nizhny_location,R.string.nizhny_opening,R.drawable.nazhny),//5
            new Stadium_information(R.string.cosmos_stadium,R.string.cosmos_capacity,R.string.cosmos_location,R.string.cosmos_opening,R.drawable.samara),//6
            new Stadium_information(R.string.volgograd_stadium,R.string.volgograd_capacity,R.string.volgograd_location,R.string.volgograd_opening,R.drawable.volgograd),//7
            new Stadium_information(R.string.mordovia_stadium,R.string.mordovia_capacity,R.string.mordovia_location,R.string.mordovia_opening,R.drawable.sarnask),//8
            new Stadium_information(R.string.rostov_stadium,R.string.rostov_capacity,R.string.rostov_location,R.string.rostov_opening,R.drawable.rostov),//9
            new Stadium_information(R.string.fisht_stadium,R.string.fisht_capacity,R.string.fisht_location,R.string.fisht_opening,R.drawable.soshi),//10
            new Stadium_information(R.string.ekaterinburg_stadium,R.string.ekaterinburg_capacity,R.string.ekaterinburg_location,R.string.ekaterinburg_opening,R.drawable.ekaterinburg)//11

    };

    public Stadium_information(int Name, int Capacity, int Location, int Opening, int imgres) {
     this.Name=Name;
     this.Capacity=Capacity;
     this.Location=Location;
     this.Opening=Opening;
     this.imgres=imgres;
    }

    public int getImgres() {
        return imgres;
    }

    public void setImgres(int imgres) {
        this.imgres = imgres;
    }

    public int getName() {
        return Name;
    }

    public void setName(int name) {
        Name = name;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public int getLocation() {
        return Location;
    }

    public void setLocation(int location) {
        Location = location;
    }

    public int getOpening() {
        return Opening;
    }

    public void setOpening(int opening) {
        Opening = opening;
    }
}
