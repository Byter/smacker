package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.Meal;
import com.visionarysoftwaresolutions.smacker.api.nutrition.*;
import com.visionarysoftwaresolutions.smacker.api.nutrition.analysis.TotalIntakeAnalyzer

class BasicIntakeAnalyzer implements TotalIntakeAnalyzer {

	public NutritionalInformation calculateFor(final Meal meal) {
		new DinnerNutrition() 
	}
}
