package com.visionarysoftwaresolutions.smacker.api;

import com.visionarysoftwaresolutions.describable.Describable;
import org.joda.time.DateTime;

public interface User extends Describable {
    void log(Meal toLog);
    Meals getMealsForDate(DateTime targetDate);
}