package com.visionarysoftwaresolutions.smacker.api.meals.planning;

import com.visionarysoftwaresolutions.smacker.api.meals.Meal;
import com.visionarysoftwaresolutions.smacker.api.meals.MealRepository;
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime;

public interface MealSchedule extends MealRepository {
	void schedule(CalendarTime scheduled, Meal toSchedule);
    void addReminder(CalendarTime scheduled);
}
