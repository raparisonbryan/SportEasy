package com.raparison.desktop.gui;

import com.raparison.desktop.controller.ActivityController;
import com.raparison.desktop.controller.UserController;
import com.raparison.desktop.model.Activity;
import com.raparison.desktop.model.User;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserForm extends JFrame{
    private JLabel nameLabel;
    private JTextField name;
    private JLabel lastNameLabel;
    private JTextField lastName;
    private JLabel birthLabel;
    private JLabel sexeLabel;
    private JRadioButton hommeRadioButton;
    private JRadioButton femmeRadioButton;
    private JButton valider;
    private JButton annuler;
    private JFormattedTextField formattedTextField1;
    private JPanel panel;

    public UserForm(UserController userController) {
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

        //Gestion du radioButton
        boolean isMale = hommeRadioButton.isSelected();

        valider.addActionListener(e -> {
            // Récupérer les données du formulaire
            String nameValue = name.getText();
            String lastNameValue = lastName.getText();
            Date dateValue = (Date) formattedTextField1.getValue();
            String sexeLabel = (isMale) ? "Homme" : "Femme";

            // Créer l'objet User
            User user;
            if (isMale) {
                user = new User(nameValue, lastNameValue, dateValue, sexeLabel);
            } else {
                user = new User(nameValue, lastNameValue,dateValue, sexeLabel);
            }

            userController.saveUser(user);

            // Affichez un message de succès
            JOptionPane.showMessageDialog(UserForm.this, "Activity saved successfully!");
        });

    }

    private void createUIComponents() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        formattedTextField1 = new JFormattedTextField(dateFormat);
    }
}
