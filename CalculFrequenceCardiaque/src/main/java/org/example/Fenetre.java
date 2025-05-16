package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {

    //Attributes
    private int age;
    private int FCmax = 0;
    private int FC1 = 0;
    private int FC2 = 0;
    private String fcString = "";

    //Main Panel
    private JPanel mainContainer = new JPanel();

    //Sub Panels
    private JPanel northContainer = new JPanel();
    private JPanel centerContainer = new JPanel();
    private JPanel southContainer = new JPanel();

    //Sub Center Panels
    private JPanel northCenterContainer = new JPanel();
    private JPanel centerCenterContainer = new JPanel();
    private JPanel southCenterContainer = new JPanel();

    //North Elements
    private String[] options = {"Veuillez choisir...", "Femme", "Homme"};
    private JComboBox sexeComboBox = new JComboBox(options);

    //Center Elements
    //Center North Elements
    private JLabel ageLabel = new JLabel("Spécifier votre âge :");
    private JTextField ageTextField = new JTextField(10);

    //Center Center Elements
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton poids, endurance,performance;

    //Center South Elements
    private JLabel freqLabel = new JLabel("Votre Fréquence Cardiaque conseillée :");
    private JTextField freqTextField = new JTextField(10);

    //South Elements
    private JButton calculateButton = new JButton("CALCULER");
    private JButton resetButton = new JButton("EFFACER");

    private JOptionPane popup = new JOptionPane();

    public Fenetre() {
        super();
        this.setTitle("Frequence Cardiaque");
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.gray);

        //Borders Visualization
        /*
        mainContainer.setBorder(BorderFactory.createLineBorder(Color.gray,2));
        northContainer.setBorder(BorderFactory.createLineBorder(Color.blue,2));
        centerContainer.setBorder(BorderFactory.createLineBorder(Color.green,2));
        southContainer.setBorder(BorderFactory.createLineBorder(Color.red,2));
         */

        //Center Borders Visualization
        /*
        northCenterContainer.setBorder(BorderFactory.createLineBorder(Color.PINK,2));
        centerCenterContainer.setBorder(BorderFactory.createLineBorder(Color.YELLOW,2));
        southCenterContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
         */

        //Add Grids / Layouts
        mainContainer.setLayout(new BorderLayout());
        centerContainer.setLayout(new BorderLayout());
        northContainer.setLayout(new BorderLayout());
        northCenterContainer.setLayout(new BorderLayout());
        southCenterContainer.setLayout(new BorderLayout());

        //Border
        northContainer.setBorder(BorderFactory.createEmptyBorder(5,25,25,25));
        northCenterContainer.setBorder(BorderFactory.createEmptyBorder(0,25,25,25));
        centerCenterContainer.setBorder(BorderFactory.createEmptyBorder(0,25,25,25));
        southCenterContainer.setBorder(BorderFactory.createEmptyBorder(0,25,25,25));

        //North Panel Elements ComboBox

        //Center Panel Elements
        //Center North (Age)
        northCenterContainer.add(ageLabel, BorderLayout.NORTH);
        northCenterContainer.add(ageTextField, BorderLayout.SOUTH);

        //Center Center (Radios)
        poids = new JRadioButton("Perte de poids", true);
        endurance = new JRadioButton("Endurance");
        performance = new JRadioButton("Performance");
        buttonGroup.add(poids);
        buttonGroup.add(endurance);
        buttonGroup.add(performance);
        centerCenterContainer.add(poids);
        centerCenterContainer.add(endurance);
        centerCenterContainer.add(performance);

        //Center South (Freq)
        southCenterContainer.add(freqLabel, BorderLayout.NORTH);
        southCenterContainer.add(freqTextField, BorderLayout.SOUTH);


        //Add Panels
        mainContainer.add(northContainer, BorderLayout.NORTH);
        mainContainer.add(centerContainer, BorderLayout.CENTER);
        mainContainer.add(southContainer, BorderLayout.SOUTH);

        //NorthPanel
        northContainer.add(sexeComboBox, BorderLayout.NORTH);

        //CenterPanel
        centerContainer.add(northCenterContainer, BorderLayout.NORTH);
        centerContainer.add(centerCenterContainer, BorderLayout.CENTER);
        centerContainer.add(southCenterContainer, BorderLayout.SOUTH);

        //SouthPanel
        southContainer.add(calculateButton);
        southContainer.add(resetButton);

        //Listeners
        sexeComboBox.addActionListener(new StateListenerCombo());
        ageTextField.addActionListener(new StateListenerAge());
        poids.addActionListener(new radioPoidsListener());
        endurance.addActionListener(new radioEnduranceListener());
        performance.addActionListener(new radioPerformanceListener());
        calculateButton.addActionListener(new calculateListener());
        resetButton.addActionListener(new resetListener());


        this.setContentPane(mainContainer);
        this.setVisible(true);
    }

    //State Listener
    class StateListenerCombo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Selection: " + sexeComboBox.getSelectedItem());
        }
    }

    class StateListenerAge implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Age : " + ageTextField.getText());
        }
    }

    //Radio Listener
    class radioPoidsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Radio Poids");
            endurance.setSelected(false);
            performance.setSelected(false);
        }
    }

    class radioEnduranceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Radio Endurance");
            poids.setSelected(false);
            performance.setSelected(false);
        }
    }

    class radioPerformanceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Radio Performance");
            poids.setSelected(false);
            endurance.setSelected(false);
        }
    }

    //Buttons Listener
    class calculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Calculate");
            if(sexeComboBox.getSelectedItem().equals("Veuillez choisir...")) {
                popup.showMessageDialog(null, "Veuillez choisir votre sexe !",
                        "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            }

            try {
                age = Integer.parseInt(ageTextField.getText());
                if(age > 49) {
                    popup.showMessageDialog(null, "Veuillez consulter votre médecin avant tout effort!",
                            "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                }

                if(sexeComboBox.getSelectedItem().equals("Femme")) {
                    FCmax = 226;
                } else if (sexeComboBox.getSelectedItem().equals("Homme")) {
                    FCmax = 220;
                }
                FCmax = FCmax - age;
                fcString = "Entre " + FC1 + " et " + FC2 + " battements par minute.";

                if(age <= 49 && poids.isSelected() == true) {
                    FC1 = FCmax*60/100;
                    FC2 = FCmax*70/100;
                    freqTextField.setText(fcString);
                } else if(age <= 49 && endurance.isSelected() == true) {
                    FC1 = FCmax*70/100;
                    FC2 = FCmax*80/100;
                    freqTextField.setText(fcString);
                } else if(age <= 49 &&performance.isSelected() == true) {
                    FC1 = FCmax*80/100;
                    FC2 = FCmax*90/100;
                    freqTextField.setText(fcString);
                }

            } catch (NumberFormatException ex) {
                popup.showMessageDialog(null, "Veuillez saisir correctement les valeurs",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class resetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sexeComboBox.setSelectedIndex(0);
            ageTextField.setText("");
            poids.setSelected(true);
            endurance.setSelected(false);
            performance.setSelected(false);
            freqTextField.setText("");
        }
    }
}
