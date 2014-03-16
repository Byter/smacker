package com.visionarysoftwaresolutions.smacker.api.meals;

import com.visionarysoftwaresolutions.smacker.api.User;
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay;

public interface MealRepository {
    User getOwner();
    Meals getMealsFor(CalendarDay calendarDay);
}