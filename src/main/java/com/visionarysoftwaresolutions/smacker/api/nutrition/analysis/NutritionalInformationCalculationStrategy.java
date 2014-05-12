package com.visionarysoftwaresolutions.smacker.api.nutrition.analysis;

import com.visionarysoftwaresolutions.smacker.api.meals.Meal;
import com.visionarysoftwaresolutions.smacker.api.nutrition.NutritionalInformation;

public interface NutritionalInformationCalculationStrategy {
    NutritionalInformation calculateFor(Meal meal);
}
