package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.ContactInformation
import com.visionarysoftwaresolutions.smacker.api.EmailAddress
import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay
import com.visionarysoftwaresolutions.smacker.testData.TestFixtures

class ContactInfoSpec extends spock.lang.Specification {
    def "user has contact info"() {
        given: "A user to associate contact info for"
            User nick = TestFixtures.createNick()
        and: "some contact information for the user"
            ContactInformation comeAtMe = TestFixtures.createContactInfo()
        when: "i set nick's contact information"
            nick.setContactInformation(comeAtMe)
        then: "nick has contact information"
            comeAtMe == nick.getContactInformation()
    }

    def "contact information includes the email address"() {
        given: "some contact information"
            ContactInformation comeAtMe = TestFixtures.createContactInfo()
        when: "i ask for the e-mail address"
            EmailAddress address = comeAtMe.getEmailAddress()
        then: "the address email is visionary.software.solutions@gmail.com"
            "visionary.software.solutions@gmail.com" == address.toString()
    }

    def "contact information includes user's full name"() {
        given: "some contact information"
            ContactInformation comeAtMe = TestFixtures.createContactInfo()
        when: "i ask for the name"
            String name = comeAtMe.getFullName()
        then: "the name is Nick Vaidyanathan"
            "Nick Vaidyanathan" == name
    }

    def "contact information includes user's calendar day of birth"() {
        given: "some contact information"
            ContactInformation comeAtMe = TestFixtures.createContactInfo()
        when: "i ask for the name"
            CalendarDay dob = comeAtMe.getDayOfBirth()
        then: "the year is 1985"
            "1985" == dob.year
        and: "the month is 06"
            "06" == dob.month
        and: "the day is 11"
            "11" == dob.day
    }
}
