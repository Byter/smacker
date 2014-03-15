package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.meals.MealLog
import com.visionarysoftwaresolutions.smacker.api.meals.MealSchedule
import com.visionarysoftwaresolutions.smacker.testData.TestFixtures

class DietSpec extends spock.lang.Specification {
    def "a user can set a diet"() {
        given : "a diet to set"
            Diet anything = TestFixtures.anythingDiet()
        and: "a user who wants to set their diet to that"
            User nick = TestFixtures.createNick()
        when: "the user sets his diet"
            nick.setDiet(anything)
        then: "the user has a set diet"
            anything == nick.getDiet()
    }

    def "diet has a meal schedule"() {
        given : "a diet to set"
            Diet anything = TestFixtures.anythingDiet()
        when: "I ask for the diet's meal schedule"
            MealSchedule schedule = anything.mealSchedule
        then: "the meal schedule is not null"
            schedule != null
    }

    def "diet has a meal log"() {
        given : "a diet to set"
            Diet anything = TestFixtures.anythingDiet()
        when: "I ask for the diet's meal log"
            MealLog log = anything.mealLog
        then: "the meal log is not null"
            log != null
    }
}
