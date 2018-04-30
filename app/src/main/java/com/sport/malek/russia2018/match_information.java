package com.sport.malek.russia2018;

/**
 * Created by MALEK on 25/03/2018.
 */

public class match_information {
    int away_team;
    String date;
    boolean finished;
    int home_team;
    int stadium;
    String type;
    String date1;
    String time;


    public match_information() {
    }

    public match_information(int away_team, String date, boolean finished, int home_team, int stadium, String type,String date1,String time) {

        this.away_team = away_team;
        this.date = date;
        this.finished = finished;
        this.home_team = home_team;
        this.stadium = stadium;
        this.type = type;
        this.date1=date1;
        this.time=time;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAway_team() {
        return away_team;
    }

    public void setAway_team(int away_team) {
        this.away_team = away_team;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getHome_team() {
        return home_team;
    }

    public void setHome_team(int home_team) {
        this.home_team = home_team;
    }

    public int getStadium() {
        return stadium;
    }

    public void setStadium(int stadium) {
        this.stadium = stadium;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
