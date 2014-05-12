package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.BloodSugarLevel
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.BloodSugarLevels
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.Diabetes
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.Insulin
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes.Insulins

class Type2Diabetes implements Diabetes {
    User belongsTo
    List<Insulin> insulins = []
    List<BloodSugarLevel> sugars = []

    @Override
    void add(Insulin toAdd) {
        insulins.add(toAdd)
    }

    @Override
    Insulins getInsulins() {
        insulins
    }

    @Override
    void log(BloodSugarLevel level) {
        sugars.add(level)
    }

    @Override
    BloodSugarLevels getBloodSugarLevels() {
        sugars
    }

    @Override
    User getUser() {
        belongsTo
    }
}
