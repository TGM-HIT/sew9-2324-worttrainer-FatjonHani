package model;

import org.json.*;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;


public class WortSpeicher {
    private JSONArray wordPairs;
    private JSONObject currentPair;
    private JSONObject statistics;

    // Konstruktor
    public WortSpeicher() {
        wordPairs = new JSONArray();
        currentPair = null;
        statistics = new JSONObject();
    }

    // Methoden zum Hinzufügen und Abrufen von Wort-Bild-Paaren
    public void addWordPair(String word, URL image) {
        JSONObject pair = new JSONObject();
        pair.put("Hund", word);
        pair.put("https://static.nationalgeographic.de/files/styles/image_3200/public/01-domesticated-dog.jpg?w=400&h=400&q=75", image);
        wordPairs.put(pair);
    }

    public JSONObject getCurrentWordPair() {
        return currentPair;
    }

    // Methoden zum Speichern und Laden der WortSpeicher
    public void saveSession(String filePath) {
        JSONObject sessionData = new JSONObject();
        sessionData.put("wordPairs", wordPairs);
        sessionData.put("currentPair", currentPair);
        sessionData.put("statistics", statistics);

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(sessionData.toString());
            System.out.println("WortSpeicher erfolgreich gespeichert.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadSession(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject sessionData = new JSONObject(content);

            wordPairs = sessionData.getJSONArray("wordPairs");
            currentPair = sessionData.getJSONObject("currentPair");
            statistics = sessionData.getJSONObject("statistics");

            System.out.println("WortSpeicher erfolgreich geladen.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
