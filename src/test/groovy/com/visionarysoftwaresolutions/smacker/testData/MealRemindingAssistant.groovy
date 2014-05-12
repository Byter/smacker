package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.eventr.Event
import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.events.MealScheduled
import com.visionarysoftwaresolutions.smacker.api.meals.MealAssistant
import com.visionarysoftwaresolutions.smacker.api.meals.Meals
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime
import groovy.time.Duration
import groovy.time.TimeDuration

class MealRemindingAssistant implements MealAssistant {
    final Duration desired = new TimeDuration(0, 30, 0, 0)
    MealScheduled lastReceived

    @Override
    void run() {
        User user = lastReceived.user
        CalendarDay today = new SomeCalendarTime(new Date())
        Meals planned = user.plannedMealsOn(today)
        planned.each { meal ->
            CalendarTime eaten = meal.eatenAt()
            Date scheduledAt = eaten.asDate()
            Date atThreshold = desired + new Date()
            if (scheduledAt <= atThreshold) {
                user.receive(lastReceived)
            }
        }
    }

    @Override
    void update(Event event) {
        if (event instanceof MealScheduled) {
            lastReceived = event as MealScheduled
            run()
        }
    }
}
