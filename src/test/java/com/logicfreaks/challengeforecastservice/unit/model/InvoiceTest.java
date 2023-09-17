package com.logicfreaks.challengeforecastservice.unit.model;

import com.logicfreaks.challengeforecastservice.model.Debitor;
import com.logicfreaks.challengeforecastservice.model.Invoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * File:           InvoiceTest.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.model
 */
class InvoiceTest {

	private final Invoice invoice = new Invoice();

	@Test
	void test_getIdAndSetId_shouldReturn_sameAsInput() {


		//Arrange
		int id = 123;

		//Act
		invoice.setId(id);

		//Assert
		Assertions.assertEquals(id, invoice.getId());
	}

	@Test
	void test_getInvoiceNumberAndSetInvoiceNumber_shouldReturn_sameAsInput() {


		//Arrange
		int invoiceNumber = 12345667;

		//Act
		invoice.setInvoiceNumber(invoiceNumber);

		//Assert
		Assertions.assertEquals(invoiceNumber, invoice.getInvoiceNumber());
	}

	@Test
	void test_getInvoiceDateAndSetInvoiceDate_shouldReturn_sameAsInput() {


		//Arrange
		Date date = new Date();

		//Act
		invoice.setInvoiceDate(date);

		//Assert
		Assertions.assertEquals(date, invoice.getInvoiceDate());
	}

	@Test
	void test_getNettoAmountAndSetNettoAmount_shouldReturn_sameAsInput() {


		//Arrange
		double nettoAmount = 2000;

		//Act
		invoice.setNettoAmount(nettoAmount);

		//Assert
		Assertions.assertEquals(nettoAmount, invoice.getNettoAmount());
	}

	@Test
	void test_getBruttoAmountAndSetBruttoAmount_shouldReturn_sameAsInput() {

		//Arrange
		double bruttoAmount = 2000;

		//Act
		invoice.setBruttoAmount(bruttoAmount);

		//Assert
		Assertions.assertEquals(bruttoAmount, invoice.getBruttoAmount());
	}

	@Test
	void test_getPhoneNumberAndSetPhoneNumber_shouldReturn_sameAsInput() {


		//Arrange
		String status = "status";

		//Act
		invoice.setStatus(status);

		//Assert
		Assertions.assertEquals(status, invoice.getStatus());
	}

	@Test
	void test_getBalancAndSetBalance_shouldReturn_sameAsInput() {


		//Arrange
		double balance = 2.2;

		//Act
		invoice.setBalance(balance);

		//Assert
		Assertions.assertEquals(balance, invoice.getBalance());
	}

	@Test
	void test_getDebitorAndSetDebitor_shouldReturn_sameAsInput() {


		//Arrange
		Debitor debitor = new Debitor();

		//Act
		invoice.setDebitor(debitor);

		//Assert
		Assertions.assertEquals(debitor, invoice.getDebitor());
	}

	@Test
	void test_equals_shouldReturn_true_withSameObject() {

		//Act
		boolean equality = invoice.equals(invoice);
		//Assert
		Assertions.assertTrue(equality);
	}

	@Test
	void test_equals_shouldReturn_false_withOtherObject() {

		//Act
		boolean unequal = invoice.equals("String");

		//Assert
		Assertions.assertFalse(unequal);
	}

	@Test
	void test_hashCode_shouldReturn_sameValue_onSameObject_allTheTime() {

		//Act
		int hashCode = invoice.hashCode();
		int sameHashCode = invoice.hashCode();

		//Assert
		Assertions.assertEquals(hashCode, sameHashCode);
	}

	@Test
	void test_toString_shouldContain_allProperties_asStringValues() {

		//Arrange
		String[] necessaryValues = {"id", "invoiceNumber", "invoiceDate", "nettoAmount", "bruttoAmount", "status", "balance", "debitor"};

		//Act
		String resultString = invoice.toString();

		for (String necessaryValue : necessaryValues) {

			//Assert
			Assertions.assertTrue(resultString.contains(necessaryValue));
		}
	}
}
