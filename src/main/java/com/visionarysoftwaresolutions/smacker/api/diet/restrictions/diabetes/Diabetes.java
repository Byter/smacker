package com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes;

import com.visionarysoftwaresolutions.smacker.api.User;
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestriction;

public interface Diabetes extends DietaryRestriction {
    void add(Insulin toAdd);
    Insulins getInsulins();
    void log(BloodSugarLevel level);
    BloodSugarLevels getBloodSugarLevels();
    User getUser();
}
