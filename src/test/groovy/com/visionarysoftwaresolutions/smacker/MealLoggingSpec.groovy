package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestriction
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealItem
import com.visionarysoftwaresolutions.smacker.api.meals.MealItems
import com.visionarysoftwaresolutions.smacker.api.meals.Meals
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay
import com.visionarysoftwaresolutions.smacker.testData.TestFixtures

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
                    year: "2013"] as CalendarDay)
            eaten.has(dinner) == true
        and: "dinner has the 2 cans of tuna and a fiber plus bar"
            MealItems dishes = dinner.getItems()
            dishes.collect() == [ canOTuna, canOTuna, fiberPlusBar ]
    }

    def "warn when logging a meal that violates vegan dietary restriction"() {
        given: "I have a user Nick"
            User nick = TestFixtures.createNick()
        and: "nick decides to go vegan"
            DietaryRestriction woahBro = TestFixtures.createVegan()
            nick.addDietaryRestriction(woahBro)
        when: "nick plans a meal with that delicious, delicious meat"
            Meal tuna = TestFixtures.createDinner()
        and: "nick tries to log that meal"
            nick.log(tuna)
        then: "an exception is thrown because the meal is not vegan"
            def e = thrown(MealViolatesDietaryRestrictionException)
            e.meal == tuna
            e.dietaryRestriction == woahBro
    }

    def "warn when logging a meal that violates diet"() {
        given: "I have a user Nick"
            User nick = TestFixtures.createNick()
        and: "nick decides to try Paleo"
            Diet caveman = TestFixtures.createPaleo()
            nick.setDiet(caveman)
        when: "nick plans a meal with some sweet, sweet ice cream"
            Meal iceCream = TestFixtures.createDessert()
        and: "nick tries to log that meal"
            nick.log(iceCream)
        then: "an exception is thrown because the meal is not paleo"
            def e = thrown(MealViolatesDietException)
            e.meal == iceCream
            e.diet == caveman
    }

    def "warn when logging a meal with an item that violates vegan dietary restriction"() {
        given: "I have a user Nick"
            User nick = TestFixtures.createNick()
        and: "nick decides to go vegan"
            DietaryRestriction woahBro = TestFixtures.createVegan()
            nick.addDietaryRestriction(woahBro)
        when: "nick plans a meal with that delicious, delicious meat as an item"
            Meal something = TestFixtures.createDinner()
        and: "nick tries to log that meal"
            nick.log(something)
        then: "an exception is thrown because the meal is not vegan"
            def e = thrown(MealViolatesDietaryRestrictionException)
            e.meal == something
            e.dietaryRestriction == woahBro
    }

    def "warn when logging a meal that has allergen"() {
        given: "I have a user Barb"
            User barb = TestFixtures.createBarb()
        and: "barb has an allergy to oysters"
            DietaryRestriction woahBro = TestFixtures.createOysterAllergy()
            barb.addDietaryRestriction(woahBro)
        when: "barb plans a meal with oysters"
            Meal oysterDinner = TestFixtures.createOysterDinner()
        and: "barb tries to log that meal"
            barb.log(oysterDinner)
        then: "an exception is thrown because the meal contains an allergy"
            def e = thrown(MealViolatesDietaryRestrictionException)
            e.meal == oysterDinner
            e.dietaryRestriction == woahBro
    }

    def "warn when logging a meal with an item that violates allergens"() {
        given: "I have a user Barb"
            User barb = TestFixtures.createBarb()
        and: "barb has an allergy to oysters"
            DietaryRestriction woahBro = TestFixtures.createOysterAllergy()
            barb.addDietaryRestriction(woahBro)
        when: "barb plans a meal with oysters"
            Meal something = TestFixtures.createOysterMeal()
        and: "barb tries to log that meal"
            barb.log(something)
        then: "an exception is thrown because the meal has an allergen"
            def e = thrown(MealViolatesDietaryRestrictionException)
            e.meal == something
            e.dietaryRestriction == woahBro
    }
}