package com.logicfreaks.challengeforecastservice.unit.testdata;

import com.logicfreaks.challengeforecastservice.model.Embedded;

/**
 * File:           EmbeddedTestData.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.testdata
 */
public class EmbeddedTestData {

	public static Embedded setUpEmbeddedTestData() {

		Embedded embedded = new Embedded();

		embedded.setInvoiceList(InvoiceTestData.setUpValidInvoiceList());

		return embedded;
	}
}
