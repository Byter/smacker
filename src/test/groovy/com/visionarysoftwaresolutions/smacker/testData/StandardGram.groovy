package com.visionarysoftwaresolutions.smacker.testData;

import com.visionarysoftwaresolutions.smacker.api.units.Grams;

public class StandardGram implements Grams {
    private final double value;

    public StandardGram(final double inGrams) {
        if (inGrams < 0) {
            throw new IllegalArgumentException("negative mass!?!");
        }
        value = inGrams;
    }

    public double getValue() {
        return value;
    }

}
