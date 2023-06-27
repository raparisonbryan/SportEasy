package com.raparison.activity.repository;

import com.raparison.activity.model.Activity;

import java.util.List;

public interface ActivityRepository {
    String save(Activity activity);

    List<Activity> getAll();
}
