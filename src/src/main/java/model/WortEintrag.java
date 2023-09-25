package model;

public class WortEintrag {
    private String url;
    private String wort;

    public WortEintrag(){
        this.url =" ";
        this.wort = "Hund";
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

    public String getURL(){
        if(this.url != null){
            return this.wort;
        }else {
            return "Error!";
        }
    }

    public void setURL(String url){
        if(url != null){
             this.url = url;
        }else {
            this.url = "Error!";
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
