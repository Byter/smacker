package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.api.User

class Smacker implements User {
    String name, description
    MealLog log = new MemoryMealLog(belongsTo: this)
    MealSchedule schedule = new MemoryMealSchedule(belongsTo:this)
	
    @Override
    void log(Meal toLog) {
        log.log(toLog)
    }

    @Override
    Meals getMealsFor(MealDay targetDate) {
        log.getMealsFor(targetDate)
    }
	
	@Override
	void schedule(MealTime time, Meal planned){
		schedule.schedule(time, planned)
	}
	
	@Override
	Meals plannedMealsOn(MealDay day) {
		schedule.getMealsFor(day)
	}

    @Override
    void createReminder(MealTime mealTime) {
        schedule.addReminder(mealTime)
    }

    @Override
    void receive(MealNotification p) {
        println p
    }

    @Override
    String getName() {
        name
    }

    @Override
    String getDescription() {
        description
    }
}
