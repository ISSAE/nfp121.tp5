package question2;

import javax.swing.*;
import java.util.*;

public class IHMListe extends JFrame {
    public IHMListe() {
        super("IHM Liste");
        List<String> liste = Chapitre2CoreJava2.listeDesMots();
        Map<String, Integer> table = Chapitre2CoreJava2.occurrencesDesMots(liste);
        JPanelListe jPanelListe = new JPanelListe(liste, table);
        add(jPanelListe);
        setLocation(100,100);
        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        new IHMListe();
    }

}
