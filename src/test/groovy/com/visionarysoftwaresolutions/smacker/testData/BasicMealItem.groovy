package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.MealItem
import com.visionarysoftwaresolutions.smacker.api.nutrition.NutritionalInformation
import com.visionarysoftwaresolutions.smacker.api.nutrition.PortionSize

class BasicMealItem implements MealItem {
    String name, description
    PortionSize consumed
    NutritionalInformation nut

    @Override
    PortionSize amountConsumed() {
        consumed
    }

    @Override
    NutritionalInformation getNutritionInformation() {
        nut
    }

    @Override
    String getName() {
        name
    }

    @Override
    String getDescription() {
        description
    }
}
