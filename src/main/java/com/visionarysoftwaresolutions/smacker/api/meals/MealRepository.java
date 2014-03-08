package com.visionarysoftwaresolutions.smacker.api.meals;

import com.visionarysoftwaresolutions.smacker.api.User;

public interface MealRepository {
    User getOwner();
    Meals getMealsFor(MealDay mealDay);
}