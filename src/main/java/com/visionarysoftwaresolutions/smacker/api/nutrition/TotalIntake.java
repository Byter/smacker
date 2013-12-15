package com.visionarysoftwaresolutions.smacker.api.nutrition;

/**
 * Created with IntelliJ IDEA.
 * User: Master
 * Date: 12/14/13
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TotalIntake {
    Calories getCalories();
    Fat getFat();
    Cholesterol getCholesterol();
    Carbohydrates getCarbohydrates();
    Sodium getSodium();
    Protein getProtein();
    Vitamins getVitamins();
}
