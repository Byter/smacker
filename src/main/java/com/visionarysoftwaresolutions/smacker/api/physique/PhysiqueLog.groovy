package com.visionarysoftwaresolutions.smacker.api.physique

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.meals.MealTime

public interface PhysiqueLog {
    User getOwner();
    void log(Physique physique)
    Physique getPhysiqueFor(MealTime mealTime)

    void logFor(Physique physique, MealTime mealTime)
}