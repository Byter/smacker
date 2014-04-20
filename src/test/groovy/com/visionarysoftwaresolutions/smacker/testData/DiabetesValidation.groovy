package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealValidationStrategy

class DiabetesValidation implements MealValidationStrategy {
    @Override
    boolean isValid(Meal meal) {
        def totalCarbsInGrams = 0.0d
        meal.items.each {
            totalCarbsInGrams += it.nutritionInformation.carbohydrates.total.value
        }
        totalCarbsInGrams < 100
    }
}
