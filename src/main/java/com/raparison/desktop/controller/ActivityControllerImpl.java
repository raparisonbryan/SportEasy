package com.raparison.desktop.controller;

import com.raparison.desktop.model.Activity;
import com.raparison.desktop.repository.ActivityRepository;

import java.util.List;

public class ActivityControllerImpl implements ActivityController{
    ActivityRepository activityRepository;

    public ActivityControllerImpl(ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }
    @Override
    public String saveActivity(Activity activity) {
        return this.activityRepository.save(activity);
    }

    public List<Activity> getAllActivity() {
        return activityRepository.getAll();
    }

    public int calculateCharge(int duration, int RPE) {
        return duration * RPE;
    }
}