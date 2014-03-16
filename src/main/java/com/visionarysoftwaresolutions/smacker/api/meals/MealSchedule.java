package com.visionarysoftwaresolutions.smacker.api.meals;

import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime;

public interface MealSchedule extends MealRepository {
	void schedule(CalendarTime scheduled, Meal toSchedule);
    void addReminder(CalendarTime scheduled);
}
