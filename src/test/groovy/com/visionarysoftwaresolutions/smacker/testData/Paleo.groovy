package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.meals.MealLog
import com.visionarysoftwaresolutions.smacker.api.meals.MealSchedule

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
    String getName() {
        return null
    }

    @Override
    String getDescription() {
        return null
    }
}
