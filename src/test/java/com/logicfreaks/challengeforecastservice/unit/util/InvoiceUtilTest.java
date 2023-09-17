package com.logicfreaks.challengeforecastservice.unit.util;

import com.logicfreaks.challengeforecastservice.model.Invoice;
import com.logicfreaks.challengeforecastservice.unit.testdata.InvoiceTestData;
import com.logicfreaks.challengeforecastservice.util.InvoiceUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * File:           InvoiceUtilTest.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.util
 */
class InvoiceUtilTest {

	@Test
	void test_isValid_shouldReturn_true() {

		//Arrange
		Invoice invoice = InvoiceTestData.setUpValidInvoiceTestData();

		//Act
		boolean validity = InvoiceUtil.invoiceIsValid(invoice);

		//Assert
		Assertions.assertTrue(validity);
	}

	@Test
	void test_isValid_shouldReturn_false() {

		//Arrange
		Invoice invoice = new Invoice();

		//Act
		boolean validity = InvoiceUtil.invoiceIsValid(invoice);

		//Assert
		Assertions.assertFalse(validity);
	}

	@Test
	void test_sortListByDate_shouldSort_givenElements() throws ParseException {

		//Arrange
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date laterDate = dateFormat.parse("01.01.2023");
		Date earlyDate = dateFormat.parse("01.01.2022");

		Invoice shouldBeOnfFirstPlaceAfterSort = new Invoice();
		shouldBeOnfFirstPlaceAfterSort.setInvoiceDate(earlyDate);

		Invoice shouldBeOnLastPlaceAfterSort = new Invoice();
		shouldBeOnLastPlaceAfterSort.setInvoiceDate(laterDate);

		List<Invoice> invoiceList = new ArrayList<>();

		invoiceList.add(shouldBeOnLastPlaceAfterSort);
		invoiceList.add(shouldBeOnfFirstPlaceAfterSort);

		//Call by reference
		InvoiceUtil.sortListByDate(invoiceList);


		Assertions.assertEquals(shouldBeOnfFirstPlaceAfterSort, invoiceList.get(0));
		Assertions.assertEquals(shouldBeOnLastPlaceAfterSort, invoiceList.get(1));
	}

	@Test
	void test_adaptInvoices_shouldRemove_invalidInvoicesFromList() {

		//Arrange
		List<Invoice> invoiceList = InvoiceTestData.setUpValidInvoiceList();
		Invoice invalidInvoice = new Invoice();

		invoiceList.add(invalidInvoice);

		int oldListSize = invoiceList.size(); //Should be reduced by 1 after function call.

		//Call by reference
		InvoiceUtil.adaptInvoices(invoiceList);

		int newSize = invoiceList.size();

		Assertions.assertNotEquals(oldListSize, newSize);
	}

	@Test
	void test_calculateMonthFromNow_shouldReturn_decreasedMonth() {


		//Act
		String date = InvoiceUtil.calculateMonthFromNow(0);
		String shouldBeEqual = InvoiceUtil.calculateMonthFromNow(0);
		String shouldNotBeEqual = InvoiceUtil.calculateMonthFromNow(-1);

		Assertions.assertEquals(shouldBeEqual, date);
		Assertions.assertNotEquals(shouldNotBeEqual, date);
	}

	@Test
	void test_removeTooOldData_shouldRemove_invalidInvoicesFromList() throws ParseException {

		//Arrange
		int timeFrame = 12;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date oldDate = dateFormat.parse("01.01.2020");

		List<Invoice> invoiceList = InvoiceTestData.setUpValidInvoiceList();
		Invoice invalidInvoice = new Invoice();
		invalidInvoice.setInvoiceDate(oldDate);

		invoiceList.add(invalidInvoice);

		int oldSize = invoiceList.size();

		//Act
		//Call by reference
		InvoiceUtil.removeTooOldData(invoiceList, timeFrame);

		int newSize = invoiceList.size();

		//Assert
		Assertions.assertEquals((oldSize - 1), newSize);
		Assertions.assertNotEquals(oldSize, newSize);

	}
}
