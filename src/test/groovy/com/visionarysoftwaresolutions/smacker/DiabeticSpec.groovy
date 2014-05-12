package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.BloodSugarLevel
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.Diabetes
import com.visionarysoftwaresolutions.smacker.testData.DiabeticMealAssistant
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.Insulin
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.InsulinDosageRecommendation
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
            Insulin novalog = TestFixtures.novalog()
            diabetes.add(novalog)
        and: "she logs her pre-meal blood sugar level"
            diabetes.log([ "getValue" : 145.0] as BloodSugarLevel)
        and: "a meal assistant is created to remind barb"
            DiabeticMealAssistant ass = new DiabeticMealAssistant()
            barb.addAssistant(ass)
        when: "barb eats a meal"
            Meal iceCream = TestFixtures.createDessert()
            barb.log(iceCream)
        then: "the meal assistant gets the meal"
            ass.lastRecorded.meal == iceCream
        and: "the user is barb"
            ass.lastRecorded.user == barb
    }
}
