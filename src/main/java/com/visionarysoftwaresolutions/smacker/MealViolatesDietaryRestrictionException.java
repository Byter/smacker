package com.visionarysoftwaresolutions.smacker;

import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestriction;
import com.visionarysoftwaresolutions.smacker.api.meals.Meal;

public class MealViolatesDietaryRestrictionException extends Exception {
    private final Meal violator;
    private final DietaryRestriction violated;

    public MealViolatesDietaryRestrictionException(final Meal meal, final DietaryRestriction restrict) {
        violator = meal;
        violated = restrict;
    }

    public Meal getMeal() { return violator; }
    public DietaryRestriction getDietaryRestriction() { return violated; }
}
