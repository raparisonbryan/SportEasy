package com.raparison.desktop.gui;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.raparison.desktop.controller.ActivityControllerImpl;
import com.raparison.desktop.controller.UserController;
import com.raparison.desktop.controller.UserControllerImpl;
import com.raparison.desktop.model.Activity;
import com.raparison.desktop.repository.ActivityRepositoryImpl;
import com.raparison.desktop.repository.UserRepositoryImpl;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends JFrame {

    private static JButton openActivityButton;
    private static JButton openListButton;
    private static JButton modifierButton;
    private static JButton dataButton;

    public MainPage() {
        setTitle("Page principale");

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

        JPanel panel = new JPanel();

        panel.add(openActivityButton);
        panel.add(openListButton);
        panel.add(modifierButton);
        panel.add(dataButton);
        add(panel);
    }

    public static void main(String[] args) {
        String connectionString = "mongodb+srv://Desktop:Desktop@cluster0.p5qdopx.mongodb.net/?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("Desktop");
        MongoCollection<Document> activityCollection = database.getCollection("Activity");
        ActivityRepositoryImpl activityRepository = new ActivityRepositoryImpl(activityCollection);
        ActivityControllerImpl activityController = new ActivityControllerImpl(activityRepository);
        MongoCollection<Document> userCollection = database.getCollection("User");
        UserRepositoryImpl userRepository = new UserRepositoryImpl(userCollection);
        UserControllerImpl userController = new UserControllerImpl(userRepository);

        UserForm userForm = new UserForm(userController);
        userForm.setVisible(true);
        userForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création des boutons pour accéder aux autres fenêtres
        openActivityButton = new JButton("Ouvrir la fenêtre d'activités");
        openListButton = new JButton("Ouvrir la fenêtre de liste des activités");
        modifierButton = new JButton("modifier vos informations");
        dataButton = new JButton("Voir les données de vos activités");

        java.util.List<Activity> activities = activityController.getAllActivity();

        // Créer une liste de chaînes pour afficher les noms des activités
        List<String> activityNames = new ArrayList<>();
        for (Activity activity : activities) {
            activityNames.add(activity.getName());
            activityNames.add(String.valueOf(activity.getDuration()));
            activityNames.add(String.valueOf(activity.getActivityDate()));
            activityNames.add(String.valueOf(activity.getRPE()));
            activityNames.add(String.valueOf(activity.getCharge()));
        }

        openActivityButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ActivityForm activityForm = new ActivityForm(activityController);
                activityForm.setVisible(true);
            }
        });
        openListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListActivity form = new ListActivity(activityNames);
                form.setVisible(true);
            }
        });

        modifierButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserForm userForm = new UserForm(userController);
                userForm.setVisible(true);
            }
        });

        dataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DataPage dataPage = new DataPage(activityController);
                dataPage.setVisible(true);
            }
        });


    }
}
