package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {

    private JPanel mainPanel = new JPanel();
    private JPanel buttonsPanel = new JPanel();
    private JPanel resetPanel = new JPanel();
    private static JPanel colorPanel = new JPanel();

    private JButton buttonRouge = new JButton("Rouge");
    private JButton buttonJaune = new JButton("Jaune");
    private JButton buttonBleu = new JButton("Bleu");
    private JButton buttonVert = new JButton("Vert");
    private JButton buttonReset = new JButton("Reset");
    private JLabel colorLabel = new JLabel();

    public Fenetre()
    {
        super();
        this.setTitle("AP 12");
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout gridButton = new GridLayout(2,2);
        mainPanel.setLayout(new BorderLayout());

        // Panels
        buttonsPanel.setBackground(Color.gray);
        colorPanel.setBackground(Color.WHITE);
        resetPanel.setBackground(Color.GREEN);

        // Label
        colorPanel.add(colorLabel, BorderLayout.NORTH);

        // Add Panels to MainPanel
        mainPanel.add(buttonsPanel, BorderLayout.NORTH);
        mainPanel.add(colorPanel, BorderLayout.CENTER);
        mainPanel.add(resetPanel, BorderLayout.SOUTH);

        //Buttons Panels
        buttonsPanel.setLayout(gridButton);
        buttonsPanel.add(buttonRouge);
        buttonsPanel.add(buttonJaune);
        buttonsPanel.add(buttonBleu);
        buttonsPanel.add(buttonVert);

        //Button Reset
        resetPanel.setLayout(new BorderLayout());
        resetPanel.add(buttonReset);

        //Listeners
        buttonBleu.addActionListener(new BBleu());
        buttonJaune.addActionListener(new BJaune());
        buttonRouge.addActionListener(new BRouge());
        buttonVert.addActionListener(new BVert());
        buttonReset.addActionListener(new BReset());

        this.setContentPane(mainPanel);
        this.setVisible(true);
    }

    class BVert implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            colorPanel.setBackground(Color.GREEN);
            colorLabel.setText("Vert");
            colorLabel.setFont(new Font("Arial", Font.BOLD, 20));
        }
    }

    class BBleu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            colorPanel.setBackground(Color.BLUE);
            colorLabel.setText("Bleu");
            colorLabel.setFont(new Font("Arial", Font.BOLD, 20));
        }
    }

    class BRouge implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            colorPanel.setBackground(Color.RED);
            colorLabel.setText("Rouge");
            colorLabel.setFont(new Font("Arial", Font.BOLD, 20));
        }
    }

    class BJaune implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            colorPanel.setBackground(Color.YELLOW);
            colorLabel.setText("Jaune");
            colorLabel.setFont(new Font("Arial", Font.BOLD, 20));


        }
    }
    class BReset implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            colorPanel.setBackground(Color.WHITE);
            colorLabel.setText("");
        }
    }
}
