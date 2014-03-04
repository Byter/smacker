package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.meals.MealTime
import com.visionarysoftwaresolutions.smacker.api.meals.Meals
import com.visionarysoftwaresolutions.smacker.testData.TestFixtures

class MealReminderSpec extends spock.lang.Specification {
    def "user can create a meal reminder"() {
        given: "the existence of a user Nick"
            User nick = TestFixtures.createNick()
        and: "he plans to eat two days from now"
            MealTime target = TestFixtures.createMealTime()
        when: "nick creates a meal reminder"
            nick.createReminder(target)
        then: "the meal plan has an empty meal"
            Meals eaten = nick.plannedMealsOn(target)
            eaten.isEmpty() == false
    }
}
