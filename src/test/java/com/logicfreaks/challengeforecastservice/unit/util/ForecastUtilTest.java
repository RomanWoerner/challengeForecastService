package com.logicfreaks.challengeforecastservice.unit.util;

import com.logicfreaks.challengeforecastservice.model.Forecast;
import com.logicfreaks.challengeforecastservice.model.Invoice;
import com.logicfreaks.challengeforecastservice.unit.testdata.InvoiceTestData;
import com.logicfreaks.challengeforecastservice.util.ForecastUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * File:           ForecastUtilTest.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.util
 */
class ForecastUtilTest {

	@Test
	void test_roundValue_shouldReturn_roundedValue() {

		//Arrange
		double unRounded = 2.222;

		//Act
		double rounded = ForecastUtil.roundValue(unRounded);

		//Assert
		Assertions.assertNotEquals(unRounded, rounded);
	}

	@Test
	void test_calculateForecast_shouldReturn_forecastWith_averageValues_and_givenTimeFrame() {

		//Arrange
		List<Invoice> invoiceList = InvoiceTestData.setUpValidInvoiceList();
		int timeFrame = 12;

		//Act
		Forecast forecast = ForecastUtil.calculateForecast(invoiceList, timeFrame);


		//Assert
		/*
			The Average Value is always 2, because it's set up with 2 in TestData Class.
		 */
		Assertions.assertEquals(2, forecast.getBrutto());
		Assertions.assertEquals(2, forecast.getNetto());
		Assertions.assertEquals("Months", forecast.getTimeFrameUnit());
		Assertions.assertEquals(timeFrame, forecast.getTimeFrame()
		);

	}
}
