package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.BloodSugarLevel
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Diabetes
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DiabeticMealAssistant
import com.visionarysoftwaresolutions.smacker.api.events.InsulinDosageRecommendation
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.Meals
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime

import com.visionarysoftwaresolutions.smacker.testData.TestFixtures

class DiabeticSpec extends spock.lang.Specification {
    User barb
    Diabetes diabetes

    def setup() {
        given: "I have a user Barb"
           barb = TestFixtures.createBarb()
        and: "barb is diabetic"
            diabetes = TestFixtures.createDiabetes()
            barb.addDietaryRestriction(diabetes)
    }

    def "warn when scheduling a meal that has high sugar"() {
        when: "barb plans a meal with high sugar"
            Meal iceCream = TestFixtures.createDessert()
        and: "barb tries to schedule that meal"
            barb.schedule(TestFixtures.createMealTimeNow(), iceCream)
        then: "an exception is thrown because the meal has high sugar"
            def e = thrown(MealViolatesDietaryRestrictionException)
            e.meal == iceCream
            e.dietaryRestriction == diabetes
    }

    def "can schedule healthy meal"() {
        when: "barb plans a healthy meal"
            Meal dinner = TestFixtures.createDinner()
            dinner.addItem(TestFixtures.canOTuna())
            CalendarTime planned = TestFixtures.createMealTimeNow()
        and: "barb tries to schedule that meal"
            barb.schedule(planned, dinner)
        then: "the meal is successfully scheduled"
            Meals scheduled = barb.plannedMealsOn(planned)
            scheduled.has(dinner)
    }

    def "advised of units of insulin to take after logging meal"() {
        given: "barb takes Novalog"
            diabetes.addInsulin("Novalog")
        and: "she logs her pre-meal blood sugar level"
            diabetes.log([ "getValue" : 145.0] as BloodSugarLevel)
        and: "a meal assistant is created to remind barb"
            DiabeticMealAssistant ass = Mock()
        when: "barb eats a meal"
            Meal iceCream = TestFixtures.createDessert()
        and: "barb logs the meal"
            barb.log(iceCream)
        then: "the meal assistant runs to remind"
            1 * ass.run()
        and: "the user receives a meal reminder"
            1 * barb.receive(_ as InsulinDosageRecommendation)
    }
}
