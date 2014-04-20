package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.MealItem
import com.visionarysoftwaresolutions.smacker.api.meals.MealItems

class MealItemsList implements MealItems {
    List<MealItems> items = []

    @Override
    Iterator<MealItem> iterator() {
        items.iterator()
    }

    @Override
    void add(MealItem item) {
        items.add(item)
    }
}
