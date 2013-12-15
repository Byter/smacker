package com.visionarysoftwaresolutions.smacker.api.meals;

import com.visionarysoftwaresolutions.smacker.api.User;

/**
 * User: Master
 * MealDay: 10/6/13
 * Time: 11:50 PM
 */
public interface MealLog {
    User getOwner();
    void log(Meal toLog);
    Meals getMealsFor(MealDay mealDay);
}
