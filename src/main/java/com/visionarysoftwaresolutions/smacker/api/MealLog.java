package com.visionarysoftwaresolutions.smacker.api;

import org.joda.time.DateTime;

/**
 * User: Master
 * Date: 10/6/13
 * Time: 11:50 PM
 */
public interface MealLog {
    User getOwner();
    void log(Meal toLog);
    Meals getMealsForDate(DateTime date);
}
