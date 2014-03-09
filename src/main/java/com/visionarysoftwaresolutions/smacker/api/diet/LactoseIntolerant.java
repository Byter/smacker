package com.visionarysoftwaresolutions.smacker.api.diet;

public abstract class LactoseIntolerant implements Allergy {
    @Override
    public String getAllergen() {
        return "lactose";
    }
}
