package com.visionarysoftwaresolutions.smacker.api.meals;

import com.visionarysoftwaresolutions.describable.Describable;
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay;

public interface Meal extends Describable {
    CalendarDay eatenAt();
    void addItem(MealItem eaten);
    MealItems getItems();
}
