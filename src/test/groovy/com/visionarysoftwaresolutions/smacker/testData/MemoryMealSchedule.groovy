package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.events.MealScheduled
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealItem
import com.visionarysoftwaresolutions.smacker.api.meals.MealItems
import com.visionarysoftwaresolutions.smacker.api.meals.MealSchedule
import com.visionarysoftwaresolutions.smacker.api.meals.Meals
import com.visionarysoftwaresolutions.smacker.api.meals.ObservableMealSchedule
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime

class MemoryMealSchedule extends MemoryMealRepository implements ObservableMealSchedule {

    public void schedule(final CalendarTime scheduled, final Meal toSchedule) {
        Meals newlyEaten = new MealsList()
        newlyEaten.add(toSchedule)
        consumed.put(scheduled, newlyEaten)
        notifyObservers(new MealScheduled() {
            @Override
            CalendarTime getScheduledTime() {
                return scheduled
            }

            @Override
            User getUser() {
                return owner
            }

            @Override
            Meal getMeal() {
                return toSchedule
            }
        })
    }

    @Override
    void addReminder(CalendarTime scheduled) {
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
        schedule(scheduled, aMeal)
    }
}
