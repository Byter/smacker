package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.ContactInformation
import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Allergy
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestriction
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestrictions
import com.visionarysoftwaresolutions.smacker.api.events.MealNotification
import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.api.physique.Physique
import com.visionarysoftwaresolutions.smacker.api.physique.PhysiqueLog
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime

class Smacker implements User {
    String name, description
    ObservableMealLog log = new MemoryMealLog(belongsTo: this)
    ObservableMealSchedule schedule = new MemoryMealSchedule(belongsTo: this)
    PhysiqueLog bodies = new MemoryPhysiqueLog(owner: this)
    DietaryRestrictions restrictions = new UniqueDietaryRestrictions()
    Diet diet = new AnythingDiet()
    ContactInformation contactInformation

    @Override
    void log(Meal toLog) {
        log.log(toLog)
    }

    @Override
    Meals getMealsFor(CalendarDay targetDate) {
        log.getMealsFor(targetDate)
    }

    @Override
    void schedule(CalendarTime time, Meal planned) {
        shouldEat(planned)
        schedule.schedule(time, planned)
    }

    @Override
    Meals plannedMealsOn(CalendarDay day) {
        schedule.getMealsFor(day)
    }

    @Override
    void createReminder(CalendarTime mealTime) {
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
    void logFor(Physique physique, CalendarTime time) {
        bodies.logFor(physique, time)
    }

    @Override
    Physique getPhysiqueFor(CalendarTime time) {
        bodies.getPhysiqueFor(time)
    }

    @Override
    void addDietaryRestriction(DietaryRestriction restriction) {
        restrictions.add(restriction)
    }

    @Override
    DietaryRestrictions getDietaryRestrictions() {
        restrictions
    }

    @Override
    void addAllergy(Allergy allergy) {
        restrictions.add(allergy)
    }

    @Override
    boolean shouldEat(Meal toEat) {
        diet.isAcceptable(toEat) && restrictions.meetsRestrictions(toEat)
    }

    @Override
    void addAssistant(MealAssistant assistant) {
        log.add(assistant)
        schedule.add(assistant)
    }
}