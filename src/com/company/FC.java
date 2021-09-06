package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FC extends JFrame {
    private int countMilan;
    private int countMadrid;
    private String stringLast="N/A";
    private String stringWinner="DRAW";
    Icon icon1 = new ImageIcon("D:\\milan.jpg");
    Icon icon2 = new ImageIcon("D:\\madrid.jpg");

    JButton butMilan = new JButton("Milan");

    JButton butMadrid = new JButton("Madrid");
    JLabel jLabelResult = new JLabel("Result: "+ countMadrid+" x "+countMilan);
    JLabel jLabelScorer = new JLabel("Last Scorer: "+stringLast);
    Label labelWinner = new Label("Winner: "+ stringWinner);


    //JPanel panel = new JPanel();
    public FC() throws HeadlessException {
        add(jLabelResult,BorderLayout.NORTH);
        add(jLabelScorer,BorderLayout.SOUTH);
        add(butMilan,BorderLayout.WEST);
        add(butMadrid,BorderLayout.EAST);
        add(labelWinner,BorderLayout.CENTER);
        jLabelResult.setHorizontalAlignment(JLabel.CENTER);
        jLabelScorer.setHorizontalAlignment(JLabel.CENTER);
        labelWinner.setAlignment(Label.CENTER);
        
        getRootPane().setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        setSize(400,100);
        butMadrid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countMadrid++;
                jLabelResult.setText("Result: "+ countMilan+" x "+countMadrid);
                jLabelScorer.setText("Last Scorer: "+"Madrid");
                labelWinner.setText("Winner: "+winners(stringWinner));

            }
        });
        butMilan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countMilan++;
                jLabelResult.setText("Result: "+ countMilan+" x "+countMadrid);
                jLabelScorer.setText("Last Scorer: "+"Milan");
                labelWinner.setText("Winner: "+winners(stringWinner));
            }
        });
    }
    public String winners(String stringWinner){
        if (countMilan>countMadrid) stringWinner="Milan";
        else if  (countMilan<countMadrid) stringWinner="Madrid";
        else stringWinner="DRAW";
        return stringWinner;
    }

    public static void main(String[]args)
    {
        new FC().setVisible(true);
    }
}
