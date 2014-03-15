package com.visionarysoftwaresolutions.smacker.api.meals;

import java.util.Date;

public interface MealDay extends Comparable<MealDay> {
    String getMonth();
    String getDay();
    String getYear();
    Date asDate();
}
