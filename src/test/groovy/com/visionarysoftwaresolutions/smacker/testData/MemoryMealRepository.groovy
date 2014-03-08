package com.visionarysoftwaresolutions.smacker.testData

import java.util.Map;

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
		consumed.get(date) ?: new NoMealsEaten()
	}
}
