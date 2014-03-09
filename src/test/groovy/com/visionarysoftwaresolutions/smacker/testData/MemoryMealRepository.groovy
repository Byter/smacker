package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.api.User

abstract class MemoryMealRepository implements MealRepository {
	User belongsTo
	Map<MealDay, Meals> consumed = [:]

	@Override
	User getOwner() {
		belongsTo
	}
	
	@Override
	Meals getMealsFor(MealDay date) {
        if (consumed.keySet().any { it -> it instanceof MealTime }) {
            findMealDayFor(date)
        } else {
            consumed.get(date) ?: new NoMealsEaten()
        }
	}

    Meals findMealDayFor(MealDay date) {
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

    boolean hasMealTimeFor(MealDay toCheck, MealDay lookingFor) {
        toCheck instanceof MealTime && ((MealTime) toCheck).isOnSameDay(lookingFor)
    }

    def void addAllMeals(Meals meals, MealTime it) {
        Meals stored = consumed.get(it)
        stored.each { meal ->
            meals.add(meal)
        }
    }
}
