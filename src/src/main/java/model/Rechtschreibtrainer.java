package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Random;

public class Rechtschreibtrainer {

    @JsonProperty("wortPaar")
    private ArrayList<WortEintrag> wortPaar;

    @JsonProperty("richtig")
    private int richtig = 0;

    @JsonProperty("falsch")
    private int falsch = 0;

    private SessionStorageStrategy saveStrategy;
    public Rechtschreibtrainer(ArrayList wortPaar, SessionStorageStrategy saveStrategy) {
        this.wortPaar = wortPaar;
        this.saveStrategy = saveStrategy;
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
       index = random.nextInt(wortPaar.size());
       return this.wortPaar.get(index);
    }
    public ArrayList getArrayList(){
        return this.wortPaar;
    }

    /**
     * Saves data with current Presistence strategy
     * @param filePath to savefile location
     */
    public String saveData(String filePath) {
        String response="";
        if (saveStrategy != null) {
            saveStrategy.save(this, filePath);
            response= "file saved at this filepath:"+filePath;
        } else {
            response ="Persistence strategy not set. Data not saved.";
            System.err.println(response);
        }
        return response;
    }
}