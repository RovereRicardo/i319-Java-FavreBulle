package org.example;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {

    //Panels
    public JPanel mainPanel = new JPanel();
    //North Panel
    public JPanel northPanel = new JPanel();
    //South Panel
    public JPanel southPanel = new JPanel();
    public JPanel buttonContainer = new JPanel();

    private double eurToChf = 1.033775;
    private double chfToEur =0.9673;
    private double value;

    private double convertion;

    public void setConvertion(double convertion) {
        this.convertion = convertion;
    }

    public double getConvertion() {
        return convertion;
    }


    //Labels
    public JLabel chf = new JLabel("CHF");
    public JLabel euro = new JLabel("EURO");

    //Textfield
    public JTextField chfTxt = new JTextField();
    public JTextField eurTxt = new JTextField();

    //Radios
    public JRadioButton chfRadio = new JRadioButton("CHF => €");
    public JRadioButton eurRadio = new JRadioButton("€ => CHF");

    //Button
    public ButtonGroup buttonGroup = new ButtonGroup();
    public Bouton calculer = new Bouton();
    public Bouton effacer = new Bouton();

    //Option
    private JOptionPane popup = new JOptionPane();

    public Fenetre() {
        super();
        this.setTitle("Convertisseur de devises");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(450,120);
        this.setResizable(false);

        mainPanel.setLayout(new BorderLayout());
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));

        //Adds
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        southPanel.add(buttonContainer, BorderLayout.CENTER);

        //NorthPanels Adds
        northPanel.add(chf);
        northPanel.add(chfTxt);
        northPanel.add(chfRadio);
        northPanel.add(eurRadio);
        northPanel.add(eurTxt);
        northPanel.add(euro);

        //SouthPanel adds
        calculer.setButtonText("CALCULER");
        calculer.setBackgroundColor(Color.BLUE);
        effacer.setButtonText("EFFACER");
        effacer.setBackgroundColor(Color.BLACK);
        buttonContainer.add(calculer);
        buttonContainer.add(effacer);

        //Radios
        buttonGroup.add(chfRadio);
        buttonGroup.add(eurRadio);
        chfRadio.setSelected(true);

        //Listeners
        chfRadio.addActionListener(new radioListener());
        eurRadio.addActionListener(new radioListener());
        chfTxt.addActionListener(new chfFieldListener());
        eurTxt.addActionListener(new eurFieldListener());
        calculer.addActionListener(new calcListener());
        effacer.addActionListener(new effacerListener());


        this.setContentPane(mainPanel);
        this.setVisible(true);

    }

    public class chfFieldListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            chfTxt.getText();
        }
    }

    public class eurFieldListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            eurTxt.getText();
        }
    }

    //Radio Listener
    public class radioListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == chfRadio) {
                System.out.println("Chf Radio");
                eurTxt.setEditable(false);
                chfTxt.setEditable(true);
                setConvertion(chfToEur);
            }
            if (source == eurRadio) {
                System.out.println("Euro Radio");
                chfTxt.setEditable(false);
                eurTxt.setEditable(true);
                setConvertion(eurToChf);
            }
        }
    }

    public class calcListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = chfTxt.getText();
            String inputEur = eurTxt.getText();
            if(input.isEmpty()) {
                if(chfRadio.isSelected()) {
                    popup.showMessageDialog(null, "Veuillez sairir la valeur en CHF",
                            "ERROR", JOptionPane.INFORMATION_MESSAGE);
                } else if (eurRadio.isSelected() && inputEur.isEmpty()) {
                    popup.showMessageDialog(null, "Veuillez sairir la valeur en EUR",
                            "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            try {
                if(chfRadio.isSelected()) {
                    value = Double.parseDouble(input);
                    setConvertion(chfToEur);
                    eurTxt.setText(String.format("%.2f", value * getConvertion()));
                } else if (eurRadio.isSelected()) {
                    value = Double.parseDouble(inputEur);
                    setConvertion(eurToChf);
                    chfTxt.setEditable(false);
                    chfTxt.setText(String.format("%.2f", value * getConvertion()));
                }
            } catch (NumberFormatException ex) {
                popup.showMessageDialog(null, "Veuillez saisir correctement les valeurs",
                        "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    public class effacerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            eurTxt.setText("");
            chfTxt.setText("");
            eurTxt.setEditable(false);
            chfRadio.setSelected(true);
        }
    }
}
