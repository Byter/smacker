package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Allergy
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealValidationStrategy

class AllergyValidation implements MealValidationStrategy {
    private final Allergy allergy

    public AllergyValidation(final Allergy allergy) {
        this.allergy = allergy
    }

    @Override
    boolean isValid(Meal meal) {
        meal.description.contains(allergy.allergen) || meal.name.contains(allergy.allergen)
    }
}
