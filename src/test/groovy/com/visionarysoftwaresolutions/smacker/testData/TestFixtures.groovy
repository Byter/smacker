package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.ContactInformation
import com.visionarysoftwaresolutions.smacker.api.EmailAddress
import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.diet.restrictions.*
import com.visionarysoftwaresolutions.smacker.api.meals.Meal
import com.visionarysoftwaresolutions.smacker.api.meals.MealItem
import com.visionarysoftwaresolutions.smacker.api.meals.MealItems
import com.visionarysoftwaresolutions.smacker.api.meals.MealPlanningStrategy
import com.visionarysoftwaresolutions.smacker.api.nutrition.analysis.TotalIntakeAnalyzer
import com.visionarysoftwaresolutions.smacker.api.physique.*
import com.visionarysoftwaresolutions.smacker.api.time.CalendarDay
import com.visionarysoftwaresolutions.smacker.api.time.CalendarTime
import groovy.time.TimeDuration

class TestFixtures {

    static User createNick() {
        new Smacker(name: "Nick", description: "test")
    }

    static Meal createDinner() {
        new Dinner()
    }

    static MealItem canOTuna() {
        [
                getName       : { "2 oz can" },
                getDescription: { "starkist tuna" }

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
        new ImperialHeight(value: 12 * 5 + 11)
    }

    static BodyFat twentyThreePercentBodyFat() {
        new BodyFatPercentage(value: 23)
    }

    static BMI twentyOnePointNineBMI() {
        new NationalHeartAndBloodInstituteBMI(value: 21.9)
    }

    static Physique createImperialPhysique() {
        [
                getWeight : { twoHundredTenPounds() },
                getHeight : { fiveFeetElevenInches() },
                getBodyFat: { twentyThreePercentBodyFat() },
                getBMI    : { twentyOnePointNineBMI() }
        ] as Physique
    }

    static Physique createMetricPhysique() {
        [
                getWeight : { ninetyFiveKilos() },
                getHeight : { onePointEightMeters() },
                getBodyFat: { twentyThreePercentBodyFat() },
                getBMI    : { twentyOnePointNineBMI() }
        ] as Physique
    }

    static Weight ninetyFiveKilos() {
        new MetricWeight(value: 95)
    }

    static Height onePointEightMeters() {
        new MetricHeight(value: 1.8)
    }

    static User createBarb() {
        new Smacker(name: "Barb", description: "test")
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
        new Vegetarian() {}
    }

    static DietaryRestriction createVegan() {
        new Vegan() {}
    }

    static DietaryRestriction createKosher() {
        new Kosher() {}
    }

    static DietaryRestriction createHalal() {
        new Halal() {}
    }

    static CalendarTime createMealTimeIn20Minutes() {
        Date thirtyMinutes = new TimeDuration(0, 20, 0, 0) + new Date()
        new SomeCalendarTime(thirtyMinutes)
    }

    static Diet anythingDiet() {
        new AnythingDiet(name: "anything", description: "I do what I want")
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
            MealItems getItems() {
                null
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
        MealItems items = new MealItemsList()
        items.add([getName       : { "oyster" }, getDescription: { "fishy" }] as MealItem)
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
            MealItems getItems() {
                items
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

    static Meal createDessert() {
        return new Meal() {

            @Override
            CalendarDay eatenAt() {
                return null
            }

            @Override
            void addItem(MealItem eaten) {

            }

            @Override
            MealItems getItems() {
                return null
            }

            @Override
            String getName() {
                return "Vanilla Ice cream"
            }

            @Override
            String getDescription() {
                return "Sweet vanilla ice creams"
            }
        }
    }

    static MealPlanningStrategy createMealPlanningStrategy() {
        new BasicMealPlanningStrategy()
    }
}