package com.visionarysoftwaresolutions.smacker.api.diet.restrictions;

public interface Allergy extends DietaryRestriction {
    String getAllergen();
    String getSeverity();
}
