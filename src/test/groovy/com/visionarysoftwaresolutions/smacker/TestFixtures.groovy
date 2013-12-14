package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.Meal
import com.visionarysoftwaresolutions.smacker.api.User

/**
 * Created with IntelliJ IDEA.
 * User: Master
 * Date: 12/14/13
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
class TestFixtures {
    static User createNick() {
        new Smacker(name:"Nick", description:"test")
    }
    static Meal createDinner() {
        new Dinner()
    }
}
