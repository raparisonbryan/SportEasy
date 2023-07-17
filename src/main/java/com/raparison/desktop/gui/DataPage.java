package com.raparison.desktop.gui;

import com.raparison.desktop.controller.ActivityController;
import com.raparison.desktop.controller.ActivityControllerImpl;
import com.raparison.desktop.model.TrainingState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataPage extends JFrame {
    private JLabel chargeLabel;
    private JLabel monotonieLabel;
    private JLabel contrainteLabel;
    private JLabel fitnessLabel;
    private JLabel trainingStateLabel;

    public DataPage(ActivityController activityController) {
        setTitle("Données des activités l'utilisateur");

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

        JButton returnButton = new JButton("retour");

        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainPage mainPage = new MainPage();
                mainPage.setVisible(true);
            }
        });

        // Utiliser un gestionnaire de disposition BoxLayout pour aligner les panneaux verticalement
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        chargeLabel = new JLabel();
        monotonieLabel = new JLabel();
        contrainteLabel = new JLabel();
        fitnessLabel = new JLabel();
        trainingStateLabel = new JLabel();

        JPanel buttonPanel = new JPanel();
        JPanel chargePanel = new JPanel();
        JPanel monotoniePanel = new JPanel();
        JPanel contraintePanel = new JPanel();
        JPanel fitnessPanel = new JPanel();
        JPanel statePanel = new JPanel();

        double totalCharge = activityController.calculateTotalCharge();
        double monotonie = activityController.calculateMonotonie();
        double contrainte = activityController.calculateContrainte();
        double fitness = activityController.calculateFitness();
        TrainingState trainingState = activityController.assessTrainingState();

        String formattedCharge = String.format("%.2f", totalCharge);
        String formattedmonotonie = String.format("%.2f", monotonie);
        String formattedContrainte = String.format("%.2f", contrainte);
        String formattedFitness = String.format("%.2f", fitness);

        chargeLabel.setText("Charge totale : " + formattedCharge);
        monotonieLabel.setText("Monotonie : " + formattedmonotonie);
        contrainteLabel.setText("Contrainte : " + formattedContrainte);
        fitnessLabel.setText("Fitness : " + formattedFitness);
        trainingStateLabel.setText(trainingState.getMessage());
        trainingStateLabel.setForeground(Color.decode(trainingState.getColor()));

        buttonPanel.add(returnButton);
        chargePanel.add(chargeLabel);
        monotoniePanel.add(monotonieLabel);
        contraintePanel.add(contrainteLabel);
        fitnessPanel.add(fitnessLabel);
        statePanel.add(trainingStateLabel);

        add(chargePanel);
        add(monotoniePanel);
        add(contraintePanel);
        add(fitnessPanel);
        add(buttonPanel);
        add(statePanel);

    }
}
