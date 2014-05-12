package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.nutrition.NutritionalInformation
import com.visionarysoftwaresolutions.smacker.api.nutrition.analysis.NutritionalInformationCalculationStrategy

class BasicIntakeAnalyzer implements NutritionalInformationCalculationStrategy {

    public NutritionalInformation calculateFor(final Meal meal) {
        new DinnerNutrition()
    }
}
