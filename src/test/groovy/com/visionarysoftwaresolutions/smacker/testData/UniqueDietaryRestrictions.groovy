package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.MealViolatesDietaryRestrictionException
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Allergy
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestriction
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestrictions
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Halal
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Kosher
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Vegan
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Vegetarian
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealValidationStrategy

class UniqueDietaryRestrictions implements DietaryRestrictions {
    Set<DietaryRestriction> restrictions = [] as Set<DietaryRestriction>

    @Override
    boolean isEmpty() {
        restrictions.isEmpty()
    }

    @Override
    boolean contains(DietaryRestriction toCheck) {
        restrictions.contains(toCheck)
    }

    @Override
    boolean hasAllergies() {
        restrictions.find { DietaryRestriction it -> it instanceof Allergy }
    }

    @Override
    boolean isAllergicTo(String allergen) {
        Collection<Allergy> allergies = restrictions.grep { it instanceof Allergy }
        allergies.find { Allergy it -> it.allergen == allergen }
    }

    @Override
    boolean isVegetarian() {
        restrictions.find { it instanceof Vegetarian }
    }

    @Override
    boolean isVegan() {
        restrictions.find { it instanceof Vegan }
    }

    @Override
    void add(DietaryRestriction toAdd) {
        restrictions << toAdd
    }

    @Override
    boolean isKosher() {
        restrictions.find { it instanceof Kosher }
    }

    @Override
    boolean isHalal() {
        restrictions.find { it instanceof Halal }
    }

    @Override
    boolean meetsRestrictions(Meal meal) {
        restrictions.each { it ->
            validateDietaryRestriction(meal, it)
        }
    }

    void validateDietaryRestriction(Meal meal, DietaryRestriction it) {
        MealValidationStrategy checker = new DietaryRestrictionValidation(it)

        def valid = checker.isValid(meal)
        if (!valid) {
            throw new MealViolatesDietaryRestrictionException(meal, it)
        }
        valid
    }
}
