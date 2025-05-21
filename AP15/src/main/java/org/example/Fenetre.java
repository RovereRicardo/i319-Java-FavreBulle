package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

public class Fenetre extends JFrame {

    //Pannels
    public JPanel mainPanel = new JPanel();
    public JPanel rectangleContainer = new JPanel();
    public PanneauRectangle panneauRectangle = new PanneauRectangle();

    //Buttons
    public JButton fond = new JButton("Couleur fond panneau");
    public JButton trait = new JButton("Couleur trait figure");

    //Colors
    public Color[] colors = {
            Color.red,
            Color.yellow,
            Color.green,
            Color.blue,
            Color.black,
            Color.magenta
    };

    private Color getRandomColor() {
        int index = (int) (Math.random() * colors.length);
        return colors[index];
    }


    public Fenetre() {
        super();
        this.setTitle("Dessin de formes et couleurs");
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setLayout(new BorderLayout());

        rectangleContainer.setLayout(new BorderLayout());

        rectangleContainer.add(panneauRectangle, BorderLayout.CENTER);
        rectangleContainer.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));

        //AddPanels
        mainPanel.add(rectangleContainer, BorderLayout.CENTER);

        //Add buttons
        mainPanel.add(fond, BorderLayout.NORTH);
        mainPanel.add(trait, BorderLayout.SOUTH);

        fond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = getRandomColor();
                if(newColor != panneauRectangle.getLineColor()) {
                    panneauRectangle.setBackground(newColor);
                    rectangleContainer.setBackground(newColor);
                    rectangleContainer.repaint();
                    panneauRectangle.repaint();
                } else {
                    return;
                }
            }
        });

        trait.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = getRandomColor();
                if(newColor != panneauRectangle.getBackground()) {
                    panneauRectangle.setLineColor(newColor);
                    panneauRectangle.setBorderColor(newColor);
                    panneauRectangle.repaint();
                } else {
                    return;
                }
            }
        });


        this.setContentPane(mainPanel);
        this.setVisible(true);
    }
}

// : ROUGE, JAUNE, BLEU, VERT, GRIS, ROSE, VIOLET, BLANC,
//NOIR
