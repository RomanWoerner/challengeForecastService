package com.logicfreaks.challengeforecastservice.unit.testdata;

import com.logicfreaks.challengeforecastservice.model.Invoice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * File:           InvoiceTestData.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.testdata
 */
public class InvoiceTestData {

	/**
	 * This Class only contains boilerplate Code for setUp testData without logic.
	 * It will pass the Requirement of the timeframe.
	 */

	public static Invoice setUpValidInvoiceTestData() {
		Invoice invoice = new Invoice();


		invoice.setBruttoAmount(2);
		invoice.setBalance(2);
		invoice.setDebitor(DebitorTestData.setUpDebitorTestData());
		invoice.setId(1);
		invoice.setStatus("test");
		invoice.setNettoAmount(2);
		invoice.setInvoiceDate(new Date());


		return invoice;
	}

	public static List<Invoice> setUpValidInvoiceList() {

		List<Invoice> invoiceList = new ArrayList<>();

		/*
			Add some objects.
		 */
		invoiceList.add(setUpValidInvoiceTestData());
		invoiceList.add(setUpValidInvoiceTestData());
		invoiceList.add(setUpValidInvoiceTestData());
		invoiceList.add(setUpValidInvoiceTestData());

		return invoiceList;
	}
}
