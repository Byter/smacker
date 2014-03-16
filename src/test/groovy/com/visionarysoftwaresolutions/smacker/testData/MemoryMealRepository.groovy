package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime

abstract class MemoryMealRepository implements MealRepository {
	User belongsTo
	Map<CalendarDay, Meals> consumed = [:]

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
            } else if (it == date){
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
}
