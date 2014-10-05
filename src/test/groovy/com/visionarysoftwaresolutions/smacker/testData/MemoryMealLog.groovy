package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.events.MealLogged
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealLog
import com.visionarysoftwaresolutions.smacker.api.meals.Meals
import com.visionarysoftwaresolutions.smacker.api.meals.ObservableMealLog
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay

class MemoryMealLog extends MemoryMealRepository implements ObservableMealLog {
    @Override
    void log(final Meal toLog) {
        CalendarDay whenEaten = toLog.eatenAt()
        if (consumed.containsKey(whenEaten)) {
            Meals previouslyEaten = consumed.get(whenEaten)
            previouslyEaten.add(toLog)
        } else {
            Meals newlyEaten = new MealsList()
            newlyEaten.add(toLog)
            consumed.put(whenEaten, newlyEaten)
        }
        notifyObservers(new MealLogged() {
            @Override
            User getUser() {
                return getOwner()
            }

            @Override
            Meal getMeal() {
                return toLog
            }
        })
    }
}
