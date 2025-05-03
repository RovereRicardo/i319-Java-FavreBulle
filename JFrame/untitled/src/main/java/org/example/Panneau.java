package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Panneau extends JPanel {
    public Panneau() {
        super();
        this.setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int largeurPanel = getWidth();
        int hauteurPanel = getHeight();

        int tailleCircle = (int) (Math.min(largeurPanel, hauteurPanel) * 0.75);
        int x = (largeurPanel - tailleCircle) / 2;
        int y = (hauteurPanel - tailleCircle) / 2;
        int tailleBorder = 4;

        // Cercle rouge
        g2d.setColor(Color.red);
        g2d.setStroke(new BasicStroke(tailleBorder));
        g2d.drawOval(x, y, tailleCircle, tailleCircle);

        // Triangle bleu inscrit dans le cercle
        int rayon = tailleCircle / 2;
        int centreX = x + rayon;
        int centreY = y + rayon;

        int[] xPoints = new int[3];
        int[] yPoints = new int[3];

        for (int i = 0; i < 3; i++) {
            double angle = Math.toRadians(90 + i * 120); // Départ en bas (90°), puis +120°
            xPoints[i] = (int) (centreX + rayon * Math.cos(angle));
            yPoints[i] = (int) (centreY + rayon * Math.sin(angle));
        }

        g2d.setColor(Color.blue);
        g2d.fillPolygon(xPoints, yPoints, 3);

        for(int i = 0; i < 3; i++){
            double angle = Math.toRadians(30 + i * 120);
            xPoints[i] = (int) (centreX + rayon * Math.cos(angle));
            yPoints[i] = (int) (centreY + rayon * Math.sin(angle));
        }
        g2d.setColor(Color.blue);
        g2d.fillPolygon(xPoints, yPoints, 3);
    }
}
