package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.physique.Physique
import com.visionarysoftwaresolutions.smacker.api.physique.PhysiqueLog
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime

class MemoryPhysiqueLog implements PhysiqueLog {
    User owner
    Map<CalendarTime, Physique> stored = [:]

    @Override
    void log(Physique physique) {
        CalendarTime now = TestFixtures.createMealTimeNow()
        stored[now] = physique
    }

    @Override
    Physique getPhysiqueFor(CalendarTime mealTime) {
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
    void logFor(Physique physique, CalendarTime mealTime) {
        stored[mealTime] = physique
    }
}
