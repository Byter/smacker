package com.visionarysoftwaresolutions.smacker.api

import org.joda.time.DateTime

/**
 * User: Master
 * Date: 10/6/13
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
    Meals getMealsForDate(DateTime date) {
        return meals
    }
}
