package com.visionarysoftwaresolutions.smacker.api.meals;

public interface MealValidationStrategy {
    boolean isValid(Meal meal);
}
