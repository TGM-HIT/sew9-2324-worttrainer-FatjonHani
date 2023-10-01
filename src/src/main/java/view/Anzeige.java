package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Anzeige {
    private JFrame frame;
    private URL imageUrl;

    public Anzeige(URL imageUrl) {
        this.imageUrl = imageUrl;
        anzeigen();
    }

    private void anzeigen() {
        frame = new JFrame("Welches Word könnte das sein?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton button = new JButton("Zeige das Bild");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lade das Bild von der URL
                ImageIcon imageIcon = new ImageIcon(imageUrl);

                // Zeige das Bild in einem JoptionPane-Dialogfeld
                JOptionPane.showInputDialog(
                        frame,
                        new JLabel(imageIcon),
                        "Bild von URL",
                        JOptionPane.PLAIN_MESSAGE
                );
            }
        });
        frame.add(button);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
    }

    public void anzeige(){
        frame.setVisible(true);
    }
}