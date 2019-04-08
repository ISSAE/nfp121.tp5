package question1;

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

public class IHMTestEnsembleTests extends junit.framework.TestCase{
    private static Random random= new Random();
    private JFrame f;
    private Robot robot;

    protected void setUp() throws java.lang.Exception{
        f = new IHMTestEnsemble();
        f.pack();
        f.setVisible(true);
        while(!(f.isShowing())){}
        f.setAlwaysOnTop(true);
        f.setLocation(random.nextInt(500), random.nextInt(500));
        robot = new Robot();
        robot.delay(60);
    }

    protected void tearDown(){ // throws java.lang.Exception
        f.dispose();
    }

    public void test_IHMTestEnsemble_union() throws Exception{
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        assertEquals(" IHM a-t-elle été modifiée ?", components.length, 4);

        // la bonne IHM
        assertTrue(" IHM a-t-elle été modifiée ?", components[0] instanceof JPanel);
        assertTrue(" IHM a-t-elle été modifiée ?", components[1] instanceof JPanel);
        assertTrue(" IHM a-t-elle été modifiée ?", components[2] instanceof JPanel);
        assertTrue(" IHM a-t-elle été modifiée ?", components[3] instanceof JPanel);

        Component[] subComponents = ((JPanel)components[2]).getComponents();
        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[1] instanceof JButton);// union
        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[2] instanceof JButton);// inter
        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[3] instanceof JButton);// diff
        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[4] instanceof JButton);// diffSym

        final String e1 = "2 3 4 5";
        final String e2 = "4 5 6 7";
        placerPourE1(e1);
        placerPourE2(e2);
        unionE1_E2();
        verificationDuResultat(e1,"union",e2, "2 3 4 5 6 7");
    }


    public void test_IHMTestEnsemble_inter() throws Exception{
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        assertEquals(" IHM a-t-elle été modifiée ?", components.length, 4);

        // la bonne IHM
        assertTrue(" IHM a-t-elle été modifiée ?", components[0] instanceof JPanel);
        assertTrue(" IHM a-t-elle été modifiée ?", components[1] instanceof JPanel);
        assertTrue(" IHM a-t-elle été modifiée ?", components[2] instanceof JPanel);
        assertTrue(" IHM a-t-elle été modifiée ?", components[3] instanceof JPanel);

        Component[] subComponents = ((JPanel)components[2]).getComponents();
        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[1] instanceof JButton);// union
        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[2] instanceof JButton);// inter
        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[3] instanceof JButton);// diff
        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[4] instanceof JButton);// diffSym

        final String e1 = "2 3 4 5"; placerPourE1(e1);
        final String e2 = "4 5 6 7"; placerPourE2(e2);
        interE1_E2();
        verificationDuResultat(e1,"inter",e2,"4 5");
    }

    public void test_IHMTestEnsemble_diff() throws Exception{
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        assertEquals(" IHM a-t-elle été modifiée ?", components.length, 4);

        // la bonne IHM
        assertTrue(" IHM a-t-elle été modifiée ?", components[0] instanceof JPanel);
        assertTrue(" IHM a-t-elle été modifiée ?", components[1] instanceof JPanel);
        assertTrue(" IHM a-t-elle été modifiée ?", components[2] instanceof JPanel);
        assertTrue(" IHM a-t-elle été modifiée ?", components[3] instanceof JPanel);

        Component[] subComponents = ((JPanel)components[2]).getComponents();
        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[1] instanceof JButton);// union
        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[2] instanceof JButton);// inter
        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[3] instanceof JButton);// diff
        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[4] instanceof JButton);// diffSym

        final String e1 = "2 3 4 5"; placerPourE1(e1);
        final String e2 = "4 5 6 7"; placerPourE2(e2);
        diffE1_E2();
        verificationDuResultat(e1,"diff",e2,"2 3");
    }


    public void test_IHMTestEnsemble_diffSym() throws Exception{
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        assertEquals(" IHM a-t-elle été modifiée ?", components.length, 4);

        // la bonne IHM
        assertTrue(" IHM a-t-elle été modifiée ?", components[0] instanceof JPanel);
        assertTrue(" IHM a-t-elle été modifiée ?", components[1] instanceof JPanel);
        assertTrue(" IHM a-t-elle été modifiée ?", components[2] instanceof JPanel);
        assertTrue(" IHM a-t-elle été modifiée ?", components[3] instanceof JPanel);

        Component[] subComponents = ((JPanel)components[2]).getComponents();
        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[1] instanceof JButton);// union
        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[2] instanceof JButton);// inter
        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[3] instanceof JButton);// diff
        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[4] instanceof JButton);// diffSym

        final String e1 = "2 3 4 5"; placerPourE1(e1);
        final String e2 = "4 5 6 7"; placerPourE2(e2);
        diffSymE1_E2();
        verificationDuResultat(e1,"diffSym",e2,"2 3 6 7");
    }


    private void placerPourE1(String str) throws Exception{
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        Component[] subComponents = ((JPanel)components[0]).getComponents();
        assertTrue(subComponents[1] instanceof JTextField);
        JTextField jt = (JTextField)subComponents[1];
        jt.setText(str);
        // 		Point location = subComponents[1].getLocationOnScreen();
        // 		mouseMoveAndClickClick(location.x,location.y);
        // 		typeLine(str, robot, false);
    }

    private void placerPourE2(String str) throws Exception{
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        Component[] subComponents = ((JPanel)components[1]).getComponents();

        assertTrue(subComponents[1] instanceof JTextField);
        JTextField jt = (JTextField)subComponents[1];
        jt.setText(str);		
        // 		Point location = subComponents[1].getLocationOnScreen();
        // 		mouseMoveAndClickClick(location.x,location.y);
        // 		typeLine(str, robot, false);
    }

    private void unionE1_E2() throws Exception{
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        Component[] subComponents = ((JPanel)components[2]).getComponents();

        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[1] instanceof JButton);// union
        // 		JButton union = ((JButton)subComponents[1]);
        // 		ActionListener[] listeners = union.getActionListeners();
        // 		assertTrue(listeners.length==1);
        //     listeners[0].actionPerformed(null);

        Point location = subComponents[1].getLocationOnScreen();
        mouseMoveAndClick(location.x+(subComponents[1].getWidth()/2),location.y+(subComponents[1].getHeight()/2));
    }

    private void interE1_E2() throws Exception{
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        Component[] subComponents = ((JPanel)components[2]).getComponents();

        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[2] instanceof JButton);// inter
        // 		JButton inter = ((JButton)subComponents[2]);
        // 		ActionListener[] listeners = inter.getActionListeners();
        // 		assertTrue(listeners.length==1);
        //     listeners[0].actionPerformed(null);

        Point location = subComponents[2].getLocationOnScreen();
        mouseMoveAndClick(location.x+(subComponents[2].getWidth()/2),location.y+(subComponents[2].getHeight()/2));
    }

    private void diffE1_E2() throws Exception{
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        Component[] subComponents = ((JPanel)components[2]).getComponents();

        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[3] instanceof JButton);// diff
        // 		JButton diff = ((JButton)subComponents[3]);
        // 		ActionListener[] listeners = diff.getActionListeners();
        // 		assertTrue(listeners.length==1);
        //     listeners[0].actionPerformed(null);

        Point location = subComponents[3].getLocationOnScreen();
        mouseMoveAndClick(location.x+(subComponents[3].getWidth()/2),location.y+(subComponents[3].getHeight()/2));
    }

    private void diffSymE1_E2() throws Exception{
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        Component[] subComponents = ((JPanel)components[2]).getComponents();

        assertTrue(" IHM a-t-elle été modifiée ?", subComponents[4] instanceof JButton);// diffSym
        // 		JButton diffSym = ((JButton)subComponents[4]);
        // 		ActionListener[] listeners = diffSym.getActionListeners();
        // 		assertTrue(listeners.length==1);
        //     listeners[0].actionPerformed(null);
        Point location = subComponents[4].getLocationOnScreen();
        mouseMoveAndClick(location.x+(subComponents[4].getWidth()/2),location.y+(subComponents[4].getHeight()/2));
    }

    private void verificationDuResultat(String e1, String op, String e2, String resultatAttendu){
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        Component[] subComponents = ((JPanel)components[3]).getComponents();
        JTextField res = (JTextField) subComponents[1];
        TreeSet resultat = getSet(res.getText());     
        TreeSet reference = getSet(resultatAttendu);
        assertTrue("["+ e1 + "] " + op + " [" + e2 + "] # [" + resultatAttendu + "] ??, obtenu:(" + resultat + ")", reference.toString().equals(resultat.toString()));
    }

    private TreeSet<String> getSet(String str){
        TreeSet<String> e = new TreeSet<String>();
        java.util.StringTokenizer st = new java.util.StringTokenizer(str," ,][");
        while(st.hasMoreTokens()){
            e.add(st.nextToken());
        }
        return e;
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
                robot.delay(60);
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
        robot.delay(60);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(60);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(60);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(60);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(60);
    }//end mouseMoveAndClickClick

    
}
