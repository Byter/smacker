package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealValidationStrategy

class PaleoValidation implements MealValidationStrategy {
    final Paleo diet

    PaleoValidation(Paleo paleo) {
        diet = paleo
    }

    @Override
    boolean isValid(Meal meal) {
        return false
    }
}
