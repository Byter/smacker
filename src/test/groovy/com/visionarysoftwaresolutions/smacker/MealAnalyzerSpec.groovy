package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.*
import com.visionarysoftwaresolutions.smacker.api.nutrition.*
import com.visionarysoftwaresolutions.smacker.api.nutrition.analysis.*
import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.testData.TestFixtures

class MealAnalyzerSpec extends spock.lang.Specification {
	
	def "can analyze nick's meal"() {
		given: "the existence of a user Nick"
			User nick = TestFixtures.createNick()
		and: "Nick eats a meal at 6 pm of 2 cans of tuna and a fiber plus bar"
			Meal dinner = TestFixtures.createDinner()
			MealItem canOTuna = TestFixtures.canOTuna()
			MealItem fiberPlusBar = TestFixtures.fiberPlusBar()
			dinner.addItem(canOTuna)
			dinner.addItem(canOTuna)
			dinner.addItem(fiberPlusBar)
		when: "a total intake analyzer analyzes the meal"
			TotalIntakeAnalyzer anal = TestFixtures.intakeAnalyzer()
			NutritionalInformation nut = anal.calculateFor(dinner)
		then: "calories with 340 kCal total, 60 from fat"
            Calories calories = nut.getCalories()
            calories.total == 340
            calories.fromFat == 60
        and: "fat with total 6g, sat fat 2g, trans 0g"
            Fat fat = nut.getFat()
            fat.total.value == 6
            fat.fromSaturated.value == 2
            fat.fromTrans.value == 0
        and: "total cholesterol of 8 g"
            Cholesterol chloe = nut.getCholesterol()
            chloe.total.value == 8
		and: "total carbohydrates of 26g, 9g fiber, 7g sugar"
			Carbohydrates carbs = nut.getCarbohydrates()
			carbs.total.value == 26
			carbs.fiber.value == 9
			carbs.sugar.value == 7
		and: "total sodium of 4.35g"
            Sodium sod = nut.getSodium()
            sod.total.value == 4.35
        and: "intake has total protein of 50g"
            Protein pro = nut.getProtein()
            pro.total.value == 50
        and: "intake has vitamins"
            Vitamins vita = nut.getVitamins()
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
