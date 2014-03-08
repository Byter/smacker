package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.meals.MealTime
import com.visionarysoftwaresolutions.smacker.api.physique.Physique
import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.testData.TestFixtures

class PhysiqueSpec extends spock.lang.Specification {
    def "user can log their current physique"() {
        given: "the existence of a user Nick"
            User nick = TestFixtures.createNick()
        and: "he updates his physical information"
            Physique current = TestFixtures.createPhysique()
        when: "nick logs his current physique"
            nick.log(current)
        then: "nick has his physique correctly set"
            Physique result = nick.getPhysiqueFor(TestFixtures.createMealTimeNow())
            result == current
    }

    def "user can log physique for a specific time"() {
        given: "the existence of a user Nick"
            User nick = TestFixtures.createNick()
        and: "he updates his physical information"
            Physique current = TestFixtures.createPhysique()
            MealTime planned = TestFixtures.createMealTimeTwoDaysAway()
        when: "nick logs his current physique"
            nick.logFor(current, planned)
        then: "nick has his physique correctly set"
            Physique result = nick.getPhysiqueFor(planned)
            result == current
    }
}