package com.logicfreaks.challengeforecastservice.unit.model;

import com.logicfreaks.challengeforecastservice.model.Embedded;
import com.logicfreaks.challengeforecastservice.model.Invoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * File:           EmbeddedTest.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.model
 */
class EmbeddedTest {

	private final Embedded embedded = new Embedded();

	@Test
	void test_SetInvoiceListAndGetInvoiceList_shouldReturn_sameAsInput() {

		//Arrange
		List<Invoice> invoiceList = new ArrayList<>();

		//Act
		embedded.setInvoiceList(invoiceList);

		//Assert
		Assertions.assertEquals(invoiceList, embedded.getInvoiceList());
	}


	@Test
	void test_equals_shouldReturn_true_withSameObject() {

		//Act
		boolean equality = embedded.equals(embedded);
		//Assert
		Assertions.assertTrue(equality);
	}

	@Test
	void test_equals_shouldReturn_false_withOtherObject() {

		//Act
		boolean unequal = embedded.equals("String");

		//Assert
		Assertions.assertFalse(unequal);
	}

	@Test
	void test_hashCode_shouldReturn_sameValue_onSameObject_allTheTime() {

		//Act
		int hashCode = embedded.hashCode();
		int sameHashCode = embedded.hashCode();

		//Assert
		Assertions.assertEquals(hashCode, sameHashCode);
	}

	@Test
	void test_toString_shouldContain_allProperties_asStringValues() {

		//Arrange
		String[] necessaryValues = {"invoiceList"};

		//Act
		String resultString = embedded.toString();

		for (String necessaryValue : necessaryValues) {

			//Assert
			Assertions.assertTrue(resultString.contains(necessaryValue));
		}
	}

}
