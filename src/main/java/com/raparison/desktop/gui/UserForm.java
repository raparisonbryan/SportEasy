package com.raparison.desktop.gui;

import com.raparison.desktop.controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

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

        annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage mainPage = new MainPage();
                mainPage.setVisible(true);
                UserForm.this.dispose(); // ferme la fenêtre actuelle
            }
        });

        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameValue = name.getText();
                String lastNameValue = lastName.getText();

                UserPage userPage = new UserPage(nameValue, lastNameValue);
                userPage.setVisible(true);
                UserForm.this.dispose(); // ferme la fenêtre actuelle
            }
        });
    }

    private void createUIComponents() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        formattedTextField1 = new JFormattedTextField(dateFormat);
    }
}
