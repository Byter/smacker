package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.NationalHeartAndBloodInstituteBMI
import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Allergy
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Diabetes
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.DietaryRestriction
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.GlutenFree
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Halal
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Kosher
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.LactoseIntolerant
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Vegan
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.Vegetarian
import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.api.nutrition.analysis.TotalIntakeAnalyzer
import com.visionarysoftwaresolutions.smacker.api.physique.BMI
import com.visionarysoftwaresolutions.smacker.api.physique.BodyFat
import com.visionarysoftwaresolutions.smacker.api.physique.Height
import com.visionarysoftwaresolutions.smacker.api.physique.Physique
import com.visionarysoftwaresolutions.smacker.api.physique.Weight
import groovy.time.TimeDuration

class TestFixtures {

    static User createNick() {
        new Smacker(name:"Nick", description:"test")
    }
	
    static Meal createDinner() {
        new Dinner()
    }

    static MealItem canOTuna() {
        [

        ] as MealItem
    }

    static MealItem fiberPlusBar() {
        [

        ] as MealItem
    }
	
	static MealTime createMealTimeTwoDaysAway() {
		Date twoDaysAway = new Date() + 2
		new SomeMealTime(twoDaysAway)
	}

    static MealTime createMealTimeNow() {
        new SomeMealTime(new Date())
    }
	
	static TotalIntakeAnalyzer intakeAnalyzer() {
		new BasicIntakeAnalyzer()
	}

    static Weight twoHundredTenPounds() {
        new ImperialWeight(value: 210)
    }

    static Height fiveFeetElevenInches() {
        new ImperialHeight(value:12*5+11)
    }

    static BodyFat twentyThreePercentBodyFat() {
        new BodyFatPercentage(value:23)
    }

    static BMI twentyOnePointNineBMI() {
        new NationalHeartAndBloodInstituteBMI(value:21.9)
    }

    static Physique createImperialPhysique() {
        [
            getWeight : { twoHundredTenPounds() },
            getHeight : { fiveFeetElevenInches() },
            getBodyFat : { twentyThreePercentBodyFat() } ,
            getBMI : { twentyOnePointNineBMI() }
        ] as Physique
    }

    static Physique createMetricPhysique() {
        [
            getWeight : { ninetyFiveKilos() },
            getHeight : { onePointEightMeters() },
            getBodyFat : { twentyThreePercentBodyFat() } ,
            getBMI : { twentyOnePointNineBMI() }
        ] as Physique
    }

    static Weight ninetyFiveKilos() {
        new MetricWeight(value:95)
    }

    static Height onePointEightMeters() {
        new MetricHeight(value:1.8)
    }

    static User createBarb() {
        new Smacker(name:"Barb", description:"test")
    }

    static Diabetes createDiabetes() {
        new Diabetes() {}
    }

    static DietaryRestriction createGlutenFree() {
        new GlutenFree() {
            @Override
            String getSeverity() {
                return "medium"
            }
        }
    }

    static Allergy createLactoseIntolerance() {
        new LactoseIntolerant() {
            @Override
            String getSeverity() {
                "severe"
            }
        }
    }

    static DietaryRestriction createVegetarian() {
        new Vegetarian() { }
    }

    static DietaryRestriction createVegan() {
        new Vegan() { }
    }

    static DietaryRestriction createKosher() {
        new Kosher() { }
    }

    static DietaryRestriction createHalal() {
        new Halal() { }
    }

    static MealTime createMealTimeIn20Minutes() {
        Date thirtyMinutes = new TimeDuration(0,20,0,0) + new Date()
        new SomeMealTime(thirtyMinutes)
    }

    static Diet anythingDiet() {
        new AnythingDiet(name:"anything", description: "I do what I want")
    }
}
