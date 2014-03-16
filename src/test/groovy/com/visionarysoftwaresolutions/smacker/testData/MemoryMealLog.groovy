package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay

class MemoryMealLog extends MemoryMealRepository implements MealLog {
    @Override
    void log(Meal toLog) {
        CalendarDay whenEaten = toLog.eatenAt()
        if (consumed.containsKey(whenEaten)) {
            Meals previouslyEaten = consumed.get(whenEaten)
            previouslyEaten.add(toLog)
        } else {
            Meals newlyEaten = new MealsList()
            newlyEaten.add(toLog)
            consumed.put(whenEaten, newlyEaten)
        }
    }
}
