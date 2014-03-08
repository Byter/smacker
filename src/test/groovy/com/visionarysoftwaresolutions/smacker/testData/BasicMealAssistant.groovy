package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.MealAssistant
import com.visionarysoftwaresolutions.smacker.api.meals.MealDay
import com.visionarysoftwaresolutions.smacker.api.meals.MealNotification
import com.visionarysoftwaresolutions.smacker.api.meals.MealSchedule
import com.visionarysoftwaresolutions.smacker.api.meals.MealTime
import com.visionarysoftwaresolutions.smacker.api.meals.Meals

class BasicMealAssistant implements MealAssistant {
    MealSchedule theSchedule
    final long THIRTY_MINUTES_IN_MILLIS = 1000 * 60 * 60

    BasicMealAssistant(MealSchedule schedule) {
        theSchedule = schedule
    }

    @Override
    void run() {
        Calendar current = Calendar.getInstance(Locale.default)
        MealDay today = new MealDay() {
            @Override
            String getMonth() {
                String.format("%<tB", current.get(Calendar.MONTH))
            }

            @Override
            String getDay() {
                String.format("%<te", current.get(Calendar.DAY_OF_MONTH))
            }

            @Override
            String getYear() {
                String.format("%<tY", current.get(Calendar.YEAR))
            }
        }

        Meals planned = theSchedule.getMealsFor(today)
        planned.each { meal ->
            MealTime eaten = meal.eatenAt()
            Date scheduledAt = String.format("YYYY-MM-DDTHH:MM", eaten.year, eaten.month, eaten.day, eaten.hour, eaten.minute)
            if (current.getTime() <= scheduledAt - THIRTY_MINUTES_IN_MILLIS) {
                MealNotification timeToEat = new MealNotification() {

                }
                theSchedule.owner.receive(timetoEat)
            }
        }
    }
}
