package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealValidationStrategy

class VeganValidation implements MealValidationStrategy {
    def naughtyWords = [ "beef", "chicken", "tuna", "pork", "fish", "egg", "cow", "bacon", "anything good"]
    @Override
    boolean isValid(final Meal meal) {
        !naughtyWords.any { it ->
            meal.description.contains(it) || meal.name.contains(it)
        }
    }
}
