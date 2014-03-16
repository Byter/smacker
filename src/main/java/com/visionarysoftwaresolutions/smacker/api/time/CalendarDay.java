package com.visionarysoftwaresolutions.smacker.api.time;

import java.util.Date;

public interface CalendarDay extends Comparable<CalendarDay> {
    String getMonth();
    String getDay();
    String getYear();
    Date asDate();
}
