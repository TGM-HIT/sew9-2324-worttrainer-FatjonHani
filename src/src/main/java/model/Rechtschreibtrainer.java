package model;

import java.util.ArrayList;
import java.util.Random;

public class Rechtschreibtrainer {
    private ArrayList<WortEintrag> wortPaar;
    private int richtig = 0;
    private int falsch = 0;

    public Rechtschreibtrainer(ArrayList wortPaar) {
        this.wortPaar = wortPaar;

    }
    public void statistik(boolean answer){
        if(answer == true){
            this.richtig++;
        }else {
            this.falsch++;
        }
    }
    public String printStatistik(){
        return "Sie Haben: "+this.richtig+" richtig erraten! "
                +"Sie Haben: "+this.falsch+" falsch erraten!";
    }

    public WortEintrag getWortEintrag(int index){
         return this.wortPaar.get(index);
    }

    public WortEintrag getWortEintragZufall(){
       int index;
       Random random = new Random();
       index = random.nextInt(wortPaar.size() - 0) +0;
       return this.wortPaar.get(index);
    }

    public ArrayList getArrayList(){
        return this.wortPaar;
    }


}
