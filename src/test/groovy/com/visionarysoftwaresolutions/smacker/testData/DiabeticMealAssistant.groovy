package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.eventr.Event
import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.Diabetes
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.InsulinDosageRecommendation
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.InsulinDoseCalculationStrategy
import com.visionarysoftwaresolutions.smacker.api.events.MealLogged
import com.visionarysoftwaresolutions.smacker.api.meals.MealAssistant;

public class DiabeticMealAssistant implements MealAssistant {
    MealLogged lastRecorded
    InsulinDoseCalculationStrategy calculator = new NaiveInsulinCalculationStrategy()

    @Override
    void update(Event event) {
        if (event instanceof MealLogged) {
            lastRecorded = event as MealLogged
            run()
        }
    }

    @Override
    void run() {
        User recordedFor = lastRecorded.user
        Diabetes diabetes = recordedFor.dietaryRestrictions.find {
            it instanceof Diabetes
        } as Diabetes
        InsulinDosageRecommendation recommendation = calculator.calculate(diabetes, lastRecorded.meal)
        lastRecorded.user.receive(recommendation)
    }
}
