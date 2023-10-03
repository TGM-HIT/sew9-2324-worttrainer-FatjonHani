package model;
import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class WortEintrag {
    private URL url = new URL("https://www.computerhope.com/jargon/e/error.png") ;
    private String wort;

    public WortEintrag() throws MalformedURLException {
        this.wort = "Hund";
    }
    public WortEintrag(URL url, String wort) throws MalformedURLException {
        setURL(url);
        setWort(wort);
    }

    public boolean urlChecker(String url){

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