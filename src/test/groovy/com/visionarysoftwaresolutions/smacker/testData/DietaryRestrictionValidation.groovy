package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Allergy
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Diabetes
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
        } else if (prohibited instanceof Allergy) {
            AllergyValidation validation = new AllergyValidation(prohibited)
            return validation.isValid(meal)
        } else if(prohibited instanceof Diabetes) {
            DiabetesValidation validation = new DiabetesValidation()
            return validation.isValid(meal)
        }
        false
    }
}
