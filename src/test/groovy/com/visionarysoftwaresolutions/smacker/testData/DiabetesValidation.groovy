package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealValidationStrategy

class DiabetesValidation implements MealValidationStrategy {
    @Override
    boolean isValid(Meal meal) {
        return false
    }
}
