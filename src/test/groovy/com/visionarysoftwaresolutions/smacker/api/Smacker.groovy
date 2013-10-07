package com.visionarysoftwaresolutions.smacker.api
/**
 * User: Master
 * MealDay: 10/7/13
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
    Meals getMealsFor(MealDay targetDate) {
        log.getMealsFor(targetDate)
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
