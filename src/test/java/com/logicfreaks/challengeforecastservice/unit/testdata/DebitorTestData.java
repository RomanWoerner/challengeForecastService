package com.logicfreaks.challengeforecastservice.unit.testdata;

import com.logicfreaks.challengeforecastservice.model.Debitor;

/**
 * File:           DebitorTestData.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.testdata
 */
public class DebitorTestData {

	public static Debitor setUpDebitorTestData() {

		Debitor debitor = new Debitor();

		debitor.setEmail("Mail@Mail");
		debitor.setId(1);
		debitor.setPhoneNumber("10236354");
		debitor.setLocation("Heidenheim");
		debitor.setName("Foo Bar");
		debitor.setPostcode("89520");
		debitor.setCountry("German");

		return debitor;
	}
}
