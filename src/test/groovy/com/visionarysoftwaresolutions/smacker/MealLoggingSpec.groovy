package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.nutrition.Calories
import com.visionarysoftwaresolutions.smacker.api.nutrition.Carbohydrates
import com.visionarysoftwaresolutions.smacker.api.nutrition.Cholesterol
import com.visionarysoftwaresolutions.smacker.api.nutrition.Fat
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealDay
import com.visionarysoftwaresolutions.smacker.api.meals.MealItem
import com.visionarysoftwaresolutions.smacker.api.meals.Meals
import com.visionarysoftwaresolutions.smacker.api.nutrition.Protein
import com.visionarysoftwaresolutions.smacker.api.nutrition.Sodium
import com.visionarysoftwaresolutions.smacker.api.nutrition.TotalIntake
import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.nutrition.Vitamins

/**
 * User: Master
 * MealDay: 10/6/13
 * Time: 10:50 PM
 */
class MealLoggingSpec extends spock.lang.Specification {
    def "create a meal for nick"() {
        given: "the existence of a user Nick"
            User nick = TestFixtures.createNick()
        and: "Nick eats a meal at 6 pm of 2 cans of tuna and a fiber plus bar"
            Meal dinner = TestFixtures.createDinner()
            MealItem canOTuna = TestFixtures.canOTuna()
            MealItem fiberPlusBar = TestFixtures.fiberPlusBar()
            dinner.addItem(canOTuna)
            dinner.addItem(canOTuna)
            dinner.addItem(fiberPlusBar)
        when: "nick logs the meal"
            nick.log(dinner)
        then: "the meal log for october 6th contains dinner"
            Meals eaten = nick.getMealsFor([
                    month:"October",
                    day: "6",
                    year: "2013"] as MealDay)
            eaten.has(dinner) == true
        and: "dinner has the 2 cans of tuna and a fiber plus bar"
            List<MealItem> dishes = dinner.getItems()
            dishes == [ canOTuna, canOTuna, fiberPlusBar ]
        and: "dinner has a total intake"
            TotalIntake intake = dinner.getTotalIntake()
            intake != null
        and: "intake has calories with 340 kCal total, 60 from fat"
            Calories calories = intake.getCalories()
            calories.total == 340
            calories.fromFat == 60
        and: "intake has fat with total 6g, sat fat 2g, trans 0g"
            Fat fat = intake.getFat()
            fat.total == 6
            fat.fromSaturated == 2
            fat.fromTrans == 0
        and: "intake has total cholesterol of 8 g"
            Cholesterol chloe = intake.getCholesterol()
            chloe.total == 8
        and: "intake has total sodium of 4.35g"
            Sodium sod = intake.getSodium()
            sod.total == 4.35
        and: "intake has total carbohydrates of 26g, 9g fiber, 7g sugar"
            Carbohydrates carbs = intake.getCarbohydrates()
            carbs.total == 26
            carbs.fiber == 9
            carbs.sugar == 7
        and: "intake has total protein of 50g"
            Protein pro = intake.getProtein()
            pro.total == 50
        and: "intake has vitamins"
            Vitamins vita = intake.getVitamins()
            vita != null
        and: "Vitamin A is 0%"
            vita.getPercent("A") == 0
        and: "Vitamin C is 0%"
            vita.getPercent("C") == 0
        and: "Calcium is 10%"
            vita.getPercent("Calcium") == 10
        and: "Iron is 12%"
            vita.getPercent("Iron") == 12
        and: "Zinc is 20%"
            vita.getPercent("Zinc") == 20
        and: "Vitamin D is 24%"
            vita.getPercent("D") == 24
        and: "Niacin is 140%"
            vita.getPercent("Niacin") == 140
        and: "B6 is 24%"
            vita.getPercent("B6") == 24
        and: "B12 is 40%"
            vita.getPercent("B12") == 40
        and: "Selenium is 280%"
            vita.getPercent("Selenium") == 280
    }
}