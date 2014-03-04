package com.visionarysoftwaresolutions.smacker.api.meals;

public interface MealSchedule extends MealRepository {
	void schedule(MealTime scheduled, Meal toSchedule);
    void addReminder(MealTime scheduled);
}
