package com.visionarysoftwaresolutions.smacker.api.meals;

public interface MealItems extends Iterable<MealItem> {
    void add(MealItem item);
}
