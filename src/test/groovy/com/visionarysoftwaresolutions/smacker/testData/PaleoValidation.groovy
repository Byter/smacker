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
        return isNotDairy(meal) && isNotGrain(meal) && isNotLegume(meal)
    }

    boolean isNotDairy(Meal meal) {
        def name = meal.name
        name.contains("milk") || name.contains("ice cream")
    }

    boolean isNotGrain(Meal meal) {
        def name = meal.name
        name.contains("bread") || name.contains("wheat")
    }

    boolean isNotLegume(Meal meal) {
        def name = meal.name
        name.contains("bean")
    }
}
