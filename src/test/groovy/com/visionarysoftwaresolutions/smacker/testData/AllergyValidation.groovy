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
        def allergen = allergy.allergen.toLowerCase()
        def invalid = meal.description.toLowerCase().contains(allergen) ||
        meal.name.toLowerCase().contains(allergen) ||
        meal.items.any { item ->
            item.name.toLowerCase().contains(allergen) ||
            item.description.toLowerCase().contains(allergen)
        }
        !invalid
    }
}
