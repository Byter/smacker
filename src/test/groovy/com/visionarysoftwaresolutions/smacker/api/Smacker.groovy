package com.visionarysoftwaresolutions.smacker.api

import org.joda.time.DateTime

/**
 * User: Master
 * Date: 10/7/13
 * Time: 12:21 AM
 */
class Smacker implements User {
    String name, description
    MealLog log = new MemoryMealLog(belongsTo: this)

    @Override
    void log(Meal toLog) {
        log.log(toLog)
    }

    @Override
    Meals getMealsForDate(DateTime targetDate) {
        log.getMealsForDate(targetDate)
    }

    @Override
    String getName() {
        name
    }

    @Override
    String getDescription() {
        description
    }
}
