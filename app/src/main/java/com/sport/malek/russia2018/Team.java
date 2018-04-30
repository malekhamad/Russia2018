package com.sport.malek.russia2018;

/**
 * Created by MALEK on 03/12/2017.
 */

public class Team {
    int Name;
    int ImageResourceId;
    int ImageTeamId;
    int description;
    int bestPlayer;
    int appearances;
    int final_match;
    int ranking;

    public static final Team[]team={
                new Team(R.string.argentina,R.drawable.argentina,R.drawable.arg,R.string.arg_description,R.string.arg_players,16,5,4),//0              // appearance , final , ranking
                new Team(R.string.australia,R.drawable.australia,R.drawable.aus,R.string.aus_description,R.string.aus_players,4,0,39),//1
                new Team(R.string.brazil,R.drawable.brazil,R.drawable.bra,R.string.bra_description,R.string.bra_players,20,7,2),//2
                new Team(R.string.belgium,R.drawable.bulgiam,R.drawable.bel,R.string.bel_description,R.string.bel_Players,12,0,5),//3
                new Team(R.string.colombia,R.drawable.colombia,R.drawable.col,R.string.col_description,R.string.col_players,5,0,13),//4
                new Team(R.string.costarica,R.drawable.costarica,R.drawable.costa,R.string.costa_description,R.string.costa_players,4,0,26),//5
                new Team(R.string.danmark,R.drawable.danimark,R.drawable.den,R.string.den_description,R.string.den_players,4,0,12),//6
                new Team(R.string.egypt,R.drawable.egypt,R.drawable.egy,R.string.egy_description,R.string.egy_players,2,0,31),//7
                new Team(R.string.england,R.drawable.england,R.drawable.eng,R.string.eng_description,R.string.eng_players,14,1,15),//8
                new Team(R.string.france,R.drawable.france,R.drawable.fra,R.string.fra_description,R.string.fra_players,14,2,9),//9
                new Team(R.string.germany,R.drawable.germany,R.drawable.ger,R.string.ger_description,R.string.ger_players,18,8,1),//10
                new Team(R.string.iran,R.drawable.iran,R.drawable.ira,R.string.ira_description,R.string.ira_players,4,0,32),//11
                new Team(R.string.island,R.drawable.island,R.drawable.ice,R.string.ice_description,R.string.ice_players,0,0,22),//12
                new Team(R.string.japan,R.drawable.japan,R.drawable.jap,R.string.jap_description,R.string.jap_players,5,0,55),//13
                new Team(R.string.coroatia,R.drawable.koroatia,R.drawable.cro,R.string.cro_description,R.string.cro_players,4,0,17),//14
                new Team(R.string.mexico,R.drawable.mexico,R.drawable.mex,R.string.mex_description,R.string.mex_players,15,0,16),//15
                new Team(R.string.moroco,R.drawable.moroco,R.drawable.mor,R.string.mor_description,R.string.mor_players,4,0,40),//16
                new Team(R.string.nigeria,R.drawable.nigeria,R.drawable.nig,R.string.nig_description,R.string.nig_players,5,0,50),//17
                new Team(R.string.panama,R.drawable.panama,R.drawable.pan,R.string.pan_description,R.string.pan_players,0,0,56),//18
                new Team(R.string.peru,R.drawable.peru,R.drawable.per,R.string.per_description,R.string.per_players,4,0,11),//19
                new Team(R.string.poland,R.drawable.poland,R.drawable.pol,R.string.pol_description,R.string.pol_players,7,0,7),//20
                new Team(R.string.portogal,R.drawable.portugal,R.drawable.por,R.string.por_description,R.string.por_players,6,0,3),//21
                new Team(R.string.russiaa,R.drawable.russia,R.drawable.rus,R.string.rus_description,R.string.rus_players,10,0,65),//22
                new Team(R.string.saudi,R.drawable.saudi,R.drawable.sau,R.string.sau_description,R.string.sau_players,4,0,63),//23
                new Team(R.string.senegal,R.drawable.senegal,R.drawable.sen,R.string.sen_description,R.string.sen_players,1,0,23),//24
                new Team(R.string.serbia,R.drawable.serbia,R.drawable.ser,R.string.ser_description,R.string.ser_players,11,0,37),//25
                new Team(R.string.southkora,R.drawable.southkorea,R.drawable.sou,R.string.sou_description,R.string.sou_players,9,0,59),//26
                new Team(R.string.spain,R.drawable.spain,R.drawable.spa,R.string.spa_description,R.string.spa_players,14,1,6),//27
                new Team(R.string.sweden,R.drawable.sweden,R.drawable.swe,R.string.swe_description,R.string.swe_players,11,1,18),//28
                new Team(R.string.switzerland,R.drawable.switzerland,R.drawable.swi,R.string.swi_description,R.string.swi_players,10,0,8),//29
                new Team(R.string.tunisa,R.drawable.tunisia,R.drawable.tun,R.string.tun_description,R.string.tun_players,4,0,27),//30
                new Team(R.string.uruguay,R.drawable.uruguay,R.drawable.uru,R.string.uru_description,R.string.uru_players,12,2,21)//31

    };

    public Team(int Name, int ImageResourceId, int imageTeamId, int description, int bestPlayer,int appearances,int final_match,int ranking) {
        this.Name=Name;
        this.ImageResourceId=ImageResourceId;
        this.ImageTeamId=imageTeamId;
        this.description=description;
        this.bestPlayer=bestPlayer;
        this.appearances=appearances;
        this.final_match=final_match;
        this.ranking=ranking;
    }

    public int getAppearances() {
        return appearances;
    }

    public int getFinal_match() {
        return final_match;
    }

    public int getRanking() {
        return ranking;
    }

    public int getDescription() {
        return description;
    }

    public int getBestPlayer() {
        return bestPlayer;
    }

    public int getName() {
        return Name;
    }

    public int getImageTeamId() {
        return ImageTeamId;
    }

    public int getImageResourceId() {
        return ImageResourceId;
    }



}
