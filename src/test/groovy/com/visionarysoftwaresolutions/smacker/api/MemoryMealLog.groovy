package com.visionarysoftwaresolutions.smacker.api

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
