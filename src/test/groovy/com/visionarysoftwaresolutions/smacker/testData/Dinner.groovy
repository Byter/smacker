package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealItem
import com.visionarysoftwaresolutions.smacker.api.meals.MealItems
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay

class Dinner implements Meal {
    MealItems items = new MealItemsList()

    @Override
    CalendarDay eatenAt() {
        [year: "2013", month: "October", day: "6"] as CalendarDay
    }

    @Override
    void addItem(MealItem eaten) {
        items.add(eaten)
    }

    @Override
    MealItems getItems() {
        items
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
