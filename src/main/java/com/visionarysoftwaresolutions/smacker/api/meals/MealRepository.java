package com.visionarysoftwaresolutions.smacker.api.meals;

import com.visionarysoftwaresolutions.smacker.api.User;

public interface MealRepository {

	public abstract User getOwner();

	public abstract Meals getMealsFor(MealDay mealDay);

}