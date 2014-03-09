package com.visionarysoftwaresolutions.smacker.api;

import com.visionarysoftwaresolutions.describable.Describable;
import com.visionarysoftwaresolutions.smacker.api.diet.Diabetes;
import com.visionarysoftwaresolutions.smacker.api.diet.DietaryRestriction;
import com.visionarysoftwaresolutions.smacker.api.meals.*;
import com.visionarysoftwaresolutions.smacker.api.meals.MealDay;
import com.visionarysoftwaresolutions.smacker.api.meals.Meals;
import com.visionarysoftwaresolutions.smacker.api.physique.Physique;
import groovy.lang.Closure;

import java.util.List;
import java.util.Set;

public interface User extends Describable {
    void log(Meal toLog);
    Meals getMealsFor(MealDay targetMealDay);
    void schedule(MealTime mealTime, Meal planned);
    Meals plannedMealsOn(MealDay targetDay);
    void createReminder(MealTime mealTime);
    void receive(MealNotification notification);
    void log(Physique physique);
    void logFor(Physique physique, MealTime time);
    Physique getPhysiqueFor(MealTime time);
    void addDietaryRestriction(DietaryRestriction restriction);
    Set<DietaryRestriction> getDietaryRestrictions();
    void addAllergy(String allergen, String severity);
}