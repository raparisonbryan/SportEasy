package com.raparison.activity.gui;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class ActivityForm extends JFrame {
    private JTextField name;
    private JTextField duration;
    private JSlider RPE;
    private JPanel panel;
    private JButton valider;
    private JButton annuler;
    private JLabel nameLabel;
    private JLabel durationLabel;
    private JFormattedTextField formattedTextField1;
    private JLabel dateLabel;

    public ActivityForm() {
        setTitle("Ma Fenêtre");
        setContentPane(panel);

        // Largeur et hauteur de la fenêtre
        int largeur = 800;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int hauteur = screenSize.height / 2;
        setSize(largeur, hauteur);

        // Action à effectuer lorsque la fenêtre est fermée
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        formattedTextField1 = new JFormattedTextField(dateFormat);
    }

    public static void main(String[] args) {
        // Créer une instance de la fenêtre
        ActivityForm fenetre = new ActivityForm();

        // Rendre la fenêtre visible
        fenetre.setVisible(true);
    }


}