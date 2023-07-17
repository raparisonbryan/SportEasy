package com.raparison.desktop.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListActivity extends JFrame {
    private JList<String> activityList;

    public ListActivity(List<String> activities) {
        setTitle("Liste des activités");

        // Largeur et hauteur de la fenêtre
        int largeur = 800;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int hauteur = screenSize.height / 2;
        setSize(largeur, hauteur);

        // Action à effectuer lorsque la fenêtre est fermée
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rendez la fenêtre visible
        setVisible(true);

        // Convertir la liste d'activités en un tableau
        String[] activityArray = activities.toArray(new String[0]);

        // Créer une instance de JList avec le tableau d'activités
        activityList = new JList<>(activityArray);

        // Définir un JScrollPane pour permettre le défilement de la liste
        JScrollPane scrollPane = new JScrollPane(activityList);

        // Ajouter le JScrollPane à la fenêtre
        getContentPane().add(scrollPane);

        // Centrer la fenêtre sur l'écran
        setLocationRelativeTo(null);

        // Créer le bouton retour
        JButton returnButton = new JButton("Retour");

        // Ajouter un ActionListener au bouton
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainPage mainPage = new MainPage();
                mainPage.setVisible(true);
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(returnButton);

        add(buttonPanel, BorderLayout.NORTH);
    }
}
