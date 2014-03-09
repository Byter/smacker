package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.api.User

class MemoryMealSchedule extends MemoryMealRepository implements MealSchedule {

	public void schedule(MealTime scheduled, Meal toSchedule) {
        Meals newlyEaten = new MealsList()
        newlyEaten.add(toSchedule)
        consumed.put(scheduled, newlyEaten)
    }

    @Override
    void addReminder(MealTime scheduled) {
        Meals toEat = new MealsList()
        Meal aMeal = new Meal() {

            @Override
            MealDay eatenAt() {
                scheduled
            }

            @Override
            void addItem(MealItem eaten) {

            }

            @Override
            List<MealItem> getItems() {
                return null
            }

            @Override
            String getName() {
                return null
            }

            @Override
            String getDescription() {
                return null
            }
        }
        toEat.add(aMeal)
        consumed.put(scheduled, toEat)
    }
}
