package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealItem
import com.visionarysoftwaresolutions.smacker.api.meals.MealItems
import com.visionarysoftwaresolutions.smacker.api.meals.planning.MealPlanningStrategy
import com.visionarysoftwaresolutions.smacker.api.meals.planning.MealSchedule
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime

class BasicMealPlanningStrategy implements MealPlanningStrategy {

    @Override
    MealSchedule planMealsFor(Diet diet, CalendarDay day) {
        MealSchedule scheduled = new MemoryMealSchedule()
        List<CalendarTime> timesToEat = getScheduledMealTimes(day)
        timesToEat.each {
            Meal planned = planMeal(it, diet)
            scheduled.schedule(it, planned)
        }
        scheduled
    }

    List<CalendarTime> getScheduledMealTimes(CalendarDay calendarDay) {
        Date scheduled = calendarDay.asDate()
        scheduled[Calendar.HOUR] = 8
        scheduled[Calendar.MINUTE] = 30
        CalendarTime breakfast = new SomeCalendarTime(scheduled)
        [ breakfast ]
    }

    Meal planMeal(CalendarTime calendarTime, Diet diet) {
        Meal result = null
        if (diet.name == "Paleo") {
            result = steakBreakfast(calendarTime)
        }
        result
    }

    private Meal steakBreakfast(calendarTime) {
        new Meal() {
            def items = new MealItemsList()

            @Override
            CalendarDay eatenAt() {
                return calendarTime
            }

            @Override
            void addItem(MealItem eaten) {
                items.add(eaten)
            }

            @Override
            MealItems getItems() {
                items
            }

            @Override
            String getName() {
                return "4 oz steak"
            }

            @Override
            String getDescription() {
                return "medium rare steak"
            }
        }
    }
}
