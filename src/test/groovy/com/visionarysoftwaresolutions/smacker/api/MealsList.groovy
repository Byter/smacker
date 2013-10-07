package com.visionarysoftwaresolutions.smacker.api

/**
 * User: Master
 * Date: 10/7/13
 * Time: 12:05 AM
 */
class MealsList implements Meals {
    List<Meal> meals = []

    @Override
    void add(Meal toAdd) {
        meals.add(toAdd)
    }

    @Override
    boolean has(Meal toCheck) {
        meals.contains(toCheck)
    }
}
