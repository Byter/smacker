package com.visionarysoftwaresolutions.smacker.api.meals;

import com.visionarysoftwaresolutions.smacker.api.diet.Diet;
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay;

public interface MealPlanningStrategy {
    MealSchedule planMealsFor(Diet diet, CalendarDay day);
}
