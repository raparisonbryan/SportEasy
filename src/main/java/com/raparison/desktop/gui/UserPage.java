package com.raparison.desktop.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage extends JFrame{

    public UserPage(String name, String lastName) {
        setTitle("Données de l'utilisateur");

        // Largeur de la fenêtre
        int largeur = 800;
        // Hauteur de la fenêtre
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int hauteur = screenSize.height / 2;
        setSize(largeur, hauteur);

        // Action à effectuer lorsque la fenêtre est fermée
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centrer la fenêtre sur l'écran
        setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Bienvenue " + name + " " + lastName);
        JButton returnButton = new JButton("Découvrir l'application");

        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainPage mainPage = new MainPage();
                mainPage.setVisible(true);
            }
        });

        // Utiliser un gestionnaire de disposition BoxLayout pour aligner les panneaux verticalement
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel();
        JPanel namePanel = new JPanel();

        buttonPanel.add(returnButton);
        namePanel.add(nameLabel);

        add(namePanel);
        add(buttonPanel);
    }
}
