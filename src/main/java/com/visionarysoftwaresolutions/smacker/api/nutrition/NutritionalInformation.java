package com.visionarysoftwaresolutions.smacker.api.nutrition;

public interface NutritionalInformation {
	Calories getCalories();
    Fat getFat();
    Cholesterol getCholesterol();
    Carbohydrates getCarbohydrates();
    Sodium getSodium();
    Protein getProtein();
    Vitamins getVitamins();
}
