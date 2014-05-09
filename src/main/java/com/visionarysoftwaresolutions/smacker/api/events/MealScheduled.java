package com.visionarysoftwaresolutions.smacker.api.events;

import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime;

public interface MealScheduled extends MealNotification {
    CalendarTime getScheduledTime();
}
