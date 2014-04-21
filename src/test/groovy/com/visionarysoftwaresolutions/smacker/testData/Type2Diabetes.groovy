package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.BloodSugarLevel
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.Diabetes
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.Insulin
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime

class Type2Diabetes implements Diabetes {
    List<Insulin> insulins = []
    Map<CalendarTime, BloodSugarLevel> sugars = [:]

    @Override
    void add(Insulin toAdd) {
        insulins.add(toAdd)
    }

    @Override
    void log(BloodSugarLevel level) {
        sugars[TestFixtures.createMealTimeNow()] = level
    }
}
