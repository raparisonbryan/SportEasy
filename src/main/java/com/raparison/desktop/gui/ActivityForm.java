package com.raparison.desktop.gui;

import com.raparison.desktop.controller.ActivityController;
import com.raparison.desktop.model.Activity;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public ActivityForm(ActivityController activityController) {
        setTitle("Ma Fenêtre");
        setContentPane(panel);

        // Largeur et hauteur de la fenêtre
        int largeur = 800;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int hauteur = screenSize.height / 2;
        setSize(largeur, hauteur);

        // Action à effectuer lorsque la fenêtre est fermée
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rendez la fenêtre visible
        setVisible(true);

        // Centrer la fenêtre sur l'écran
        setLocationRelativeTo(null);

        valider.addActionListener(e -> {
            // Récupérer les données du formulaire
            String nameValue = name.getText();
            int durationValue = Integer.parseInt(duration.getText());
            int rpeValue = RPE.getValue();
            Date dateValue = (Date) formattedTextField1.getValue();

            // Créer l'objet Activity
            Activity activity = new Activity(nameValue, durationValue, dateValue, rpeValue, activityController);

            activityController.saveActivity(activity);

            // Affichez un message de succès
            JOptionPane.showMessageDialog(ActivityForm.this, "Activity saved successfully!");
        });

    }

    private void createUIComponents() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        formattedTextField1 = new JFormattedTextField(dateFormat);
    }

}