package com.visionarysoftwaresolutions.smacker.api.nutrition;

import com.visionarysoftwaresolutions.smacker.api.units.Grams;

public interface Fat {
	Grams getTotal();
	Grams getFromSaturated();
	Grams getFromTrans();
}
