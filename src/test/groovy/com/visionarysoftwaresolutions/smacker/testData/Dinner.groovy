package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealDay
import com.visionarysoftwaresolutions.smacker.api.meals.MealItem

class Dinner implements Meal {
    List<MealItem> items = []
    @Override
    MealDay eatenAt() {
        [ year:"2013", month:"October", day:"6"] as MealDay
    }

    @Override
    void addItem(MealItem eaten) {
        items += eaten
    }

    @Override
    List<MealItem> getItems() {
        Collections.unmodifiableList(items)
    }

    @Override
    String getName() {
        "dinner"
    }

    @Override
    String getDescription() {
        "2 cans of tuna and fiber plus bar"
    }
}
