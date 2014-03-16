package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.MealAssistant
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay
import com.visionarysoftwaresolutions.smacker.api.meals.MealNotification
import com.visionarysoftwaresolutions.smacker.api.meals.MealSchedule
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime
import com.visionarysoftwaresolutions.smacker.api.meals.Meals
import groovy.time.Duration
import groovy.time.TimeDuration

class BasicMealAssistant implements MealAssistant {
    MealSchedule theSchedule
    final Duration desired = new TimeDuration(0, 30, 0, 0)

    BasicMealAssistant(MealSchedule schedule) {
        theSchedule = schedule
    }

    @Override
    void run() {
        CalendarDay today = new SomeCalendarTime(new Date())
        Meals planned = theSchedule.getMealsFor(today)
        planned.each { meal ->
            CalendarTime eaten = meal.eatenAt()
            Date scheduledAt = eaten.asDate()
            Date atThreshold = desired + new Date()
            if (scheduledAt <= atThreshold) {
                MealNotification timeToEat = new MealNotification() {

                }
                theSchedule.owner.receive(timeToEat)
            }
        }
    }
}
