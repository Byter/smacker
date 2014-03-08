package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.api.User

class MemoryMealSchedule extends MemoryMealRepository implements MealSchedule {

	public void schedule(MealTime scheduled, Meal toSchedule) {
		if (consumed.containsKey(scheduled)) {
            Meals previouslyEaten = consumed.get(scheduled)
            previouslyEaten.add(toSchedule)
        } else {
            Meals newlyEaten = new MealsList()
            newlyEaten.add(toSchedule)
            consumed.put(scheduled, newlyEaten)
        }
	}

    @Override
    void addReminder(MealTime scheduled) {
        Meals toEat = new MealsList()
        toEat.add([ eatenAt : scheduled ] as Meal)
        consumed.put(scheduled, toEat)
    }
}
