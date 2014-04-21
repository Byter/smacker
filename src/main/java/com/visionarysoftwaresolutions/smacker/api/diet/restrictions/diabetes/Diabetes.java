package com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes;

import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestriction;

public interface Diabetes extends DietaryRestriction {
    void add(Insulin toAdd);
    void log(BloodSugarLevel level);
}
