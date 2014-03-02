package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.Meals

/**
 * User: Master
 * MealDay: 10/7/13
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
