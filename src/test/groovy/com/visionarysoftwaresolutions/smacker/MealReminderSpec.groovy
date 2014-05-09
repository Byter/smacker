package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.events.MealScheduled
import com.visionarysoftwaresolutions.smacker.api.meals.MealAssistant
import com.visionarysoftwaresolutions.smacker.api.events.MealNotification
import com.visionarysoftwaresolutions.smacker.api.meals.MealSchedule
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime
import com.visionarysoftwaresolutions.smacker.api.meals.Meals
import com.visionarysoftwaresolutions.smacker.testData.*

class MealReminderSpec extends spock.lang.Specification {
    def "user can create a meal reminder"() {
        given: "the existence of a user Nick"
            User nick = TestFixtures.createNick()
        and: "he plans to eat two days from now"
            CalendarTime target = TestFixtures.createMealTimeTwoDaysAway()
        when: "nick creates a meal reminder"
            nick.createReminder(target)
        then: "the meal plan has a meal"
            Meals planned = nick.plannedMealsOn(target)
            planned.isEmpty() == false
    }

    def "meal scheduling assistant reminds user when it is meal time"() {
        given: "the existence of a meal schedule with a user"
            User nick = TestFixtures.createNick()
        and: "a meal assistant is created to remind him"
            MealAssistant ass = new MealRemindingAssistant()
            nick.addAssistant(ass)
        and: "a plan to eat today is on the schedule"
            CalendarTime target = TestFixtures.createMealTimeIn20Minutes()
        when: "the meal assistant runs to remind"
            nick.createReminder(target)
        then: "the assistant captures an event"
            MealScheduled received = ass.lastReceived
        and: "the event is not null"
            received != null
        and: "the event time is the target"
            target.equals(received.scheduledTime)
        and: "the event user is the expected user"
            nick == received.user
    }
}
