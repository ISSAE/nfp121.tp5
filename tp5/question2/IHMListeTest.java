package question2;

import java.awt.Robot;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Random;
import java.applet.*;
import java.beans.*;
import java.net.*;
import java.io.*;

public class IHMListeTest extends junit.framework.TestCase{
    private static Random random= new Random();

    private JFrame f;
    private Robot robot;

    protected void setUp() throws java.lang.Exception{
        f = new IHMListe();
        f.pack();
        f.setVisible(true);
        while(!(f.isShowing())){}
        f.setAlwaysOnTop(true);
        f.setLocation(random.nextInt(300), random.nextInt(300));

        robot = new Robot();
        robot.delay(100);
    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    protected void tearDown(){ // throws java.lang.Exception
        f.dispose();
    }

    public void test_IHMListe_rechercher() {
        try{
            Container panel = f.getContentPane();
            Component[] components = panel.getComponents();
            assertEquals("IHM modifiée !!!", components.length, 1);

            // 		// la bonne IHM
            assertTrue(components[0] instanceof JPanel);
            Component[] subComponents = ((JPanel)components[0]).getComponents();

            assertTrue("IHM modifiée, voir JPanel cmd !!!", subComponents[0] instanceof JPanel);// cmd
            assertTrue("IHM modifiée, voir TextArea cmd !!!", subComponents[1] instanceof TextArea);// texte

            Component[] subSubComponents = ((JPanel)subComponents[0]).getComponents();
            assertTrue("IHM modifiée, voir JLabel afficheur !!!", subSubComponents[0] instanceof JLabel);// afficheur
            assertTrue("IHM modifiée, voir JTextField saisie !!!", subSubComponents[1] instanceof JTextField);// saisie
            assertTrue("IHM modifiée, voir JPanel boutons !!!", subSubComponents[2] instanceof JPanel);// boutons

            Component[] boutons = ((JPanel)subSubComponents[2]).getComponents();
            assertTrue("IHM modifiée, voir JButton boutonRechercher !!!", boutons[0] instanceof JButton);// boutonRechercher
            assertTrue("IHM modifiée, voir JButton boutonRetirer !!!", boutons[1] instanceof JButton);// boutonRetirer
            assertTrue("IHM modifiée, voir JLabel !!!", boutons[2] instanceof JLabel);// 
            assertTrue("IHM modifiée, voir Checkbox croissant !!!", boutons[3] instanceof Checkbox);// croissant
            assertTrue("IHM modifiée, voir Checkbox decroissant !!!", boutons[4] instanceof Checkbox);// decroissant

            //Rechercher("Java");
            JTextField saisie = (JTextField)subSubComponents[1];
            saisie.setText("Java");

            JButton button = ((JButton)boutons[0]);
            button.doClick();

            JLabel res = (JLabel)subSubComponents[0];
            assertTrue("\"Java\" doit être présent !!!",res.getText().endsWith("true"));

            //Rechercher("Java");
            saisie = (JTextField)subSubComponents[1];
            saisie.setText("Java2");

            button.doClick();

            res = (JLabel)subSubComponents[0];
            assertTrue("\"Java2\" doit être absent !!!", res.getText().endsWith("false"));

        }catch(NoSuchMethodError e){
            fail("exception inattendue ! " + e.getClass().getName());
        }catch(Exception e){
            fail("exception inattendue ! " + e.getClass().getName());
        }
    }

    public void test_IHM_occurrence() {
        try{
            Container panel = f.getContentPane();
            Component[] components = panel.getComponents();
            assertEquals(components.length, 1);

            // 		// la bonne IHM
            assertTrue(components[0] instanceof JPanel);
            Component[] subComponents = ((JPanel)components[0]).getComponents();

            assertTrue(subComponents[0] instanceof JPanel);// cmd
            assertTrue(subComponents[1] instanceof TextArea);// texte

            Component[] subSubComponents = ((JPanel)subComponents[0]).getComponents();
            assertTrue(subSubComponents[0] instanceof JLabel);// afficheur
            assertTrue(subSubComponents[1] instanceof JTextField);// saisie
            assertTrue(subSubComponents[2] instanceof JPanel);// boutons

            Component[] boutons = ((JPanel)subSubComponents[2]).getComponents();
            assertTrue(boutons[0] instanceof JButton);// boutonRechercher
            assertTrue(boutons[1] instanceof JButton);// boutonRetirer
            assertTrue(boutons[2] instanceof JLabel);// 
            assertTrue(boutons[3] instanceof Checkbox);// croissant
            assertTrue(boutons[4] instanceof Checkbox);// decroissant
            assertTrue(boutons[5] instanceof JButton);// occurrence

            //Rechercher("Java");
            JTextField saisie = (JTextField)subSubComponents[1];
            saisie.setText("you");

            JButton button = ((JButton)boutons[5]);
            button.doClick();

            JLabel res = (JLabel)subSubComponents[0];
            Scanner sc = new Scanner(res.getText());
            assertEquals("--> est attendu ???","-->",sc.next());

            try{
                int leNombre = sc.nextInt();
                assertEquals(" Nombre d'occurrence de you est-il erroné ???",36,leNombre);
            }catch(InputMismatchException ime){
                fail("--> N, N : un entier est attendu ???");
            }

      
        }catch(NoSuchMethodError e){
            fail("exception inattendue ! " + e.getClass().getName());
        }catch(Exception e){
            fail("exception inattendue ! " + e.getClass().getName());
        }
    }

   

    public void test_IHMListe_retirer() {
        try{
            Container panel = f.getContentPane();
            Component[] components = panel.getComponents();
            assertEquals(components.length, 1);

            // 		// la bonne IHM
            assertTrue(components[0] instanceof JPanel);
            Component[] subComponents = ((JPanel)components[0]).getComponents();

            assertTrue(subComponents[0] instanceof JPanel);// cmd
            assertTrue(subComponents[1] instanceof TextArea);// texte

            Component[] subSubComponents = ((JPanel)subComponents[0]).getComponents();
            assertTrue(subSubComponents[0] instanceof JLabel);// afficheur
            assertTrue(subSubComponents[1] instanceof JTextField);// saisie
            assertTrue(subSubComponents[2] instanceof JPanel);// boutons

            Component[] boutons = ((JPanel)subSubComponents[2]).getComponents();
            assertTrue(boutons[0] instanceof JButton);// boutonRechercher
            assertTrue(boutons[1] instanceof JButton);// boutonRetirer
            assertTrue(boutons[2] instanceof JLabel);// 
            assertTrue(boutons[3] instanceof Checkbox);// croissant
            assertTrue(boutons[4] instanceof Checkbox);// decroissant

            JTextField saisie = (JTextField)subSubComponents[1];
            saisie.setText("you");

            Point location = boutons[1].getLocationOnScreen();
            mouseMoveAndClick(location.x+(boutons[1].getWidth()/2),location.y+(boutons[1].getHeight()/2));

            JLabel res = (JLabel)subSubComponents[0];
            assertTrue("\"you\" doit être présent, pour ce test",res.getText().endsWith("true"));

            saisie = (JTextField)subSubComponents[1];
            saisie.setText("you");

            location = boutons[0].getLocationOnScreen();
            mouseMoveAndClick(location.x+(boutons[0].getWidth()/2),location.y+(boutons[0].getHeight()/2));

            res = (JLabel)subSubComponents[0];
            assertTrue("retrait est-il inopérant ??? ",res.getText().endsWith("false"));

            location = boutons[1].getLocationOnScreen();
            mouseMoveAndClick(location.x+(boutons[1].getWidth()/2),location.y+(boutons[1].getHeight()/2));

            res = (JLabel)subSubComponents[0];
            assertTrue(res.getText().endsWith("false"));
        }catch(NoSuchMethodError e){
            fail("exception inattendue ! " + e.getClass().getName());
        }catch(Exception e){
            fail("exception inattendue ! " + e.getClass().getName());
        }
    }

    public void test_IHMListe_retirer_et_occurrence() {
        try{
            Container panel = f.getContentPane();
            Component[] components = panel.getComponents();
            assertEquals(components.length, 1);

            // 		// la bonne IHM
            assertTrue(components[0] instanceof JPanel);
            Component[] subComponents = ((JPanel)components[0]).getComponents();

            assertTrue(subComponents[0] instanceof JPanel);// cmd
            assertTrue(subComponents[1] instanceof TextArea);// texte

            Component[] subSubComponents = ((JPanel)subComponents[0]).getComponents();
            assertTrue(subSubComponents[0] instanceof JLabel);// afficheur
            assertTrue(subSubComponents[1] instanceof JTextField);// saisie
            assertTrue(subSubComponents[2] instanceof JPanel);// boutons

            Component[] boutons = ((JPanel)subSubComponents[2]).getComponents();
            assertTrue(boutons[0] instanceof JButton);// boutonRechercher
            JButton rechercher = ((JButton)boutons[0]);
            assertTrue(boutons[1] instanceof JButton);// boutonRetirer
            JButton retirer = ((JButton)boutons[1]);
            assertTrue(boutons[2] instanceof JLabel);// 
            assertTrue(boutons[3] instanceof Checkbox);// croissant
            assertTrue(boutons[4] instanceof Checkbox);// decroissant
            assertTrue(boutons[5] instanceof JButton);// occurrence
            JButton occurrence = ((JButton)boutons[5]);	  

            JTextField saisie = (JTextField)subSubComponents[1];
            saisie.setText("lin");

 
            retirer.doClick();
            robot.delay(300);

            JLabel res = (JLabel)subSubComponents[0];
            assertTrue(" ce qui commence par \"lin\" doit être présent, pour ce test",res.getText().endsWith("true"));

            saisie = (JTextField)subSubComponents[1];
            saisie.setText("linked");

            rechercher.doClick();
            robot.delay(300);

            res = (JLabel)subSubComponents[0];
            assertTrue("retrait est-il inopérant ??? ",res.getText().endsWith("false"));

            retirer.doClick();
            robot.delay(300);
            res = (JLabel)subSubComponents[0];
            assertTrue(res.getText().endsWith("false"));

            saisie.setText("linked");
            occurrence.doClick();	 
            robot.delay(3000);

            res = (JLabel)subSubComponents[0];
            Scanner sc = new Scanner(res.getText());
            assertEquals("--> est attendu ???","-->",sc.next());
            try{
                int result = sc.nextInt();
                assertTrue(" Nombre d'occurrence de linked est-il erroné ??? (0 après un retrait)",result==0);
            }catch(java.util.InputMismatchException e){
                fail("L'affichage du nombre d'occurrence doit être de 0 après un retrait effectif");
            }

        }catch(NoSuchMethodError e){
            fail("exception inattendue ! " + e.getClass().getName());
        }catch(Exception e){
            fail("exception inattendue ! " + e.getClass().getName());
        }
    }

  
    // extrait de http://www.hazirkod.com/hazirkodv.asp?KID=1425
    public static void typeLine(String s, Robot robot, boolean enter) throws Exception{
        char[] array=s.toCharArray();
        for(int i=0;i<array.length;i++){

            if(array[i]>='a'&&array[i]<='z'){
                robot.keyPress((int)array[i]-(int)'a'+65);
                robot.delay(60);
                robot.keyRelease((int)array[i]-(int)'a'+65);
            }else if(array[i]==' '){
                robot.keyPress(KeyEvent.VK_SPACE);
                robot.delay(60);
                robot.keyRelease(KeyEvent.VK_SPACE);
            }else if(array[i]>='A'&&array[i]<='Z'){
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.delay(60);
                robot.keyPress((int)array[i]-(int)'A'+65);
                robot.delay(10);
                robot.keyRelease((int)array[i]-(int)'A'+65);
                robot.delay(60);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }else if(array[i]>='0'&&array[i]<='9'){
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.delay(60);
                robot.keyPress(KeyEvent.VK_0+(int)(array[i]-'0'));
                robot.delay(60);
                robot.keyRelease(KeyEvent.VK_0+(int)(array[i]-'0'));
                robot.delay(60);

                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
            robot.delay(60);

        }
    }

    public void mouseMoveAndClick(int x, int y){
        robot.mouseMove( x,y);
        robot.delay(60);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(60);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(60);
    }//end mouseMoveAndClick

    public void mouseMoveAndClickClick(int x, int y){
        robot.mouseMove( x,y);
        robot.delay(30);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(30);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(30);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(30);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(30);
    }//end mouseMoveAndClickClick

   
}
