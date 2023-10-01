package model;

import java.util.ArrayList;

public class Rechtschreibtrainer {
    private ArrayList<WortEintrag> wortPaar;
    private int richtig = 0;
    private int falsch = 0;

    public Rechtschreibtrainer(ArrayList wortPaar) {
        wortPaar = new ArrayList();

    }
    public void statistik(boolean answer){
        if(answer == true){
            this.richtig++;
        }else {
            this.falsch++;
        }
    }
    public String printStatistik(){
        return "Sie Haben: "+this.richtig+" richtig erraten! " +"/n"
                +"Sie Haben: "+this.falsch+" falsch erraten!";
    }

    public WortEintrag training(int index){

        return null;

    }


}
