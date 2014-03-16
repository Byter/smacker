package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.*
import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestriction
import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime
import com.visionarysoftwaresolutions.smacker.testData.TestFixtures

class MealPlanningSpec extends spock.lang.Specification {
	
	def "can schedule a meal in the future"() {
		given: "the existence of a user Nick"
			User nick = TestFixtures.createNick()
		and: "he plans to eat two days from now"
			CalendarTime target = TestFixtures.createMealTimeTwoDaysAway()
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

    def "warn when scheduling a meal that violates vegan dietary restriction"() {
        given: "I have a user Nick"
            User nick = TestFixtures.createNick()
        and: "nick decides to go vegan"
            DietaryRestriction woahBro = TestFixtures.createVegan()
            nick.addDietaryRestriction(woahBro)
        when: "nick plans a meal with that delicious, delicious meat"
            Meal tuna = TestFixtures.createDinner()
        and: "nick tries to schedule that meal"
            nick.schedule(TestFixtures.createMealTimeNow(), tuna)
        then: "an exception is thrown because the meal is not vegan"
            def e = thrown(MealViolatesDietaryRestrictionException)
            e.meal == tuna
            e.dietaryRestriction == woahBro
    }

    def "warn when scheduling a meal that has allergen"() {
        given: "I have a user Barb"
            User barb = TestFixtures.createBarb()
        and: "barb has an allergy to oysters"
            DietaryRestriction woahBro = TestFixtures.createOysterAllergy()
            barb.addDietaryRestriction(woahBro)
        when: "barb plans a meal with oysters"
            Meal oysterDinner = TestFixtures.createOysterDinner()
        and: "barb tries to schedule that meal"
            barb.schedule(TestFixtures.createMealTimeNow(), oysterDinner)
        then: "an exception is thrown because the meal contains an allergy"
            def e = thrown(MealViolatesDietaryRestrictionException)
            e.meal == oysterDinner
            e.dietaryRestriction == woahBro
    }
}
