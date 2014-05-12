package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.MealViolatesDietException
import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealLog
import com.visionarysoftwaresolutions.smacker.api.meals.planning.MealSchedule
import com.visionarysoftwaresolutions.smacker.api.meals.MealValidationStrategy

abstract class AbstractDiet implements Diet {
    User owner;
    String name, description;
    MealSchedule mealSchedule = new MemoryMealSchedule(belongsTo: owner)
    MealLog mealLog = new MemoryMealLog(belongsTo: owner)

    @Override
    public boolean isAcceptable(final Meal meal) {
        MealValidationStrategy checker = new DietValidation(this)

        def valid = checker.isValid(meal)
        if (!valid) {
            throw new MealViolatesDietException(meal, this)
        }
        valid
    }
}
