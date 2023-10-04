package view;

import model.Rechtschreibtrainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Anzeige {
    private JFrame frame;

    private Rechtschreibtrainer rechtschreibtrainer;

    public Anzeige(Rechtschreibtrainer rechtschreibtrainer) {
      this.rechtschreibtrainer = rechtschreibtrainer;
        anzeigen();
    }

    private void anzeigen() {
        frame = new JFrame("Welches Word könnte das sein?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton button = new JButton("Zeige das Bild");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for(int i = 0; i < rechtschreibtrainer.getArrayList().size();i++){
                    ImageIcon imageIcon = new ImageIcon(rechtschreibtrainer.getWortEintrag(i).getURL());
                    // Zeige das Bild in einem JoptionPane-Dialogfeld
                   String wort = (String)JOptionPane.showInputDialog(frame, new JLabel(imageIcon), "Bild von URL", JOptionPane.PLAIN_MESSAGE);
                   if(wort.equals(rechtschreibtrainer.getWortEintrag(i).getWort())){
                       rechtschreibtrainer.statistik(true);
                       JOptionPane.showMessageDialog(null,rechtschreibtrainer.printStatistik(), "Bild von URL", JOptionPane.PLAIN_MESSAGE);
                   }else{
                       rechtschreibtrainer.statistik(false);
                       JOptionPane.showMessageDialog(null,rechtschreibtrainer.printStatistik(), "Bild von URL", JOptionPane.PLAIN_MESSAGE);
                   }
                }
                frame.setVisible(false);
                // Lade das Bild von der URL
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