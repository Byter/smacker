package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestriction
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Vegan
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealValidationStrategy

class DietaryRestrictionValidation implements MealValidationStrategy {
    final DietaryRestriction prohibited;

    DietaryRestrictionValidation(DietaryRestriction dietaryRestriction) {
        prohibited = dietaryRestriction;
    }

    @Override
    boolean isValid(final Meal meal) {
        if (prohibited instanceof Vegan) {
            VeganValidation validation = new VeganValidation()
            return validation.isValid(meal)
        }
        false
    }
}
