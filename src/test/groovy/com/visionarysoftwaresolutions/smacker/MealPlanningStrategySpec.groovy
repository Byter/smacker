package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.meals.MealPlanningStrategy
import com.visionarysoftwaresolutions.smacker.api.meals.MealSchedule
import com.visionarysoftwaresolutions.smacker.api.meals.Meals
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay
import com.visionarysoftwaresolutions.smacker.testData.TestFixtures

class MealPlanningStrategySpec extends spock.lang.Specification {

    def "as a user, to make life easier, when I select a particular diet, i want to have a meal schedule generated"() {
        given: "A user nick"
            User nick = TestFixtures.createNick()
        and: "a specific diet that the user wishes to go on"
            Diet paleo = TestFixtures.createPaleo()
        and: "a meal planning strategy that can create meals for that diet"
            MealPlanningStrategy strategy = TestFixtures.createMealPlanningStrategy()
        and: "a day that user wants meals planned for"
            CalendarDay plannedDay = TestFixtures.createMealTimeTwoDaysAway()
        when: "the user asks for a meal schedule to be generated"
            MealSchedule generated = strategy.planMealsFor(paleo, plannedDay)
        then: "the meal schedule should have some meals"
            Meals result = generated.getMealsFor(plannedDay)
            !result.empty
    }
}
