package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.MealViolatesDietException
import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealLog
import com.visionarysoftwaresolutions.smacker.api.meals.MealSchedule
import com.visionarysoftwaresolutions.smacker.api.meals.MealValidationStrategy

class Paleo extends AbstractDiet {
    @Override
    String getName() {
        return "Paleo"
    }

    @Override
    String getDescription() {
        return "The growingly popular Paleo diet"
    }
}
