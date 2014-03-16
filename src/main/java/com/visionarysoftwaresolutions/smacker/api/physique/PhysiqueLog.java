package com.visionarysoftwaresolutions.smacker.api.physique;

import com.visionarysoftwaresolutions.smacker.api.User;
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime;

public interface PhysiqueLog {
    User getOwner();
    void log(Physique physique);
    Physique getPhysiqueFor(CalendarTime mealTime);
    void logFor(Physique physique, CalendarTime mealTime);
}
