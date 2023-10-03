package view;

import model.Rechtschreibtrainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Anzeige {
    private JFrame frame;

  private Rechtschreibtrainer rechtschreibtrainer ;

    public Anzeige(Rechtschreibtrainer rechtschreibtrainer) {
       this.rechtschreibtrainer = rechtschreibtrainer;
    }

    private void anzeigen() {
        frame = new JFrame("Welches Word könnte das sein?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Zeige das Bild");
        button.addActionListener(new ActionListener() {
            private String wort;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Lade das Bild von der URL
                ImageIcon imageIcon = new ImageIcon(imageUrl);

                // Zeige das Bild in einem JoptionPane-Dialogfeld
                String wort = (String) JOptionPane.showInputDialog(frame,"Antwort eingeben", "Bild von URL", JOptionPane.PLAIN_MESSAGE,imageIcon,null,null);

                this.wort = wort;
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