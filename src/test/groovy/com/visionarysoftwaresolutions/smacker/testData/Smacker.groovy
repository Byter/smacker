package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.MealViolatesDietException
import com.visionarysoftwaresolutions.smacker.MealViolatesDietaryRestrictionException
import com.visionarysoftwaresolutions.smacker.api.ContactInformation
import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Allergy
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestriction
import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.api.physique.Physique
import com.visionarysoftwaresolutions.smacker.api.physique.PhysiqueLog
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime

class Smacker implements User {
    String name, description
    MealLog log = new MemoryMealLog(belongsTo: this)
    MealSchedule schedule = new MemoryMealSchedule(belongsTo: this)
    PhysiqueLog bodies = new MemoryPhysiqueLog(owner: this)
    Set<DietaryRestriction> restrictions = new HashSet<DietaryRestriction>()
    Diet diet = new AnythingDiet()
    ContactInformation contactInformation

    @Override
    void log(Meal toLog) {
        validateMeal(toLog)
        log.log(toLog)
    }

    @Override
    Meals getMealsFor(CalendarDay targetDate) {
        log.getMealsFor(targetDate)
    }

    @Override
    void schedule(CalendarTime time, Meal planned) {
        validateMeal(planned)
        schedule.schedule(time, planned)
    }

    def validateMeal(final Meal meal) {
        restrictions.each { it ->
            validateDietaryRestriction(meal, it)
        }
        validateDiet(meal)
    }

    void validateDietaryRestriction(Meal meal, DietaryRestriction it) {
        MealValidationStrategy checker = new DietaryRestrictionValidation(it)
        if (!checker.isValid(meal)) {
            throw new MealViolatesDietaryRestrictionException(meal, it)
        }
    }

    def validateDiet(final Meal meal) {
        MealValidationStrategy checker = new DietValidation(diet)
        if (!checker.isValid(meal)) {
            throw new MealViolatesDietException(meal, diet)
        }
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
        restrictions << restriction
    }

    @Override
    Set<DietaryRestriction> getDietaryRestrictions() {
        Collections.unmodifiableCollection(restrictions)
    }

    @Override
    void addAllergy(Allergy allergy) {
        restrictions << allergy
    }
}
