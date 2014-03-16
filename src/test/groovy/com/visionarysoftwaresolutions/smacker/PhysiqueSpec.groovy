package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime
import com.visionarysoftwaresolutions.smacker.api.physique.Physique
import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.testData.TestFixtures

class PhysiqueSpec extends spock.lang.Specification {
    def "user can log their current physique"() {
        given: "the existence of a user Nick"
            User nick = TestFixtures.createNick()
        and: "he updates his physical information"
            Physique current = TestFixtures.createImperialPhysique()
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
            Physique current = TestFixtures.createImperialPhysique()
            CalendarTime planned = TestFixtures.createMealTimeTwoDaysAway()
        when: "nick logs his current physique"
            nick.logFor(current, planned)
        then: "nick has his physique correctly set"
            Physique result = nick.getPhysiqueFor(planned)
            result == current
    }

    def "user can see their physique in imperial units"() {
        given: "the existence of a user Nick"
            User nick = TestFixtures.createNick()
        and: "he updates his physical information"
            Physique current = TestFixtures.createImperialPhysique()
        when: "nick logs his current physique"
            nick.log(current)
        then: "nick has his physique correctly set"
            Physique result = nick.getPhysiqueFor(TestFixtures.createMealTimeNow())
            result == current
        and: "his weight is 210 lbs"
            result.weight == TestFixtures.twoHundredTenPounds()
        and: "his height is 5 feet 11 inches"
            result.height == TestFixtures.fiveFeetElevenInches()
        and: "his body fat percentage is 23"
            result.bodyFat == TestFixtures.twentyThreePercentBodyFat()
        and: "his BMI is 21.9"
            result.BMI == TestFixtures.twentyOnePointNineBMI()
    }

    def "user can see their physique in metric units"() {
        given: "the existence of a user Nick"
        User nick = TestFixtures.createNick()
        and: "he updates his physical information"
        Physique current = TestFixtures.createMetricPhysique()
        when: "nick logs his current physique"
        nick.log(current)
        then: "nick has his physique correctly set"
        Physique result = nick.getPhysiqueFor(TestFixtures.createMealTimeNow())
        result == current
        and: "his weight is 95 kilos"
        result.weight == TestFixtures.ninetyFiveKilos()
        and: "his height is 1.8 meters"
        result.height == TestFixtures.onePointEightMeters()
        and: "his body fat percentage is 23"
        result.bodyFat == TestFixtures.twentyThreePercentBodyFat()
        and: "his BMI is 21.9"
        result.BMI == TestFixtures.twentyOnePointNineBMI()
    }
}