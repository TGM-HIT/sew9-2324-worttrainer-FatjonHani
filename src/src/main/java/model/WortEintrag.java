package model;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class WortEintrag implements Serializable {

    @JsonProperty("url")
    private String url;

    @JsonProperty("wort")
    private String wort;

    /**
     * Default Consturctor with the URL of an Dog Image and the name Hund
     *
     */
    public WortEintrag() throws MalformedURLException {
        this.wort = "Hund";
        String urlGiven = "https://static.nationalgeographic.de/files/styles/image_3200/public/01-domesticated-dog.jpg?w=400&h=400&q=75";
        this.url = urlGiven ;


    }

    /**
     * Checks if the Given URL is right
     *
     * @param url the url of the Image
     * @param wort the Name of the Object in the Image
     */
    public WortEintrag(String url, String wort)  {
        setURL(url);
        setWort(wort);
    }

    /**
     * Checks if the Given URL is right
     *
     * @param urlGiven
     */
    public boolean urlChecker(String urlGiven){
        try {
            URL url = new URL(urlGiven);
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


    /**
     * gets the the Wort
     *
     *
     */
    public String getWort(){
        if(this.wort != null){
            return this.wort;
        }else {
            return "Error!";
        }
    }

    /**
     * gets the the url
     *
     *
     */
    public String getURL(){
        if(this.url != null){
            return this.url;
        }else {
            return null;
        }
    }

    /**
     * gets the the Image from the url
     *
     *
     */
    public ImageIcon getImage() {

        return new ImageIcon(url);
    }
    /**
     * sets the url Attribute
     *
     * @param url to set wort
     */
    public void setURL(String url){
        if(url != null){
             this.url = url;
        }else {
            this.url = null;
        }
    }

    /**
     * sets the Wort Attribute
     *
     * @param wort to set wort
     */
    public void setWort(String wort){
        if(wort != null){
            this.wort = wort;
        }else {
            this.wort = "Error!";
        }
    }
}