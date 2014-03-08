package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.physique.Physique
import com.visionarysoftwaresolutions.smacker.api.physique.PhysiqueLog

class Smacker implements User {
    String name, description
    MealLog log = new MemoryMealLog(belongsTo: this)
    MealSchedule schedule = new MemoryMealSchedule(belongsTo:this)
    PhysiqueLog bodies = new MemoryPhysiqueLog(owner:this)
	
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
    void log(Physique physique) {
        bodies.log(physique)
    }

    @Override
    void logFor(Physique physique, MealTime time) {
        bodies.logFor(physique, time)
    }

    @Override
    Physique getPhysiqueFor(MealTime time) {
        bodies.getPhysiqueFor(time)
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
