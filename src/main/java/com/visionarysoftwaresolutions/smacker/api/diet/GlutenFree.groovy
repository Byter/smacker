package com.visionarysoftwaresolutions.smacker.api.diet

public abstract class GlutenFree implements Allergy {
    @Override
    public String getAllergen() {
        return "gluten";
    }
}