package com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes;

import com.visionarysoftwaresolutions.smacker.api.meals.Meal;

public interface InsulinDoseCalculationStrategy {
    InsulinDosageRecommendation calculate(
        Diabetes diabetes,
        Meal meal);
}
