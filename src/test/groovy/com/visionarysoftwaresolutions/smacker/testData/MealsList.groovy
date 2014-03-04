package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.Meals

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

    @Override
    boolean isEmpty() {
        return meals.isEmpty()
    }
}
