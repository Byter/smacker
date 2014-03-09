package com.visionarysoftwaresolutions.smacker.api.diet

public interface Allergy extends DietaryRestriction {
    String getAllergen()
    String getSeverity()
}