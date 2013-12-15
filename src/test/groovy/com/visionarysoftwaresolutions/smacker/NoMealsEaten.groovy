package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.Meals

/**
 * Created with IntelliJ IDEA.
 * User: Master
 * Date: 12/14/13
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
class NoMealsEaten implements Meals {
    @Override
    void add(Meal toAdd) {
        throw new UnsupportedOperationException("cannot add to null object")
    }

    @Override
    boolean has(Meal toCheck) {
        false
    }
}
