package com.visionarysoftwaresolutions.smacker.api.meals;

public interface Meals extends Iterable<Meal> {
    void add(Meal toAdd);
    boolean has(Meal toCheck);
    boolean isEmpty();
}
