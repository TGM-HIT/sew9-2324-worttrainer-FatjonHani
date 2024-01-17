package model;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Random;

/**
 * speichert eine Arrayliste von Worteinträgen und eine speicher strategy
 * und verwaltet eine Statistik
 *
 * @author fatjon
 * @version 18-10-2023
 */
public class Rechtschreibtrainer {

    @JsonProperty("wortPaar")
    private ArrayList<WortEintrag> wortPaar;

    @JsonProperty("richtig")
    private int richtig = 0;


    @JsonProperty("falsch")
    private int falsch = 0;

    private SessionStorageStrategy saveStrategy;

    /**
     * constructor namens Rechtschreibtrainer der mir eine Liste von WortEinträgen speichert
     * und eine SessionStorageStrategy die deffiniert in welcher form das Object gespeichert wird.
     *
     */
    public Rechtschreibtrainer(ArrayList wortPaar, SessionStorageStrategy saveStrategy) {
        this.wortPaar = wortPaar;
        this.saveStrategy = saveStrategy;
    }

    /**
     * statistik counts me the current number of right and false guessed words
     *
     *
     */
    public void statistik(boolean answer){
        if(answer == true){
            this.richtig++;
        }else {
            this.falsch++;
        }
    }
    /**
     * printStatistik prints me the current number of right and false guessed words
     *
     *
     */
    public String printStatistik(){
        return "Sie Haben: "+this.richtig+" richtig erraten! "
                +"Sie Haben: "+this.falsch+" falsch erraten!";
    }
    /**
     * getWortEintragZufall Gives me the an Random WortEintra from
     * The current ArrayList
     *
     */
    public WortEintrag getWortEintrag(int index){
         return this.wortPaar.get(index);
    }

    /**
     * getWortEintragZufall Gives me the an Random WortEintra from
     * The current ArrayList
     *
     */
    public WortEintrag getWortEintragZufall(){
       int index;
       Random random = new Random();
       index = random.nextInt(wortPaar.size());
       return this.wortPaar.get(index);
    }

    /**
     * Gives me the current ArrayList
     *
     *
     */
    public ArrayList getArrayList(){
        return this.wortPaar;
    }

    /**
     * Saves data with current Presistence strategy
     *
     * @param filePath to savefile location
     */
    public void saveData(String filePath) {
        String response ="";
        if ( saveStrategy != null) {
            saveStrategy.save(this, filePath);
            response = "file saved at this filepath:"+filePath;
        } else {
            response ="Persistence strategy not set. Data not saved.";
            System.err.println(response);
        }
    }
}