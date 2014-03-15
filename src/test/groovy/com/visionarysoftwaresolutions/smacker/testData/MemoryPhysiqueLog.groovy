package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.meals.MealTime
import com.visionarysoftwaresolutions.smacker.api.physique.Physique
import com.visionarysoftwaresolutions.smacker.api.physique.PhysiqueLog

class MemoryPhysiqueLog implements PhysiqueLog {
    User owner
    Map<MealTime, Physique> stored = [:]

    @Override
    void log(Physique physique) {
        MealTime now = TestFixtures.createMealTimeNow()
        stored[now] = physique
    }

    @Override
    Physique getPhysiqueFor(MealTime mealTime) {
        println mealTime
        Physique result
        if (stored.containsKey(mealTime)) {
            result = stored[mealTime]
        } else {
            def closest = stored.min { it -> it.key.compareTo mealTime }
            result = stored[closest.key]
        }
        result
    }

    @Override
    void logFor(Physique physique, MealTime mealTime) {
        stored[mealTime] = physique
    }
}
