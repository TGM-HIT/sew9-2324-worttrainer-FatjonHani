package model;


import org.json.*;
import java.io.FileWriter;
import java.io.IOException;
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
    public void addWordPair(String word, String image) {
        JSONObject pair = new JSONObject();
        pair.put("word", word);
        pair.put("image", image);
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

    public static void main(String[] args) {
        // Beispiel für die Verwendung der WortSpeicher-Klasse
        WortSpeicher wortSpeicher = new WortSpeicher();
        wortSpeicher.addWordPair("Apfel", "apfel.jpg");
        wortSpeicher.addWordPair("Banane", "banane.jpg");
        wortSpeicher.saveSession("wortSpeicher.json");

        // Laden der gespeicherten WortSpeicher
        WortSpeicher loadedWortSpeicher = new WortSpeicher();
        loadedWortSpeicher.loadSession("wortSpeicher.json");

        // Beispiel für die Verwendung der geladenen WortSpeicher
        JSONObject currentPair = loadedWortSpeicher.getCurrentWordPair();
        if (currentPair != null) {
            System.out.println("Aktuelles Paar: " + currentPair);
        }
    }
}
