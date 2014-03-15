package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.MealAssistant
import com.visionarysoftwaresolutions.smacker.api.meals.MealDay
import com.visionarysoftwaresolutions.smacker.api.meals.MealNotification
import com.visionarysoftwaresolutions.smacker.api.meals.MealSchedule
import com.visionarysoftwaresolutions.smacker.api.meals.MealTime
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
        MealDay today = new SomeMealTime(new Date())
        Meals planned = theSchedule.getMealsFor(today)
        planned.each { meal ->
            MealTime eaten = meal.eatenAt()
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
