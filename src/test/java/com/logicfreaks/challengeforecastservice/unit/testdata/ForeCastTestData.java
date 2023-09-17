package com.logicfreaks.challengeforecastservice.unit.testdata;

import com.logicfreaks.challengeforecastservice.model.Forecast;

/**
 * File:           ForeCastTestData.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.testdata
 */
public class ForeCastTestData {

	/**
	 * This Class only contains boilerplate Code for setUp testData without logic
	 */

	public static Forecast setUpForecastTestData() {

		return new Forecast.ForecastBuilder(12).setTimeFrameUnit("month").setNetto(2795).setBrutto(4416).build();
	}
}
