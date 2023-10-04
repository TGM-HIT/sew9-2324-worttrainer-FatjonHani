package controler;

import model.Rechtschreibtrainer;
import model.WortEintrag;
import model.WortSpeicher;
import org.json.JSONObject;
import view.Anzeige;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class WortMain {

    public static void main(String[] args) throws MalformedURLException {
                    // rechtrainer fragen nach zuffäligem Worteinträgen und dann anzeigen
        try {
            URL url = new URL("https://static.nationalgeographic.de/files/styles/image_3200/public/01-domesticated-dog.jpg?w=400&h=400&q=75");
            URL url1 = new URL("https://api.ardmediathek.de/image-service/images/urn:ard:image:3dab66faa8140d8b?w=448&ch=9e935de585dfb889");
            URL url2 = new URL("https://www.mpg.de/11634762/original-1639735997.jpg?t=eyJ3aWR0aCI6MzQxLCJmaWxlX2V4dGVuc2lvbiI6ImpwZyIsIm9ial9pZCI6MTE2MzQ3NjJ9--189746ec5f93cc02e4f9073e28100e3964537be1");

            WortEintrag hund = new WortEintrag(url, "Hund");
            WortEintrag kazte = new WortEintrag(url1, "Katze");
            WortEintrag maus = new WortEintrag(url2, "Maus");

            ArrayList<WortEintrag> list = new ArrayList<>();
            list.add(hund);
            list.add(kazte);

            list.add(maus);
            Rechtschreibtrainer rechtschreibtrainer = new Rechtschreibtrainer(list);

            Anzeige anzeige = new Anzeige(rechtschreibtrainer);
            anzeige.anzeige();

        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        // Beispiel für die Verwendung der WortSpeicher-Klasse
        WortSpeicher wortSpeicher = new WortSpeicher();
        wortSpeicher.addWordPair("Hund", new URL("https://static.nationalgeographic.de/files/styles/image_3200/public/01-domesticated-dog.jpg?w=400&h=400&q=75"));
        wortSpeicher.addWordPair("Katze", new URL("https://api.ardmediathek.de/image-service/images/urn:ard:image:3dab66faa8140d8b?w=448&ch=9e935de585dfb889"));
        wortSpeicher.saveSession("C:\\Users\fatjo\\OneDrive\\Desktop\5CHIT\\SEW\\Worttrainer.txt");

        // Laden der gespeicherten WortSpeicher
        WortSpeicher loadedWortSpeicher = new WortSpeicher();
        loadedWortSpeicher.loadSession("C:\\Users\\fatjo\\OneDrive\\Desktop\\5CHIT\\SEW\\Worttrainer.txt");

        // Verwendung der geladenen WortSpeicher
        JSONObject currentPair = loadedWortSpeicher.getCurrentWordPair();
        if (currentPair != null) {
            System.out.println("Aktuelles Paar: " + currentPair);
        }
    }
}
