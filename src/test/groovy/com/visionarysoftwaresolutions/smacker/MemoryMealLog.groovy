package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealDay
import com.visionarysoftwaresolutions.smacker.api.meals.MealLog
import com.visionarysoftwaresolutions.smacker.api.meals.Meals
import com.visionarysoftwaresolutions.smacker.api.User

/**
 * User: Master
 * MealDay: 10/6/13
 * Time: 11:54 PM
 */
class MemoryMealLog implements MealLog {
    User belongsTo
    Map<MealDay, Meals> consumed = [:];

    @Override
    User getOwner() {
        return belongsTo;
    }

    @Override
    void log(Meal toLog) {
        MealDay whenEaten = toLog.eatenAt()
        if (consumed.containsKey(whenEaten)) {
            Meals previouslyEaten = consumed.get(whenEaten)
            previouslyEaten.add(toLog)
        } else {
            Meals newlyEaten = new MealsList()
            newlyEaten.add(toLog)
            consumed.put(whenEaten, newlyEaten)
        }
    }

    @Override
    Meals getMealsFor(MealDay date) {
        Meals found = consumed.get(date)
        found ? found : new NoMealsEaten()
    }
}
