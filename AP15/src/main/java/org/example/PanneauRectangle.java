package org.example;

import javax.swing.*;
import java.awt.*;

public class PanneauRectangle extends JPanel {

    private Color lineColor = Color.BLACK;
    private Color borderColor = Color.BLACK;

    public PanneauRectangle() {
        super();
    }

    public void setLineColor(Color color){
        this.lineColor = color;
        repaint();
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setBorderColor(Color color){
        this.borderColor = color;
        setBorder(BorderFactory.createLineBorder(borderColor,4));
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int largeurPanel = getWidth();
        int hauteurPanel = getHeight();

        g2d.setColor(lineColor);
        g2d.setStroke(new BasicStroke(4));
        g2d.drawLine(0, 0, largeurPanel - 1, hauteurPanel - 1); // Top-left to bottom-right
        g2d.drawLine(0, hauteurPanel - 1, largeurPanel - 1, 0); // Bottom-left to top-right

        g2d.setColor(borderColor);
        g2d.setStroke(new BasicStroke(4));
        g2d.drawRect(2, 2, getWidth() - 4, getHeight() - 4);


    }
}
