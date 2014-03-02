package com.visionarysoftwaresolutions.smacker.api.meals;

import com.visionarysoftwaresolutions.describable.Describable;
import com.visionarysoftwaresolutions.smacker.api.nutrition.NutritionalInformation;
import com.visionarysoftwaresolutions.smacker.api.nutrition.PortionSize;

public interface MealItem extends Describable {
    PortionSize amountConsumed();
    NutritionalInformation getNutritionInformation();
}
