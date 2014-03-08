package com.visionarysoftwaresolutions.smacker.api;

import com.visionarysoftwaresolutions.describable.Describable;
import com.visionarysoftwaresolutions.smacker.api.meals.*;
import com.visionarysoftwaresolutions.smacker.api.meals.MealDay;
import com.visionarysoftwaresolutions.smacker.api.meals.Meals;
import com.visionarysoftwaresolutions.smacker.api.physique.Physique;
import groovy.lang.Closure;

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
}