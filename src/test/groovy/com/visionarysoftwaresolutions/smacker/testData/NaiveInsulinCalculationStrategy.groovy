package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.Diabetes
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.InsulinDosageRecommendation
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.InsulinDoseCalculationStrategy
import com.visionarysoftwaresolutions.smacker.api.meals.Meal

class NaiveInsulinCalculationStrategy implements InsulinDoseCalculationStrategy {

    @Override
    InsulinDosageRecommendation calculate(final Diabetes diabetes, final Meal meal) {
        new InsulinDosageRecommendation() {
            @Override
            User getUser() {
                diabetes.user
            }

            @Override
            Meal getMeal() {
                meal
            }
        }
    }
}
