package com.raparison.desktop.controller;

import com.raparison.desktop.model.Activity;

public interface ActivityController {
    String saveActivity(Activity activity);

    int calculateCharge(int duration, int RPE);
}