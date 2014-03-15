package com.visionarysoftwaresolutions.smacker.api.diet.restrictions

public abstract class GlutenFree implements Allergy {
    @Override
    public String getAllergen() {
        return "gluten";
    }
}