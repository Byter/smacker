package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class SomeCalendarTime implements CalendarTime {
    Calendar cal = Calendar.getInstance()

    SomeCalendarTime(Date target) {
        cal.setTime(target)
    }

    @Override
    String getHour() {
        String.format('%tH', cal)
    }

    @Override
    String getMinute() {
        String.format('%tM', cal)
    }

    @Override
    boolean isOnSameDay(CalendarDay another) {
        year == another.year && month == another.month && day == another.day
    }

    @Override
    String getMonth() {
        String.format('%tB', cal)
    }

    @Override
    String getDay() {
        String.format('%td', cal)
    }

    @Override
    String getYear() {
        String.format('%tY', cal)
    }

    @Override
    Date asDate() {
        cal.getTime()
    }

    @Override
    int compareTo(CalendarDay o) {
        asDate().compareTo(o?.asDate())
    }
}
