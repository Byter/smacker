package com.visionarysoftwaresolutions.smacker.api;

import com.visionarysoftwaresolutions.describable.Describable;
import org.joda.time.DateTime;

/**
 * User: Master
 * Date: 10/6/13
 * Time: 11:14 PM
 */
public interface Meal extends Describable {
    DateTime eatenAt();
}
