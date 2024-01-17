package model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 * Saves and loads from a JSON File and persists current Wordtrainer data after the strategy pattern
 * @author fatjon
 * @version 18-10-2023
 */
public class JsonStorageStrategy implements SessionStorageStrategy {
    /**
     * Writes all Attributes with getter Methods in json file
     * @param rechtschreibtrainer Class that is given to write in json
     * @param filePath to jsonfile
     */
    public void save(Rechtschreibtrainer rechtschreibtrainer, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File saveFile = new File(filePath);
            if(saveFile.exists()){
                saveFile.delete();
            }
            if (saveFile.createNewFile()) {
                try {
                    objectMapper.writeValue(saveFile, rechtschreibtrainer.getArrayList());
                    System.out.println("Data saved to JSON file: " + filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Error saving data to JSON file: " + filePath);
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Reads from JSON file and turns it into Wordtrainer class
     * @param filePath to readable json
     * @return generated WortTrainer object
     */
    public Rechtschreibtrainer load(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
            return objectMapper.readValue(new File(filePath), Rechtschreibtrainer.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading data from JSON file: " + filePath);
        }
        return null; // Return a new instance if the file does not exist or there's an error
    }
}