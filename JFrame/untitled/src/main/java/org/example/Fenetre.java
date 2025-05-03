package org.example;

import javax.swing.*;
import java.awt.*;

public class Fenetre  extends JFrame {

    private Panneau myPanel = new Panneau();

    public Fenetre() {
        super();
        this.setTitle("Dessin dynamique");
        this.setSize(500,500);
        this.setMinimumSize(new Dimension(400,400));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(myPanel);
        this.setVisible(true);
        this.setBackground(Color.gray);

    }
}
