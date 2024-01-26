package question1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IHMTestEnsemble extends JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;

    private JPanel panel2;
    private JLabel label2;
    private JTextField textField2;
    private JPanel panel3;

    private JLabel label4;
    private JPanel panel4;
    private JLabel label3;
    private JTextField textField3;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public IHMTestEnsemble() {
        super("IHM TestEnsemble");
        initComponents();
        setLocation(200,200);
        pack();
        setVisible(true);
    }

    private void initComponents() {// GEN-BEGIN:initComponents
        setLayout(new GridLayout(4, 1, 2, 2));

        panel1 = new JPanel();
        panel1.setLayout(new java.awt.FlowLayout(0, 5, 5));
        panel1.setBackground(java.awt.Color.lightGray);
        label1 = new JLabel();
        label1.setBackground(java.awt.Color.orange);
        label1.setText("ensemble e1 :");
        panel1.add(label1);
        textField1 = new JTextField();
        textField1.setColumns(52);
        textField1.setName("saisieE1");
        panel1.add(textField1);
        add(panel1);

        panel2 = new JPanel();
        panel2.setLayout(new java.awt.FlowLayout(0, 5, 5));
        panel2.setBackground(java.awt.Color.magenta);
        label2 = new JLabel();
        label2.setText("ensemble e2 :");
        panel2.add(label2);
        textField2 = new JTextField();
        textField2.setColumns(52);
        panel2.add(textField2);
        add(panel2);

        panel3 = new JPanel();
        panel3.setLayout(new java.awt.FlowLayout(0, 5, 5));
        panel3.setBackground(java.awt.Color.green);
        label4 = new JLabel();
        label4.setText("Opérations e1 Op e2  :");
        label4.setName("label4");
        panel3.add(label4);

        button1 = new JButton("union");
        button1.setBackground(java.awt.Color.red);
        button1.setName("union");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                unionActionPerformed(evt);
            }
        });
        
        panel3.add(button1);
        button2 = new JButton("intersection");
        button2.setBackground(java.awt.Color.yellow);
        button2.setName("intersection");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                intersectionActionPerformed(evt);
            }
        });

        panel3.add(button2);
        button3 = new JButton("difference");
        button3.setBackground(java.awt.Color.pink);
        button3.setActionCommand("difference");
        button3.setName("difference");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                differenceActionPerformed(evt);
            }
        });

        panel3.add(button3);
        button4 = new JButton("diffSymetrique");
        button4.setBackground(java.awt.Color.cyan);
        button4.setName("diffSymetrique");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                diffSymetriqueActionPerformed(evt);
            }
        });


        panel3.add(button4);
        add(panel3);

        panel4 = new JPanel();
        panel4.setLayout(new java.awt.FlowLayout(0, 5, 5));
        label3 = new JLabel();
        label3.setText("Résultat");
        label3.setName("Résultat");

        panel4.add(label3);

        textField3 = new JTextField();
        textField3.setColumns(60);

        panel4.add(textField3);
        panel4.setBackground(java.awt.Color.orange);

        add(panel4);
    }// GEN-END:initComponents

    private Ensemble<String> getSet(JTextField saisie) {
        Ensemble<String> e = new Ensemble<String>();
        java.util.StringTokenizer st = new java.util.StringTokenizer(
                saisie.getText(), " ,.:/-;");
        while (st.hasMoreTokens()) {
            e.add(st.nextToken());
        }
        return e;
    }

    // ne pas modifier ces lignes
    private void differenceActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_differenceActionPerformed
        // Add your handling code here:
        Ensemble<String> e1 = getSet(textField1);
        Ensemble<String> e2 = getSet(textField2);
        textField3.setText(e1.diff(e2).toString());
    }// GEN-LAST:event_differenceActionPerformed

    private void intersectionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_intersectionActionPerformed
        // Add your handling code here:
        Ensemble<String> e1 = getSet(textField1);
        Ensemble<String> e2 = getSet(textField2);
        textField3.setText((e1.inter(e2)).toString());
    }// GEN-LAST:event_intersectionActionPerformed

    private void unionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_unionActionPerformed
        Ensemble<String> e1 = getSet(textField1);
        Ensemble<String> e2 = getSet(textField2);
        textField3.setText(e1.union(e2).toString());
    }// GEN-LAST:event_unionActionPerformed

    private void diffSymetriqueActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_button4ActionPerformed
        // Add your handling code here:
        Ensemble<String> e1 = getSet(textField1);
        Ensemble<String> e2 = getSet(textField2);
        textField3.setText(e1.diffSym(e2).toString());
    }// GEN-LAST:event_button4ActionPerformed
    
    public static void main(String[] args){
        new IHMTestEnsemble();
    }
}
