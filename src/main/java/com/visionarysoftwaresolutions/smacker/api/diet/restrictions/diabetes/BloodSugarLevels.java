package com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes;

public interface BloodSugarLevels extends Iterable<BloodSugarLevel> {
    BloodSugarLevel getLatest();
}
