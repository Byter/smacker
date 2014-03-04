package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.Meals

class NoMealsEaten implements Meals {
    @Override
    void add(Meal toAdd) {
        throw new UnsupportedOperationException("cannot add to null object")
    }

    @Override
    boolean has(Meal toCheck) {
        false
    }

    @Override
    boolean isEmpty() {
        true
    }
}
