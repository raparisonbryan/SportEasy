package com.raparison.activity;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.raparison.activity.controller.ActivityController;
import com.raparison.activity.controller.ActivityControllerImpl;
import com.raparison.activity.gui.ActivityForm;
import com.raparison.activity.model.Activity;
import com.raparison.activity.repository.ActivityRepositoryImpl;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.Date;

public class Activities {
    private static final Logger logger = LoggerFactory.getLogger(Activities.class);

    public static void main(String[] args) {
        String connectionString = "mongodb+srv://Desktop:Desktop@cluster0.p5qdopx.mongodb.net/?retryWrites=true&w=majority";
            MongoClient mongoClient = MongoClients.create(connectionString);
            logger.info("Database connection successful");
            MongoDatabase database = mongoClient.getDatabase("Desktop");
            MongoCollection<Document> activityCollection = database.getCollection("Activity");
            ActivityRepositoryImpl activityRepository = new ActivityRepositoryImpl(activityCollection);
            ActivityControllerImpl activityController = new ActivityControllerImpl(activityRepository);

            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    ActivityForm activityForm = new ActivityForm(activityController);
                    activityForm.setVisible(true);
                }
            });
    }
}