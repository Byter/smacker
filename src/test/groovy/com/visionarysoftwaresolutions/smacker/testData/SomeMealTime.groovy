package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.MealDay
import com.visionarysoftwaresolutions.smacker.api.meals.MealTime
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class SomeMealTime implements MealTime {
    Calendar cal = Calendar.getInstance()

    SomeMealTime(Date target) {
        cal.setTime(target)
    }

    @Override
    String getHour() {
        String.format('%tH', cal)
    }

    @Override
    String getMinute() {
        String.format('%tM', cal)
    }

    @Override
    boolean isOnSameDay(MealDay another) {
        year == another.year && month == another.month && day == another.day
    }

    @Override
    String getMonth() {
        String.format('%tB', cal)
    }

    @Override
    String getDay() {
        String.format('%td', cal)
    }

    @Override
    String getYear() {
        String.format('%tY', cal)
    }

    @Override
    Date asDate() {
        cal.getTime()
    }

    @Override
    int compareTo(MealDay o) {
        asDate().compareTo(o?.asDate())
    }
}
