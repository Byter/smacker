package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.Meal
import com.visionarysoftwaresolutions.smacker.api.MealDay
import com.visionarysoftwaresolutions.smacker.api.MealItem

/**
 * Created with IntelliJ IDEA.
 * User: Master
 * Date: 12/14/13
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
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
