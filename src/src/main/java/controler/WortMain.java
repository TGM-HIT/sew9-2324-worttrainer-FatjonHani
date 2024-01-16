package controler;

import model.*;
import view.Anzeige;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class WortMain {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://static.nationalgeographic.de/files/styles/image_3200/public/01-domesticated-dog.jpg?w=400&h=400&q=75");
        URL url1 = new URL("https://api.ardmediathek.de/image-service/images/urn:ard:image:3dab66faa8140d8b?w=448&ch=9e935de585dfb889");
        URL url2 = new URL("https://www.mpg.de/11634762/original-1639735997.jpg?t=eyJ3aWR0aCI6MzQxLCJmaWxlX2V4dGVuc2lvbiI6ImpwZyIsIm9ial9pZCI6MTE2MzQ3NjJ9--189746ec5f93cc02e4f9073e28100e3964537be1");

        WortEintrag hund = new WortEintrag(url, "Hund");
        WortEintrag katze = new WortEintrag(url1, "Katze");
        WortEintrag maus = new WortEintrag(url2, "Maus");

        ArrayList<WortEintrag> list = new ArrayList<>();
        list.add(hund);
        list.add(katze);
        list.add(maus);


        JsonStorageStrategy speicherStrategie = new JsonStorageStrategy();
        Rechtschreibtrainer rechtschreibtrainer = new Rechtschreibtrainer(list,speicherStrategie);
        Anzeige anzeige = new Anzeige(rechtschreibtrainer);
        anzeige.anzeige();
        System.out.println("anzeige beendet");

        rechtschreibtrainer.saveData("C:\\Users\\fatjo\\intellij-workspace\\sew9-2324-worttrainer-FatjonHani\\src\\src\\save.json");
        System.out.println("speichern beendet");
    }
}