package com.visionarysoftwaresolutions.smacker

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Allergy
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestriction
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestrictions
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.GlutenFree
import com.visionarysoftwaresolutions.smacker.testData.Smacker
import com.visionarysoftwaresolutions.smacker.testData.TestFixtures

class DietaryRestrictionsSpec extends spock.lang.Specification {
    def "users have no dietary restrictions by default"() {
        given: "I have a user nick"
            User nick = TestFixtures.createNick()
        when: "I ask for Nick's dietary restrictions"
            DietaryRestrictions restrictions = nick.dietaryRestrictions
        then: "there are no restrictions"
            restrictions.isEmpty()
    }

    def "user can add diabetes"() {
        given : "I have a user Barbara"
            User barb = TestFixtures.createBarb()
        and: "a dietary restriction of Diabetes"
            DietaryRestriction diabetes = TestFixtures.createDiabetes()
        when: "Barb sets that she is diabetic"
            barb.addDietaryRestriction(diabetes)
        then: "barb has a dietary restriction"
            DietaryRestrictions restrictions = barb.dietaryRestrictions
            !restrictions.isEmpty()
        and: "her restriction list contains diabetes"
            restrictions.contains(diabetes)
    }

    def "user can add allergies"() {
        given : "I have a user Barbara"
            User barb = TestFixtures.createBarb()
        when: "Barb sets that she has an allergy"
            Allergy oyster = TestFixtures.createOysterAllergy()
            barb.addAllergy(oyster)
        then: "barb has a dietary restriction"
            DietaryRestrictions restrictions = barb.dietaryRestrictions
            !restrictions.isEmpty()
        and: "her restriction list contains an allergy"
            restrictions.hasAllergies()
        and: "and the allergen is oyster"
            restrictions.isAllergicTo(oyster.allergen)
    }

    def "user can add gluten free"() {
        given : "I have a user Aaron"
            User aaron = new Smacker(name:"Aaron", description:"bro")
        and: "a dietary restriction of GlutenFree"
            GlutenFree gluten = TestFixtures.createGlutenFree()
        when: "aaron sets that he is gluten free"
            aaron.addDietaryRestriction(gluten)
        then: "aaron has a dietary restriction"
            DietaryRestrictions restrictions = aaron.dietaryRestrictions
            !restrictions.isEmpty()
        and: "the restriction list contains gluten"
            restrictions.hasAllergies()
        and: "and the allergen is gluten"
            restrictions.isAllergicTo(gluten.allergen)
    }

    def "user can add lactose intolerant"() {
        given : "I have a user Thor"
            User thor = new Smacker(name:"Thor", description:"bro")
        and: "a dietary restriction of Lactose Intolerance"
            DietaryRestriction lactose = TestFixtures.createLactoseIntolerance()
        when: "thor sets that he is lactose intolerant"
            thor.addDietaryRestriction(lactose)
        then: "thor has a dietary restriction"
            DietaryRestrictions restrictions = thor.dietaryRestrictions
            !restrictions.isEmpty()
        and: "the restriction list contains lactose"
            restrictions.hasAllergies()
        and: "and the allergen is lactose"
            restrictions.isAllergicTo(lactose.allergen)
    }

    def "user can add vegetarian"() {
        given : "I have a user Ankit"
            User ankit = new Smacker(name:"Ankit", description:"bro")
        and: "a dietary restriction of Vegetarian"
            DietaryRestriction vegetarian = TestFixtures.createVegetarian()
        when: "ankit sets that he is vegetarian"
            ankit.addDietaryRestriction(vegetarian)
        then: "ankit has a dietary restriction"
            DietaryRestrictions restrictions = ankit.dietaryRestrictions
            !restrictions.isEmpty()
        and: "the restriction list contains vegetarian"
            restrictions.isVegetarian()
    }

    def "user can add vegan"() {
        given : "I have a user Joseph"
            User joseph = new Smacker(name:"Joseph", description:"bro")
        and: "a dietary restriction of Vegetarian"
            DietaryRestriction vegan = TestFixtures.createVegan()
        when: "joseph sets that he is vegan"
            joseph.addDietaryRestriction(vegan)
        then: "joseph has a dietary restriction"
            DietaryRestrictions restrictions = joseph.dietaryRestrictions
            !restrictions.isEmpty()
        and: "the restriction list contains vegan"
            restrictions.isVegan()
    }

    def "user can add kosher"() {
        given : "I have a user Daniel"
            User daniel = new Smacker(name:"Daniel", description:"bro")
        and: "a dietary restriction of Kosher"
            DietaryRestriction kosher = TestFixtures.createKosher()
        when: "daniel sets that he is kosher"
            daniel.addDietaryRestriction(kosher)
        then: "daniel has a dietary restriction"
            DietaryRestrictions restrictions = daniel.dietaryRestrictions
            !restrictions.isEmpty()
        and: "the restriction list contains kosher"
            restrictions.isKosher()
    }

    def "user can add halal"() {
        given : "I have a user Muhammad"
            User tan = new Smacker(name:"Tan", description:"bro")
        and: "a dietary restriction of Halal"
            DietaryRestriction halal = TestFixtures.createHalal()
        when: "tan sets that he is halal"
            tan.addDietaryRestriction(halal)
        then: "tan has a dietary restriction"
            DietaryRestrictions restrictions = tan.dietaryRestrictions
            !restrictions.isEmpty()
        and: "the restriction list contains halal"
            restrictions.isHalal()
    }
}
