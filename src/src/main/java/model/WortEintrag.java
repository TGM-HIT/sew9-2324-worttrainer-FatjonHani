package model;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.swing.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class WortEintrag {

    @JsonProperty("url")
    private URL url = new URL("https://www.computerhope.com/jargon/e/error.png") ;

    @JsonProperty("wort")
    private String wort;

    public WortEintrag() throws MalformedURLException {
        this.wort = "Hund";
    }
    public WortEintrag(URL url, String wort) throws MalformedURLException {
        setURL(url);
        setWort(wort);
    }

    public boolean urlChecker(){
        String urlToCheck = "https://www.example.com"; // Replace with the URL you want to check
        try {
            URL url = new URL(urlToCheck);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("URL is valid and accessible.");
            } else {
                System.out.println("URL is not accessible. HTTP Response Code: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println("URL is not valid or an error occurred: " + e.getMessage());
        }
        return false;
    }

    public String getWort(){

        if(this.wort != null){
            return this.wort;
        }else {
            return "Error!";
        }
    }

    public URL getURL(){
        if(this.url != null){
            return this.url;
        }else {
            return null;
        }
    }
    public ImageIcon getImage() throws IOException {
        return new ImageIcon(url);
    }

    public void setURL(URL url){
        if(url != null){
             this.url = url;
        }else {
            this.url = null;
        }
    }

    public void setWort(String wort){
        if(wort != null){
            this.wort = wort;
        }else {
            this.wort = "Error!";
        }
    }
}