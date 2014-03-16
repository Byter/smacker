package com.visionarysoftwaresolutions.smacker.api.time;

public interface CalendarTime extends CalendarDay {
	String getHour();
	String getMinute();
    boolean isOnSameDay(CalendarDay another);
}
