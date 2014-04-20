package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.units.Grams

class Gram implements Grams {
    double value = 0

    def plus(Grams another) {
        return new Gram(value: value + another.value)
    }
}
