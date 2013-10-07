package com.visionarysoftwaresolutions.smacker.api;

import com.visionarysoftwaresolutions.describable.Describable;

public interface User extends Describable {
    void log(Meal toLog);
    Meals getMealsFor(MealDay targetMealDay);
}