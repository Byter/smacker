package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Allergy
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestriction
import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.physique.Physique
import com.visionarysoftwaresolutions.smacker.api.physique.PhysiqueLog

class Smacker implements User {
    String name, description
    MealLog log = new MemoryMealLog(belongsTo: this)
    MealSchedule schedule = new MemoryMealSchedule(belongsTo:this)
    PhysiqueLog bodies = new MemoryPhysiqueLog(owner:this)
    Set<DietaryRestriction> restrictions = new HashSet<DietaryRestriction>()
    Diet diet
	
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
    void addDietaryRestriction(DietaryRestriction restriction) {
        restrictions += restriction
    }

    @Override
    Set<DietaryRestriction> getDietaryRestrictions() {
        Collections.unmodifiableCollection(restrictions)
    }

    @Override
    void addAllergy(String allergen, String severity) {
        restrictions += new Allergy() {

            @Override
            String getAllergen() {
                allergen
            }

            @Override
            String getSeverity() {
                severity
            }
        }
    }
}
