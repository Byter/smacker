package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.eventr.EventMediator
import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.meals.Meals
import com.visionarysoftwaresolutions.smacker.api.meals.ObservableMealRepository
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime
import com.visionarysoftwaresolutions.eventr.*

abstract class MemoryMealRepository implements ObservableMealRepository {
    User belongsTo
    Map<CalendarDay, Meals> consumed = [:]
    EventMediator mediator = new MealEventManager()

    @Override
    User getOwner() {
        belongsTo
    }

    @Override
    Meals getMealsFor(CalendarDay date) {
        if (consumed.keySet().any { it -> it instanceof CalendarTime }) {
            findMealDayFor(date)
        } else {
            consumed.get(date) ?: new NoMealsEaten()
        }
    }

    Meals findMealDayFor(CalendarDay date) {
        Meals meals = new MealsList()
        consumed.keySet().each { it ->
            if (hasMealTimeFor(it, date)) {
                addAllMeals(meals, it)
            } else if (it == date) {
                meals = consumed.get(it)
            }
        }
        meals
    }

    boolean hasMealTimeFor(CalendarDay toCheck, CalendarDay lookingFor) {
        toCheck instanceof CalendarTime && ((CalendarTime) toCheck).isOnSameDay(lookingFor)
    }

    def void addAllMeals(Meals meals, CalendarTime it) {
        Meals stored = consumed.get(it)
        stored.each { meal ->
            meals.add(meal)
        }
    }

    @Override
    void notifyObservers(Event event) {
        mediator.notifyObserversForObservable(this, event)
    }

    @Override
    void add(Observer toAdd) {
        mediator.register(this, toAdd)
    }

    @Override
    void remove(Observer toRemove) {
        mediator.unregister(this, toRemove)
    }
}
