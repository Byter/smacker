package com.visionarysoftwaresolutions.smacker.api;

import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay;

public interface ContactInformation {
    EmailAddress getEmailAddress();
    String getFullName();
    CalendarDay getDayOfBirth();
}
