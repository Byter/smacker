package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.NationalHeartAndBloodInstituteBMI
import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.api.nutrition.analysis.TotalIntakeAnalyzer
import com.visionarysoftwaresolutions.smacker.api.physique.BMI
import com.visionarysoftwaresolutions.smacker.api.physique.BodyFat
import com.visionarysoftwaresolutions.smacker.api.physique.Height
import com.visionarysoftwaresolutions.smacker.api.physique.Physique
import com.visionarysoftwaresolutions.smacker.api.physique.Weight

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
		GregorianCalendar cal = new GregorianCalendar()
		cal.time = twoDaysAway
		[
			year : String.format('%tY', cal),
			month : String.format('%tB', cal),
			day : String.format('%td', cal),
			hour : String.format('%tH', cal),
			minute: String.format('%tM', cal)
		] as MealTime
	}

    static MealTime createMealTimeNow() {
        Date now = new Date()
        GregorianCalendar cal = new GregorianCalendar()
        cal.time = now
        [
                year : String.format('%tY', cal),
                month : String.format('%tB', cal),
                day : String.format('%td', cal),
                hour : String.format('%tH', cal),
                minute: String.format('%tM', cal)
        ] as MealTime
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
}
