package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealItem
import com.visionarysoftwaresolutions.smacker.api.meals.MealItems
import com.visionarysoftwaresolutions.smacker.api.meals.MealSchedule
import com.visionarysoftwaresolutions.smacker.api.meals.Meals
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime

class MemoryMealSchedule extends MemoryMealRepository implements MealSchedule {

    public void schedule(CalendarTime scheduled, Meal toSchedule) {
        Meals newlyEaten = new MealsList()
        newlyEaten.add(toSchedule)
        consumed.put(scheduled, newlyEaten)
    }

    @Override
    void addReminder(CalendarTime scheduled) {
        Meals toEat = new MealsList()
        Meal aMeal = new Meal() {
            MealItems items = new MealItemsList()
            @Override
            CalendarDay eatenAt() {
                scheduled
            }

            @Override
            void addItem(MealItem eaten) {
                items.add(eaten)
            }

            @Override
            MealItems getItems() {
                items
            }

            @Override
            String getName() {
                "planned meal"
            }

            @Override
            String getDescription() {
                "meal planned @ ${eatenAt()}"
            }
        }
        toEat.add(aMeal)
        consumed.put(scheduled, toEat)
    }
}
