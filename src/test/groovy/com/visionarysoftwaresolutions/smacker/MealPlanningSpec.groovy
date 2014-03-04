package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.*
import com.visionarysoftwaresolutions.smacker.api.nutrition.*
import com.visionarysoftwaresolutions.smacker.api.nutrition.analysis.*
import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.testData.TestFixtures

class MealPlanningSpec extends spock.lang.Specification {
	
	def "can schedule a meal in the future"() {
		given: "the existence of a user Nick"
			User nick = TestFixtures.createNick()
		and: "he plans to eat two days from now"
			MealTime target = TestFixtures.createMealTime()
		and: "meal of 2 cans of tuna and a fiber plus bar"
			Meal dinner = TestFixtures.createDinner()
			MealItem canOTuna = TestFixtures.canOTuna()
			MealItem fiberPlusBar = TestFixtures.fiberPlusBar()
			dinner.addItem(canOTuna)
			dinner.addItem(canOTuna)
			dinner.addItem(fiberPlusBar)
		when: "nick schedules the meal"
			nick.schedule(target, dinner)
		then: "the meal plan the day contains dinner"
			Meals eaten = nick.plannedMealsOn(target)
			eaten.has(dinner) == true
		and: "dinner has the 2 cans of tuna and a fiber plus bar"
			List<MealItem> dishes = dinner.getItems()
			dishes == [ canOTuna, canOTuna, fiberPlusBar ]
	}

}
