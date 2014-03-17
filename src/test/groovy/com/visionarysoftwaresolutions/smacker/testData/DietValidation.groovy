package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealValidationStrategy

class DietValidation implements MealValidationStrategy {
    final Diet toCheck

    DietValidation(Diet diet) {
        toCheck = diet
    }

    @Override
    boolean isValid(Meal meal) {
        if (toCheck instanceof AnythingDiet) {
            return true
        } else if (toCheck instanceof Paleo) {
            PaleoValidation validator = new PaleoValidation()
            return validator.isValid(meal)
        }
        return false
    }
}
