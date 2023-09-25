package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.net.URI;

public class Visualisierung {

    public static void main(String[] args){

        JFrame frame = new JFrame("Erratedas nächste Beispiel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Öffne URL");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // URL, die geöffnet werden soll
                String url = "https://image.vip.de/23271356/t/8h/v2/w960/r0/-/ryan-gosling-t2607-jpg--topic-image-2607-.jpg";

                // Versuchen Sie, die URL zu öffnen
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Fehler beim Öffnen der URL: " + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setVisible(true);

    }
}
