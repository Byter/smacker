package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.ContactInformation
import com.visionarysoftwaresolutions.smacker.api.EmailAddress
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
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime
import groovy.time.TimeDuration

import java.text.SimpleDateFormat

class TestFixtures {

    static User createNick() {
        new Smacker(name:"Nick", description:"test")
    }
	
    static Meal createDinner() {
        new Dinner()
    }

    static MealItem canOTuna() {
        [
                getName : { "2 oz can" },
                getDescription : { "starkist tuna" }

        ] as MealItem
    }

    static MealItem fiberPlusBar() {
        [

        ] as MealItem
    }
	
	static CalendarTime createMealTimeTwoDaysAway() {
		Date twoDaysAway = new Date() + 2
		new SomeCalendarTime(twoDaysAway)
	}

    static CalendarTime createMealTimeNow() {
        new SomeCalendarTime(new Date())
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

    static CalendarTime createMealTimeIn20Minutes() {
        Date thirtyMinutes = new TimeDuration(0,20,0,0) + new Date()
        new SomeCalendarTime(thirtyMinutes)
    }

    static Diet anythingDiet() {
        new AnythingDiet(name:"anything", description: "I do what I want")
    }

    static ContactInformation createContactInfo() {
        new ContactInformation() {
            @Override
            EmailAddress getEmailAddress() {
                return new EmailAddress() {
                    @Override
                    String getUserName() { "visionary.software.solutions" }

                    @Override
                    String getDomain() { "gmail.com" }

                    @Override
                    String toString() { "${getUserName()}@${getDomain()}" }
                }
            }

            @Override
            String getFullName() { "Nick Vaidyanathan" }

            @Override
            CalendarDay getDayOfBirth() {
                return new CalendarDay() {
                    @Override
                    String getMonth() { "06" }

                    @Override
                    String getDay() { "11" }

                    @Override
                    String getYear() { "1985" }

                    @Override
                    Date asDate() {
                        Calendar cal = Calendar.getInstance()
                        cal.set(1985, 06, 11)
                        return cal.time
                    }

                    @Override
                    int compareTo(CalendarDay o) {
                        asDate().compareTo(o.asDate())
                    }
                }
            }
        }
    }

    static Allergy createOysterAllergy() {
        new Allergy() {

            @Override
            String getAllergen() {
                "oyster"
            }

            @Override
            String getSeverity() {
                "severe"
            }
        }
    }

    static Meal createOysterDinner() {
        new Meal() {

            @Override
            CalendarDay eatenAt() {
                return createMealTimeNow()
            }

            @Override
            void addItem(MealItem eaten) {
                throw new UnsupportedOperationException()
            }

            @Override
            List<MealItem> getItems() {
                [ ]
            }

            @Override
            String getName() {
                "Oysters rockefeller"
            }

            @Override
            String getDescription() {
                "a local favorite"
            }
        }
    }

    static Meal createOysterMeal() {
        new Meal() {
            @Override
            CalendarDay eatenAt() {
                throw new UnsupportedOperationException()
            }

            @Override
            void addItem(MealItem eaten) {
                throw new UnsupportedOperationException()
            }

            @Override
            List<MealItem> getItems() {
                [ [ getName: { "oyster" } ,
                    getDescription : { "fishy" } ] as MealItem ]
            }

            @Override
            String getName() {
                "fke meal"
            }

            @Override
            String getDescription() {
                "no descp"
            }
        }
    }

    static Diet createPaleo() {
        return new Paleo()
    }
}