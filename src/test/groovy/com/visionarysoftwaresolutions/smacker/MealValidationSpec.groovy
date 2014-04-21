package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestriction
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.testData.TestFixtures
import spock.lang.Specification

class MealValidationSpec extends Specification {
    User nick

    def setup() {
        nick = TestFixtures.createNick()
    }

    def "warn when logging a meal that violates vegan dietary restriction"() {
        given: "nick decides to go vegan"
            DietaryRestriction woahBro = TestFixtures.createVegan()
            nick.addDietaryRestriction(woahBro)
        when: "nick plans a meal with that delicious, delicious meat"
            Meal tuna = TestFixtures.createDinner()
        and: "nick asks whether he should eat that meal"
            nick.shouldEat(tuna)
        then: "an exception is thrown because the meal is not vegan"
            def e = thrown(MealViolatesDietaryRestrictionException)
            e.meal == tuna
            e.dietaryRestriction == woahBro
    }

    def "warn when logging a meal that violates diet"() {
        given: "nick decides to try Paleo"
            Diet caveman = TestFixtures.createPaleo()
            nick.setDiet(caveman)
        when: "nick plans a meal with some sweet, sweet ice cream"
            Meal iceCream = TestFixtures.createDessert()
        and: "nick asks whether he should eat that meal"
            nick.shouldEat(iceCream)
        then: "an exception is thrown because the meal is not paleo"
            def e = thrown(MealViolatesDietException)
            e.meal == iceCream
            e.diet == caveman
    }

    def "warn when logging a meal with an item that violates vegan dietary restriction"() {
        given: "nick decides to go vegan"
            DietaryRestriction woahBro = TestFixtures.createVegan()
            nick.addDietaryRestriction(woahBro)
        when: "nick plans a meal with that delicious, delicious meat as an item"
            Meal something = TestFixtures.createDinner()
        and: "nick tries to log that meal"
            nick.shouldEat(something)
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
        and: "barb asks whether she should eat that meal"
            barb.shouldEat(oysterDinner)
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
            barb.shouldEat(something)
        then: "an exception is thrown because the meal has an allergen"
            def e = thrown(MealViolatesDietaryRestrictionException)
            e.meal == something
            e.dietaryRestriction == woahBro
    }
}