package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class JOptionPaneWithImageFromURL {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Welches Word könnte das sein?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Zeige das Bild");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // URL des Bildes
                String imageUrl = "https://www.ottoversand.at/p/71917803-0";
                try {
                    // Lade das Bild von der URL
                    ImageIcon imageIcon = new ImageIcon(new URL(imageUrl));

                    // Erstelle eine JLabel-Komponente, um das Bild anzuzeigen
                    JLabel label = new JLabel(imageIcon);

                    // Zeige das Bild in einem JOptionPane-Dialogfeld an
                    JOptionPane.showMessageDialog(
                            frame,
                            label,
                            "Bild",
                            JOptionPane.PLAIN_MESSAGE
                    );
                } catch (MalformedURLException ex) {
                    JOptionPane.showMessageDialog(frame, "Ungültige URL: " + imageUrl, "Fehler", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Fehler beim Laden des Bildes: " + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
