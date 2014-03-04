package com.visionarysoftwaresolutions.smacker.testData

import java.util.Map;

import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.api.User

abstract class MemoryMealRepository implements MealRepository {
	User belongsTo
	Map<MealDay, Meals> consumed = [:];

	@Override
	User getOwner() {
		return belongsTo;
	}
	
	@Override
	Meals getMealsFor(MealDay date) {
		Meals found = consumed.get(date)
		found ? found : new NoMealsEaten()
	}
}
