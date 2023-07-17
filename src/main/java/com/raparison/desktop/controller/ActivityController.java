package com.raparison.desktop.controller;

import com.raparison.desktop.model.Activity;
import com.raparison.desktop.model.TrainingState;

public interface ActivityController {
    String saveActivity(Activity activity);

    double calculateTotalCharge();
    double calculateChargeMoyenne();
    double calculateEcartType();
    double calculateMonotonie();
    double calculateContrainte();
    double calculateFitness();
    TrainingState assessTrainingState();
}