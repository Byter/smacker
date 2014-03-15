package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.User
import com.visionarysoftwaresolutions.smacker.api.diet.Diet
import com.visionarysoftwaresolutions.smacker.api.meals.MealLog
import com.visionarysoftwaresolutions.smacker.api.meals.MealSchedule

class AnythingDiet implements Diet {
    User owner;
    String name, description;
    MealSchedule mealSchedule = new MemoryMealSchedule(belongsTo: owner)
    MealLog mealLog = new MemoryMealLog(belongsTo: owner)
}
