package com.visionarysoftwaresolutions.smacker.api.meals;

import com.visionarysoftwaresolutions.describable.Describable;
import com.visionarysoftwaresolutions.smacker.api.nutrition.NutritionalInformation;
import com.visionarysoftwaresolutions.smacker.api.nutrition.PortionSize;

/**
 * Created with IntelliJ IDEA.
 * User: Master
 * Date: 12/14/13
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MealItem extends Describable {
    PortionSize amountConsumed();
    NutritionalInformation getNutritionInformation();
}
