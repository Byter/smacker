package com.visionarysoftwaresolutions.smacker.api.diet.restrictions;

public interface Diabetes extends DietaryRestriction {
    void addInsulin(String name);
    void log(BloodSugarLevel level);
}
