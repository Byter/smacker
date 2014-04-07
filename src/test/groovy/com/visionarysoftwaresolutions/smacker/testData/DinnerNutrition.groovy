package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.smacker.api.nutrition.*
import com.visionarysoftwaresolutions.smacker.api.units.Grams

public class DinnerNutrition implements NutritionalInformation {

    public Calories getCalories() {
        return new Calories() {
            public double getTotal() {
                return 340;
            }

            public double getFromFat() {
                return 60;
            }
        };
    }

    public Fat getFat() {
        return new Fat() {
            public Grams getTotal() {
                return new StandardGram(6);
            }

            public Grams getFromSaturated() {
                return new StandardGram(2);
            }

            public Grams getFromTrans() {
                return new StandardGram(0);
            }
        };
    }

    public Cholesterol getCholesterol() {
        return new Cholesterol() {

            public Grams getTotal() {
                return new StandardGram(8);
            }

        };
    }

    public Carbohydrates getCarbohydrates() {
        return new Carbohydrates() {

            public Grams getTotal() {
                return new StandardGram(26);
            }

            public Grams getFiber() {
                return new StandardGram(9);
            }

            public Grams getSugar() {
                return new StandardGram(7);
            }

        };
    }

    public Sodium getSodium() {
        return new Sodium() {
            public Grams getTotal() {
                return new StandardGram(4.35);
            }
        };
    }

    public Protein getProtein() {
        return new Protein() {
            public Grams getTotal() {
                return new StandardGram(50);
            }

        };
    }

    public Vitamins getVitamins() {
        return new Vitamins() {
            private final Map<String, Double> vitamins = new HashMap<String, Double>();

            {
                vitamins.put("A", 0d);
                vitamins.put("C", 0d);
                vitamins.put("Calcium", 10d);
                vitamins.put("Iron", 12d);
                vitamins.put("Zinc", 20d);
                vitamins.put("D", 24d);
                vitamins.put("Niacin", 140d);
                vitamins.put("B6", 24d);
                vitamins.put("B12", 40d);
                vitamins.put("Selenium", 280d);
            }

            public double getPercent(String vitaminName) {
                return vitamins.get(vitaminName);
            }
        };
    }

}
