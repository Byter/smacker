package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.MealDay
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Today implements MealDay {
    Calendar current = Calendar.getInstance()

    @Override
    String getMonth() {
        String.format("%tB", current)
    }

    @Override
    String getDay() {
        String.format("%td", current)
    }

    @Override
    String getYear() {
        String.format("%tY", current)
    }

    @Override
    Date asDate() {
        current.getTime()
    }
}
