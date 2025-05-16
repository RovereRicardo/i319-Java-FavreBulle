package org.example;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class Fenetre extends JFrame {
    public JPanel mainPanel = new JPanel();

    public JTextField textField = new JTextField();

    public JTextField mirrorField = new JTextField();

    public Fenetre() {
        super();
        this.setTitle("Mirroir à texte");
        this.setSize(800, 120);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mirrorField.setEditable(false);
        mirrorField.setSize(750, 30);
        textField.setSize(750, 30);

        mainPanel.setLayout(new GridLayout(2, 1));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 5));

        mainPanel.add(textField);
        mainPanel.add(mirrorField);

        //Fonts
        textField.setFont(new Font("Verdana", Font.BOLD, 16));
        mirrorField.setFont(new Font("Verdana", Font.BOLD, 16));

        //Listener
        textField.getDocument().addDocumentListener(new TextListener());

        this.setContentPane(mainPanel);
        this.setVisible(true);

    }

    private void updateText () {
        String text = textField.getText();
        mirrorField.setText(text);
    }

    class TextListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            updateText();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateText();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateText();
        }
    }
}
