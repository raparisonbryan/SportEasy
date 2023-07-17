package com.raparison.desktop.controller;

import com.raparison.desktop.model.Activity;
import com.raparison.desktop.model.TrainingState;
import com.raparison.desktop.repository.ActivityRepository;

import java.util.List;

public class ActivityControllerImpl implements ActivityController{
    ActivityRepository activityRepository;

    public ActivityControllerImpl(ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }
    @Override
    public String saveActivity(Activity activity) {
        activity.setCharge(activity.getDuration() * activity.getRPE());
        return this.activityRepository.save(activity);
    }

    public List<Activity> getAllActivity() {
        return activityRepository.getAll();
    }

    @Override
    public double calculateTotalCharge() {
        double totalCharge = 0;
        List<Activity> activities = getAllActivity();

        for (Activity activity : activities) {
            totalCharge += activity.getCharge();
        }

        return totalCharge;
    }

    @Override
    public double calculateChargeMoyenne() {
        List<Activity> activities = getAllActivity();
        double totalCharge = 0;
        for (Activity activity : activities) {
            totalCharge += activity.getCharge();
        }
        return activities.size() > 0 ? totalCharge / activities.size() : 0;
    }

    @Override
    public double calculateEcartType() {
        List<Activity> activities = getAllActivity();
        double average = calculateChargeMoyenne();
        double sum = 0;
        for (Activity activity : activities) {
            sum += Math.pow((activity.getCharge() - average), 2);
        }
        return activities.size() > 0 ? Math.sqrt(sum / activities.size()) : 0;
    }

    @Override
    public double calculateMonotonie() {
        double averageCharge = calculateChargeMoyenne();
        double ecartType = calculateEcartType();
        if (ecartType != 0) {
            return averageCharge / ecartType;
        } else {
            throw new ArithmeticException("Division par O.");
        }
    }

    @Override
    public double calculateContrainte() {
        double totalCharge = calculateTotalCharge();
        double monotonie = calculateMonotonie();
        double contrainte;

        contrainte = totalCharge * monotonie;

        return contrainte;
    }

    @Override
    public double calculateFitness() {
        double totalCharge = calculateTotalCharge();
        double contrainte = calculateContrainte();
        double fitness;

        fitness = totalCharge * contrainte;

        return fitness;
    }

    @Override
    public TrainingState assessTrainingState() {
        double monotonie = calculateMonotonie();
        double contrainte = calculateContrainte();

        if (monotonie < 2 && contrainte < 6000) {
            return new TrainingState("#008000", "Entrainement optimal");
        } else if ((2 < monotonie && monotonie < 2.5) || (6000 < contrainte && contrainte < 10000)) {
            return new TrainingState("#FFA500", "État de fatigue");
        } else if (monotonie > 2.5 || contrainte > 10000) {
            return new TrainingState("#FF0000", "Attention ! Risque de blessure");
        } else {
            return new TrainingState("#000000", "RAS");
        }
    }

}
