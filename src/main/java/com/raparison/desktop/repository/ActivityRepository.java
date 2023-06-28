package com.raparison.desktop.repository;

import com.raparison.desktop.model.Activity;

import java.util.List;

public interface ActivityRepository {
    String save(Activity activity);

    List<Activity> getAll();
}
