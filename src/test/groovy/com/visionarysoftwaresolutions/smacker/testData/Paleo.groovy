package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.MealViolatesDietException
import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealLog
import com.visionarysoftwaresolutions.smacker.api.meals.MealSchedule
import com.visionarysoftwaresolutions.smacker.api.meals.MealValidationStrategy

class Paleo implements Diet {
    @Override
    MealSchedule getMealSchedule() {
        return null
    }

    @Override
    MealLog getMealLog() {
        return null
    }

    @Override
    boolean isAcceptable(Meal toCheck) {
        return validateDiet(toCheck)
    }

    def validateDiet(final Meal meal) {
        MealValidationStrategy checker = new DietValidation(this)

        def valid = checker.isValid(meal)
        if (!valid) {
            throw new MealViolatesDietException(meal, this)
        }
        valid
    }

    @Override
    String getName() {
        return "Paleo"
    }

    @Override
    String getDescription() {
        return "The growingly popular Paleo diet"
    }
}
