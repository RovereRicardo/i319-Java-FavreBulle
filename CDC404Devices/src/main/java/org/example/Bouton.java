package org.example;

import javax.swing.*;
import java.awt.*;

public class Bouton extends JButton {

    public String buttonText;
    public Color buttonColor;

    public void setBackgroundColor(Color buttonColor) {
        this.setBackground(buttonColor);
    }

    public void setButtonText(String buttonText) {
        this.setText(buttonText);
    }

    public Bouton() {
        super();
        this.setForeground(Color.white);
    }
}
