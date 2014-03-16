package com.visionarysoftwaresolutions.smacker.api;

import com.visionarysoftwaresolutions.describable.Describable;
import com.visionarysoftwaresolutions.smacker.api.diet.Diet;
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Allergy;
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestriction;
import com.visionarysoftwaresolutions.smacker.api.meals.*;
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay;
import com.visionarysoftwaresolutions.smacker.api.meals.Meals;
import com.visionarysoftwaresolutions.smacker.api.physique.Physique;
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime;

import java.util.Set;

public interface User extends Describable {
    void log(Meal toLog);
    Meals getMealsFor(CalendarDay targetCalendarDay);
    void schedule(CalendarTime mealTime, Meal planned);
    Meals plannedMealsOn(CalendarDay targetDay);
    void createReminder(CalendarTime mealTime);
    void receive(MealNotification notification);
    void log(Physique physique);
    void logFor(Physique physique, CalendarTime time);
    Physique getPhysiqueFor(CalendarTime time);
    void addDietaryRestriction(DietaryRestriction restriction);
    Set<DietaryRestriction> getDietaryRestrictions();
    void addAllergy(Allergy allergy);
    void setDiet(Diet diet);
    Diet getDiet();
    void setContactInformation(ContactInformation info);
    ContactInformation getContactInformation();
}