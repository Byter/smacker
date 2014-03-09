package com.visionarysoftwaresolutions.smacker.api.meals;

import java.util.Date;

public interface MealDay {
    String getMonth();
    String getDay();
    String getYear();
    Date asDate();
}
