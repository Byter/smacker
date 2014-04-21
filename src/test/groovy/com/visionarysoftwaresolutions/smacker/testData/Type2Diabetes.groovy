package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.BloodSugarLevel
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Diabetes
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime

class Type2Diabetes implements Diabetes {
    List<String> insulins = []
    Map<CalendarTime, BloodSugarLevel> sugars = [:]

    @Override
    void addInsulin(String name) {
        insulins.add(name)
    }

    @Override
    void log(BloodSugarLevel level) {
        sugars[TestFixtures.createMealTimeNow()] = level
    }
}
