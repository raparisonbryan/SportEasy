package com.raparison.activity.mapper;

import com.raparison.activity.model.Activity;
import org.bson.Document;

import java.util.Date;

public class ActivityMapper {
    public static Document activityToDocument(Activity activity) {
        Document document = new Document()
                .append("name", activity.getName())
                .append("duration", activity.getDuration())
                .append("activityDate", activity.getActivityDate())
                .append("RPE", activity.getRPE())
                .append("charge" , activity.getCharge())
                ;
        return document;
    }

    public static Activity documentToActivity(Document document) {
        Activity activity = new Activity(
                (String) document.get("name"),
                (int) document.get("duration"),
                (Date) document.get("activityDate"),
                (int) document.get("RPE")
        );
        return activity;
    }
}