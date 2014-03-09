package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.MealDay
import com.visionarysoftwaresolutions.smacker.api.meals.MealTime
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class RightNow implements MealTime {
    Calendar now = Calendar.getInstance()

    @Override
    String getHour() {
        String.format('%tH', now)
    }

    @Override
    String getMinute() {
        String.format('%tM', now)
    }

    @Override
    String getMonth() {
        String.format('%tB', now)
    }

    @Override
    String getDay() {
        String.format('%td', now)
    }

    @Override
    String getYear() {
        String.format('%tY', now)
    }

    @Override
    Date asDate() {
        now.getTime()
    }

    @Override
    boolean isOnSameDay(MealDay another) {
        year == another.year && month == another.month && day == another.day
    }
}
