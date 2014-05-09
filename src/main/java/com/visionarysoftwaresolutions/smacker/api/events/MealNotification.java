package com.visionarysoftwaresolutions.smacker.api.events;

import com.visionarysoftwaresolutions.eventr.Event;
import com.visionarysoftwaresolutions.smacker.api.User;
import com.visionarysoftwaresolutions.smacker.api.meals.Meal;

public interface MealNotification extends Event {
    User getUser();
    Meal getMeal();
}
