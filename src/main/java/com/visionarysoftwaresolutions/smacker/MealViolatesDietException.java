package com.visionarysoftwaresolutions.smacker;

import com.visionarysoftwaresolutions.smacker.api.diet.Diet;
import com.visionarysoftwaresolutions.smacker.api.meals.Meal;

public class MealViolatesDietException extends Exception {
    private final Meal violator;
    private final Diet violated;

    public MealViolatesDietException(final Meal meal, final Diet restrict) {
        violator = meal;
        violated = restrict;
    }

    public Meal getMeal() { return violator; }
    public Diet getDiet() { return violated; }
}
