package com.visionarysoftwaresolutions.smacker.api;

import com.visionarysoftwaresolutions.describable.Describable;
import com.visionarysoftwaresolutions.smacker.api.meals.Meal;
import com.visionarysoftwaresolutions.smacker.api.meals.MealDay;
import com.visionarysoftwaresolutions.smacker.api.meals.Meals;

public interface User extends Describable {
    void log(Meal toLog);
    Meals getMealsFor(MealDay targetMealDay);
}