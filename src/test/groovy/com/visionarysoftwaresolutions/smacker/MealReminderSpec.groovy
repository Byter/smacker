package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.meals.MealAssistant
import com.visionarysoftwaresolutions.smacker.api.meals.MealNotification
import com.visionarysoftwaresolutions.smacker.api.meals.MealSchedule
import com.visionarysoftwaresolutions.smacker.api.meals.MealTime
import com.visionarysoftwaresolutions.smacker.api.meals.Meals
import com.visionarysoftwaresolutions.smacker.testData.*

class MealReminderSpec extends spock.lang.Specification {
    def "user can create a meal reminder"() {
        given: "the existence of a user Nick"
            User nick = TestFixtures.createNick()
        and: "he plans to eat two days from now"
            MealTime target = TestFixtures.createMealTimeTwoDaysAway()
        when: "nick creates a meal reminder"
            nick.createReminder(target)
        then: "the meal plan has an empty meal"
            Meals eaten = nick.plannedMealsOn(target)
            eaten.isEmpty() == false
    }

    def "meal scheduling assistant reminds user when it is meal time"() {
        given: "the existence of a meal schedule with a user"
            MealSchedule schedule = new MemoryMealSchedule()
            User nick = Mock(User)
            schedule.belongsTo = nick
        and: "a plan to eat two days from now is on the schedule"
            MealTime target = TestFixtures.createMealTimeTwoDaysAway()
            schedule.addReminder(target)
        and: "a meal assistant is created to remind him"
            MealAssistant ass = new BasicMealAssistant(schedule)
        when: "the meal assistant runs to remind"
            ass.run()
        then: "the user receives a meal reminder"
            1 * nick.receive(_ as MealNotification)
    }
}
