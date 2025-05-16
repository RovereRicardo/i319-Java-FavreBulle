package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {

    private int numCalc;
    // Panels
    public JPanel mainPanel = new JPanel();
    public JPanel boxsPanel = new JPanel();
    public JPanel southPanel = new JPanel();

    //Fields
    public JTextField textField = new JTextField();
    public JTextField textResult = new JTextField(); //No Text

    //Labels
    public JLabel nombre = new JLabel("Nombre : ");
    public JLabel carre = new JLabel("Carre : ");

    //Buttons
    public JButton calcul = new JButton("CALCUL");
    public JButton reset = new JButton("RESET");

    private JOptionPane popup = new JOptionPane();

    public Fenetre()
    {
        super();
        this.setTitle("Elévation au carré");
        this.setSize(500,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Layout
        mainPanel.setLayout(new BorderLayout());
        boxsPanel.setLayout(new BoxLayout(boxsPanel,BoxLayout.X_AXIS));

        //Border
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,20,20,10));
        southPanel.setBorder(BorderFactory.createEmptyBorder(10,20,20,10));

        //Fonts
        textResult.setEditable(false);
        textResult.setFont(new Font("Verdana", Font.BOLD,15));
        textResult.setForeground(Color.RED);
        //Adds
        mainPanel.add(boxsPanel,BorderLayout.NORTH);
        mainPanel.add(southPanel,BorderLayout.SOUTH);

        boxsPanel.add(nombre);
        boxsPanel.add(textField);
        boxsPanel.add(carre);
        boxsPanel.add(textResult);

        southPanel.add(calcul);
        southPanel.add(reset);

        //Listener
        calcul.addActionListener(new calculListener());
        reset.addActionListener(new resetListener());

        this.setContentPane(mainPanel);
        this.setVisible(true);

    }

    //Buttons Listener
    class calculListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Calcul");

            try {
                numCalc = Integer.parseInt(textField.getText());
                int resultCalc = numCalc * numCalc;
                textResult.setText(String.valueOf(resultCalc));

            } catch (NumberFormatException ex) {
                popup.showMessageDialog(null, "Veuillez saisir un nombre", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class resetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            textResult.setText("");
            textField.setText("");
        }
    }

}
