package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.meals.*
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
            List<MealItem> dishes = dinner.getItems()
            dishes == [ canOTuna, canOTuna, fiberPlusBar ]
    }
}