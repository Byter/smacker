package com.visionarysoftwaresolutions.smacker.api.diet.restrictions.diabetes;

import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime;

public interface BloodSugarLevel {
    double getValue();
    CalendarTime recordedAt();
}
