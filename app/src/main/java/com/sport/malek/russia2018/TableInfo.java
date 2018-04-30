package com.sport.malek.russia2018;

/**
 * Created by MALEK on 05/03/2018.
 */

public class TableInfo {
    int Play;
    int Point;
    int Win;
    int imgid;

    public TableInfo() {
    }

    public TableInfo(int Play, int Point, int Win, int Imgid) {
       this.Play = Play;
        this.Point = Point;
        this.Win = Win;
        this.imgid = Imgid;
    }

    public int getPlay() {
        return Play;
    }

    public int getCount() {
        return Win;
    }

    public void setCount(int count) {
        this.Win = count;
    }

    public void setPlay(int play) {
        Play = play;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int point) {
        Point = point;
    }


    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}
