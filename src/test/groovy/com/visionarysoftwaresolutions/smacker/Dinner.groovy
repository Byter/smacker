package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealDay
import com.visionarysoftwaresolutions.smacker.api.meals.MealItem
import com.visionarysoftwaresolutions.smacker.api.nutrition.TotalIntake

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
    TotalIntake getTotalIntake() {
        //TODO: iterate across items. Grab nutritional info.
        // sum up and create total intake object.
        return null  //To change body of implemented methods use File | Settings | File Templates.
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
