package com.raparison.desktop.model;

import com.raparison.desktop.controller.ActivityController;

import java.util.Date;

public class Activity {
    public Activity(String name, int duration, Date activityDate, int RPE, ActivityController activityController) {
        this.name = name;
        this.duration = duration;
        this.activityDate = activityDate;
        this.RPE = RPE;
        this.activityController = activityController;
        this.charge = calculateCharge();
    }
    private String name;
    private int duration;
    private Date activityDate;
    private int RPE;
    private float charge;
    private ActivityController activityController;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public int getRPE() {
        return RPE;
    }

    public void setRPE(int RPE) {
        this.RPE = RPE;
    }

    public float getCharge() {
        return charge;
    }

    public void setCharge(float charge) {
        this.charge = charge;
    }

    private int calculateCharge() {
        return activityController.calculateCharge(duration, RPE);
    }
}
