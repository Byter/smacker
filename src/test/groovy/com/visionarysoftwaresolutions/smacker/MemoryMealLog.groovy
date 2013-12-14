package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.Meal
import com.visionarysoftwaresolutions.smacker.api.MealDay
import com.visionarysoftwaresolutions.smacker.api.MealLog
import com.visionarysoftwaresolutions.smacker.api.Meals
import com.visionarysoftwaresolutions.smacker.api.User

/**
 * User: Master
 * MealDay: 10/6/13
 * Time: 11:54 PM
 */
class MemoryMealLog implements MealLog {
    User belongsTo
    Meals meals = new MealsList();

    @Override
    User getOwner() {
        return belongsTo;
    }

    @Override
    void log(Meal toLog) {
        meals.add(toLog);
    }

    @Override
    Meals getMealsFor(MealDay date) {
        return meals
    }
}
