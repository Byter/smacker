package com.visionarysoftwaresolutions.smacker.api.meals;

import com.visionarysoftwaresolutions.describable.Describable;
import com.visionarysoftwaresolutions.smacker.api.nutrition.TotalIntake;

import java.util.List;

/**
 * User: Master
 * MealDay: 10/6/13
 * Time: 11:14 PM
 */
public interface Meal extends Describable {
    MealDay eatenAt();
    void addItem(MealItem eaten);
    List<MealItem> getItems();
    TotalIntake getTotalIntake();
}
