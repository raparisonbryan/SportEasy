package com.raparison.activity;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.raparison.activity.model.Activity;
import com.raparison.activity.repository.ActivityRepositoryImpl;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class Activities {
    private static final Logger logger = LoggerFactory.getLogger(Activities.class);

    public static void main(String[] args) {
        String connectionString = "mongodb+srv://Desktop:Desktop@cluster0.p5qdopx.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            logger.info("Database connection successful");
            MongoDatabase database = mongoClient.getDatabase("Desktop");
            MongoCollection<Document> activityCollection = database.getCollection("Activity");
            ActivityRepositoryImpl activityRepository = new ActivityRepositoryImpl(activityCollection);

             Activity activity = new Activity(
                    "Push up",
                    15,
                    new Date(2023, 06, 26),
                    30
            );
            logger.info("Activity saved {}", activityRepository.save(activity));
        } catch (Exception e) {
            logger.error("An error occurred during connection ==> {}", e);
        }
    }
}