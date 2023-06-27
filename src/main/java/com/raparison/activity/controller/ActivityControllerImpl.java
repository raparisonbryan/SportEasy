package com.raparison.activity.controller;

import com.raparison.activity.model.Activity;
import com.raparison.activity.repository.ActivityRepository;

public class ActivityControllerImpl implements ActivityController{
    ActivityRepository activityRepository;

    public ActivityControllerImpl(ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }
    @Override
    public String saveActivity(Activity activity) {
        return this.activityRepository.save(activity);
    }
}