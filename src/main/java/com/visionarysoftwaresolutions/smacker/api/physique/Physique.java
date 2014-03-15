package com.visionarysoftwaresolutions.smacker.api.physique;

import com.visionarysoftwaresolutions.smacker.api.User;

public interface Physique {
    User getOwner();
    Weight getWeight();
    Height getHeight();
    BMI getBMI();
    BodyFat getBodyFat();
}
