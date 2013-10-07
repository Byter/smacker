package com.visionarysoftwaresolutions.smacker.api;

/**
 * User: Master
 * MealDay: 10/6/13
 * Time: 11:59 PM
 */
public interface Meals {
    void add(Meal toAdd);
    boolean has(Meal toCheck);
}
