package com.logicfreaks.challengeforecastservice.unit.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.logicfreaks.challengeforecastservice.model.Page;
import com.logicfreaks.challengeforecastservice.unit.testdata.PageTestData;
import com.logicfreaks.challengeforecastservice.util.JsonUtil;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * File:           JsonUtilTest.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.util
 */
class JsonUtilTest {

	@Test
	void parseObjectToJson_shouldReturn_null_withNullObject() {

		//Act & Assert
		assertThrows(IllegalArgumentException.class, () -> JsonUtil.paseObjectToJson(null));
	}

	@Test
	void testParseJsonToObject_shouldReturn_null_withNullClazz() {

		String testString = "TestString";
		//Act & Assert
		assertThrows(IllegalArgumentException.class, () -> JsonUtil.parseJsonToObject(testString, null));
	}

	@Test
	void testParseJsonToObject_shouldReturn_null_withBlankString() {

		//Act & Assert
		assertThrows(IllegalArgumentException.class, () -> JsonUtil.parseJsonToObject("", Map.class));
	}

	@Test
	void testParseJsonToObject_shouldReturn_nullWithError() {

		//Arrange
		String invalidJson = "invalidJson";

		//Act & Assert
		assertThrows(JsonParseException.class, () -> JsonUtil.parseJsonToObject(invalidJson, Map.class));
	}

	@Test
	void testParseJsonToObject_shouldReturn_wellObject() throws JsonProcessingException {

		//Arrange
		Page page = PageTestData.setUpPageTestData();
		String pageString = JsonUtil.paseObjectToJson(page);

		//Act
		Page pageResult = JsonUtil.parseJsonToObject(pageString, Page.class);
		String resultString = JsonUtil.paseObjectToJson(pageResult);

		boolean equality = resultString.equals(pageString);

		//Assert
		assertTrue(equality);

	}
}
