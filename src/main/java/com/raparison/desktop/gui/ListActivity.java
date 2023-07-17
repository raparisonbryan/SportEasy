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

        // Centrer le texte dans la liste
        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        activityList.setCellRenderer(renderer);

        activityList.setCellRenderer(new CustomListCellRenderer());

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

    private static class CustomListCellRenderer extends DefaultListCellRenderer {
        private static final Border DEFAULT_BORDER = BorderFactory.createEmptyBorder(5, 10, 5, 10);
        private static final Border BOTTOM_BORDER = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY);

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                      boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setBorder(BorderFactory.createCompoundBorder(DEFAULT_BORDER, BOTTOM_BORDER));
            return label;
        }
    }
}
