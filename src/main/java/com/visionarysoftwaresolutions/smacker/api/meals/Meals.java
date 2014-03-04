package com.visionarysoftwaresolutions.smacker.api.meals;

public interface Meals {
    void add(Meal toAdd);
    boolean has(Meal toCheck);
    boolean isEmpty();
}
