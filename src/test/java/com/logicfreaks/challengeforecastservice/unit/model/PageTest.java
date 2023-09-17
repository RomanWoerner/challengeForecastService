package com.logicfreaks.challengeforecastservice.unit.model;

import com.logicfreaks.challengeforecastservice.model.Embedded;
import com.logicfreaks.challengeforecastservice.model.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * File:           PageTest.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.model
 */
public class PageTest {


	private final Page page = new Page();

	@Test
	void test_getPageAndSetPage_shouldReturn_sameAsInput() {

		//Arrange
		int pageNr = 1;

		//Act
		page.setPage(pageNr);

		//Assert
		Assertions.assertEquals(pageNr, page.getPage());
	}

	@Test
	void test_getPageSizeAndSetPageSize_shouldReturn_sameAsInput() {

		//Arrange
		int size = 1;

		//Act
		page.setPageSize(size);

		//Assert
		Assertions.assertEquals(size, page.getPageSize());
	}

	@Test
	void test_getPageCountAndSetPageCount_shouldReturn_sameAsInput() {

		//Arrange
		int count = 1;

		//Act
		page.setPageCount(count);

		//Assert
		Assertions.assertEquals(count, page.getPageCount());
	}

	@Test
	void test_getTotalItemsAndSetTotalItems_shouldReturn_sameAsInput() {

		//Arrange
		int totalItems = 1;

		//Act
		page.setTotalItems(totalItems);

		//Assert
		Assertions.assertEquals(totalItems, page.getTotalItems());
	}

	@Test
	void test_getEmbeddedAndSetEmbedded_shouldReturn_sameAsInput() {

		//Arrange
		Embedded embedded = new Embedded();

		//Act
		page.setEmbedded(embedded);

		//Assert
		Assertions.assertEquals(embedded, page.getEmbedded());
	}

	@Test
	void test_equals_shouldReturn_true_withSameObject() {

		//Act
		boolean equality = page.equals(page);
		//Assert
		Assertions.assertTrue(equality);
	}

	@Test
	void test_equals_shouldReturn_false_withOtherObject() {

		//Act
		boolean unequal = page.equals("String");

		//Assert
		Assertions.assertFalse(unequal);
	}

	@Test
	void test_hashCode_shouldReturn_sameValue_onSameObject_allTheTime() {

		//Act
		int hashCode = page.hashCode();
		int sameHashCode = page.hashCode();

		//Assert
		Assertions.assertEquals(hashCode, sameHashCode);
	}

	@Test
	void test_toString_shouldContain_allProperties_asStringValues() {

		//Arrange
		String[] necessaryValues = {"page", "pageSize", "totalItems", "pageCount", "embedded"};

		//Act
		String resultString = page.toString();

		for (String necessaryValue : necessaryValues) {

			//Assert
			Assertions.assertTrue(resultString.contains(necessaryValue));
		}
	}
}
