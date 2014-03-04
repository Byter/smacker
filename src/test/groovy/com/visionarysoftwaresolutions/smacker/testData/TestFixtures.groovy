package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.meals.*
import com.visionarysoftwaresolutions.smacker.api.nutrition.analysis.TotalIntakeAnalyzer

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
	
	static MealTime createMealTime() {
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
	
	static TotalIntakeAnalyzer intakeAnalyzer() {
		new BasicIntakeAnalyzer()
	}
}
