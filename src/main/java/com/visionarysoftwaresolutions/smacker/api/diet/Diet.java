package com.visionarysoftwaresolutions.smacker.api.diet;

import com.visionarysoftwaresolutions.describable.Describable;
import com.visionarysoftwaresolutions.smacker.api.meals.MealLog;
import com.visionarysoftwaresolutions.smacker.api.meals.MealSchedule;

public interface Diet extends Describable {
    MealSchedule getMealSchedule();
    MealLog getMealLog();
}
