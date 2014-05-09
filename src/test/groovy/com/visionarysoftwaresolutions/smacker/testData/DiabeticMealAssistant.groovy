package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.eventr.Event
import com.visionarysoftwaresolutions.smacker.api.events.MealLogged;
import com.visionarysoftwaresolutions.smacker.api.meals.MealAssistant;

public class DiabeticMealAssistant implements MealAssistant {
    MealLogged lastRecorded

    @Override
    void update(Event event) {
        if (event instanceof MealLogged) {
            lastRecorded = event as MealLogged
            run()
        }
    }

    @Override
    void run() {

    }
}
