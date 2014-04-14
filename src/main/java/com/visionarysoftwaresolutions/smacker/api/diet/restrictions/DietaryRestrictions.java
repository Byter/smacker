package com.visionarysoftwaresolutions.smacker.api.diet.restrictions;

import com.visionarysoftwaresolutions.smacker.api.meals.Meal;

public interface DietaryRestrictions {
    boolean isEmpty();
    boolean contains(DietaryRestriction toCheck);
    boolean hasAllergies();
    boolean isAllergicTo(String allergen);
    boolean isVegetarian();
    boolean isVegan();
    void add(DietaryRestriction toAdd);
    boolean isKosher();
    boolean isHalal();
    boolean meetsRestrictions(Meal toCheck);

}
