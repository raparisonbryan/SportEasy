package com.raparison.desktop;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.raparison.desktop.controller.ActivityControllerImpl;
import com.raparison.desktop.controller.UserControllerImpl;
import com.raparison.desktop.gui.ActivityForm;
import com.raparison.desktop.gui.ListActivity;
import com.raparison.desktop.gui.UserForm;
import com.raparison.desktop.model.Activity;
import com.raparison.desktop.repository.ActivityRepositoryImpl;
import com.raparison.desktop.repository.UserRepositoryImpl;
import org.bson.Document;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Activities {
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

        /*EventQueue.invokeLater(new Runnable() {
            public void run() {
                ActivityForm activityForm = new ActivityForm(activityController);
                activityForm.setVisible(true);
            }
        });*/

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserForm userForm = new UserForm(userController);
                userForm.setVisible(true);
            }
        });

        /*List<Activity> activities = activityController.getAllActivity();

        // Créer une liste de chaînes pour afficher les noms des activités
        List<String> activityNames = new ArrayList<>();
        for (Activity activity : activities) {
            activityNames.add(activity.getName());
            activityNames.add(String.valueOf(activity.getDuration()));
            activityNames.add(String.valueOf(activity.getActivityDate()));
            activityNames.add(String.valueOf(activity.getRPE()));
            activityNames.add(String.valueOf(activity.getCharge()));
        }

        // Créer une instance de la fenêtre et afficher la liste d'activités
        EventQueue.invokeLater(() -> {
            ListActivity form = new ListActivity(activityNames);
            form.setVisible(true);
        });*/
    }
}