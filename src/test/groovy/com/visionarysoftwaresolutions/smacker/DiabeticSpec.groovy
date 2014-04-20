package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestriction
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.Meals
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime
import com.visionarysoftwaresolutions.smacker.testData.TestFixtures

class DiabeticSpec extends spock.lang.Specification {
    def "warn when scheduling a meal that has high sugar"() {
        given: "I have a user Barb"
            User barb = TestFixtures.createBarb()
        and: "barb is diabetic"
            DietaryRestriction diabetes = TestFixtures.createDiabetes()
            barb.addDietaryRestriction(diabetes)
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
        given: "I have a user Barb"
            User barb = TestFixtures.createBarb()
        and: "barb is diabetic"
            DietaryRestriction diabetes = TestFixtures.createDiabetes()
            barb.addDietaryRestriction(diabetes)
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
}
