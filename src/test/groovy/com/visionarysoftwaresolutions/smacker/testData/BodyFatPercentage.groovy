package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.physique.BodyFat
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class BodyFatPercentage implements BodyFat {
    int value
}