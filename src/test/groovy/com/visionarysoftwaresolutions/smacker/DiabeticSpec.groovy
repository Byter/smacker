package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestriction
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.testData.TestFixtures

class DiabeticSpec extends spock.lang.Specification {
    def "warn when scheduling a meal that has allergen"() {
        given: "I have a user Barb"
            User barb = TestFixtures.createBarb()
        and: "barb is diabetic"
            DietaryRestriction diabetes = TestFixtures.createDiabetes()
            barb.addDietaryRestriction(diabetes)
        when: "barb plans a meal with oysters"
            Meal iceCream = TestFixtures.createDessert()
        and: "barb tries to schedule that meal"
            barb.schedule(TestFixtures.createMealTimeNow(), iceCream)
        then: "an exception is thrown because the meal contains an allergy"
            def e = thrown(MealViolatesDietaryRestrictionException)
            e.meal == iceCream
            e.dietaryRestriction == diabetes
    }
}
