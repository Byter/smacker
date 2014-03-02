package com.visionarysoftwaresolutions.smacker.api.meals;

import com.visionarysoftwaresolutions.smacker.api.User;

public interface MealLog {
    User getOwner();
    void log(Meal toLog);
    Meals getMealsFor(MealDay mealDay);
}
