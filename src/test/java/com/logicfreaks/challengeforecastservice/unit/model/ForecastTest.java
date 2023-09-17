package com.logicfreaks.challengeforecastservice.unit.model;

import com.logicfreaks.challengeforecastservice.model.Forecast;
import com.logicfreaks.challengeforecastservice.unit.testdata.ForeCastTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * File:           ForecastTest.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.model
 */
class ForecastTest {

	private final Forecast forecast = ForeCastTestData.setUpForecastTestData();

	@Test
	void test_forecastBuilder_shouldBuild_forecastObject_withGivenParameters() {


		//Arrange
		int timeFrame = 12;
		String timeFrameUnit = "Monthly";
		double netto = 2796.26;
		double brutto = 4416;

		//Act
		Forecast forecast = new Forecast.ForecastBuilder(12).setTimeFrameUnit(timeFrameUnit).setNetto(netto).setBrutto(brutto).build();

		//Assert
		Assertions.assertEquals(netto, forecast.getNetto());
		Assertions.assertEquals(brutto, forecast.getBrutto());
		Assertions.assertEquals(timeFrameUnit, forecast.getTimeFrameUnit());
		Assertions.assertEquals(timeFrame, forecast.getTimeFrame());
	}

	@Test
	void test_equals_shouldReturn_true_withSameObject() {

		//Act
		boolean equality = forecast.equals(forecast);
		//Assert
		Assertions.assertTrue(equality);
	}

	@Test
	void test_equals_shouldReturn_false_withOtherObject() {

		//Act
		boolean unequal = forecast.equals("String");

		//Assert
		Assertions.assertFalse(unequal);
	}

	@Test
	void test_hashCode_shouldReturn_sameValue_onSameObject_allTheTime() {

		//Act
		int hashCode = forecast.hashCode();
		int sameHashCode = forecast.hashCode();

		//Assert
		Assertions.assertEquals(hashCode, sameHashCode);
	}

	@Test
	void test_toString_shouldContain_allProperties_asStringValues() {

		//Arrange
		String[] necessaryValues = {"brutto", "netto", "timeFrame", "timeFrameUnit"};

		//Act
		String resultString = forecast.toString();

		for (String necessaryValue : necessaryValues) {

			//Assert
			Assertions.assertTrue(resultString.contains(necessaryValue));
		}
	}
}
