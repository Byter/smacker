package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealItem
import com.visionarysoftwaresolutions.smacker.api.meals.MealItems
import com.visionarysoftwaresolutions.smacker.api.nutrition.Calories
import com.visionarysoftwaresolutions.smacker.api.nutrition.Carbohydrates
import com.visionarysoftwaresolutions.smacker.api.nutrition.Cholesterol
import com.visionarysoftwaresolutions.smacker.api.nutrition.Fat
import com.visionarysoftwaresolutions.smacker.api.nutrition.NutritionalInformation
import com.visionarysoftwaresolutions.smacker.api.nutrition.Protein
import com.visionarysoftwaresolutions.smacker.api.nutrition.Sodium
import com.visionarysoftwaresolutions.smacker.api.nutrition.Vitamins
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay
import com.visionarysoftwaresolutions.smacker.api.units.Grams

class Dessert implements Meal {
    MealItems items = new MealItemsList()
    NutritionalInformation info = new NutritionalInformation() {
        @Override
        Calories getCalories() {
            return null
        }

        @Override
        Fat getFat() {
            return null
        }

        @Override
        Cholesterol getCholesterol() {
            return null
        }

        @Override
        Carbohydrates getCarbohydrates() {
            return new Carbohydrates() {
                @Override
                Grams getTotal() {
                    fiber + sugar
                }

                @Override
                Grams getFiber() {
                   new Gram(value: 0)
                }

                @Override
                Grams getSugar() {
                    new Gram(value: 105)
                }
            }
        }

        @Override
        Sodium getSodium() {
            return null
        }

        @Override
        Protein getProtein() {
            return null
        }

        @Override
        Vitamins getVitamins() {
            return null
        }
    }
    MealItem iceCream = new BasicMealItem(name:"Vanilla Ice cream", nut: info)

    public Dessert() {
        items.add(iceCream)
    }

    @Override
    CalendarDay eatenAt() {
        return null
    }

    @Override
    void addItem(MealItem eaten) {
        items.add(eaten)
    }

    @Override
    MealItems getItems() {
        items
    }

    @Override
    String getName() {
        return "Vanilla Ice cream"
    }

    @Override
    String getDescription() {
        return "Sweet vanilla ice creams"
    }
}
