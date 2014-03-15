package com.visionarysoftwaresolutions.smacker.api.diet.restrictions;

public abstract class LactoseIntolerant implements Allergy {
    @Override
    public String getAllergen() {
        return "lactose";
    }
}
