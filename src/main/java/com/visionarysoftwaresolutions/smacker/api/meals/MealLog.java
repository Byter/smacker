package com.visionarysoftwaresolutions.smacker.api.meals;

public interface MealLog extends MealRepository {
    void log(Meal toLog);
}
