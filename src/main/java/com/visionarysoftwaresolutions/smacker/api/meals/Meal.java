package com.visionarysoftwaresolutions.smacker.api.meals;

import java.util.List;

import com.visionarysoftwaresolutions.describable.Describable;

public interface Meal extends Describable {
    MealDay eatenAt();
    void addItem(MealItem eaten);
    List<MealItem> getItems();
}
