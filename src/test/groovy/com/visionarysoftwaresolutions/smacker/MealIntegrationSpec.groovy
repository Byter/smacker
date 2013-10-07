package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.Meal
import com.visionarysoftwaresolutions.smacker.api.MealDay
import com.visionarysoftwaresolutions.smacker.api.Meals
import com.visionarysoftwaresolutions.smacker.api.Smacker
import com.visionarysoftwaresolutions.smacker.api.User
import org.joda.time.DateTime

/**
 * User: Master
 * MealDay: 10/6/13
 * Time: 10:50 PM
 */
class MealIntegrationSpec extends spock.lang.Specification {
    def "create a meal for nick"() {
        given: "the existence of a user Nick"
            User nick = new Smacker(name:"Nick", description:"test")
        and: "Nick eats a meal at 6 pm of 2 cans of tuna and a fiber plus bar"
            Meal dinner = createDinner()
        when: "nick logs the meal"
            nick.log(dinner)
        then: "the meal log for october 6th contains dinner"
            Meals eaten = nick.getMealsFor([
                    month:"October",
                    day: "6th",
                    year: "2013"] as MealDay)
            eaten.has(dinner) == true
    }

    private Meal createDinner() {
        Meal dinner = [name:"dinner", at:new DateTime()] as Meal
    }
}