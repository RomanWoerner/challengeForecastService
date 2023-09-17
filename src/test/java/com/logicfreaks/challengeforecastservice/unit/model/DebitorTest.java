package com.logicfreaks.challengeforecastservice.unit.model;

import com.logicfreaks.challengeforecastservice.model.Debitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * File:           DebitorTest.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.model
 */
class DebitorTest {

	private final Debitor debitor = new Debitor();

	@Test
	void test_getIdAndSetId_shouldReturn_sameAsInput() {


		//Arrange
		int id = 123;

		//Act
		debitor.setId(id);

		//Assert
		Assertions.assertEquals(id, debitor.getId());
	}

	@Test
	void test_getNameAndSetName_shouldReturn_sameAsInput() {


		//Arrange
		String name = "name";

		//Act
		debitor.setName(name);

		//Assert
		Assertions.assertEquals(name, debitor.getName());
	}

	@Test
	void test_getLocationAndSetLocation_shouldReturn_sameAsInput() {


		//Arrange
		String location = "location";

		//Act
		debitor.setLocation(location);

		//Assert
		Assertions.assertEquals(location, debitor.getLocation());
	}

	@Test
	void test_getCountryAndSetCountry_shouldReturn_sameAsInput() {


		//Arrange
		String country = "country";

		//Act
		debitor.setCountry(country);

		//Assert
		Assertions.assertEquals(country, debitor.getCountry());
	}

	@Test
	void test_getPostcodeAndSetPostCode_shouldReturn_sameAsInput() {


		//Arrange
		String postcode = "postcode";

		//Act
		debitor.setPostcode(postcode);

		//Assert
		Assertions.assertEquals(postcode, debitor.getPostcode());
	}

	@Test
	void test_getPhoneNumberAndSetPhoneNumber_shouldReturn_sameAsInput() {


		//Arrange
		String phoneNumber = "phoneNumber123456";

		//Act
		debitor.setPhoneNumber(phoneNumber);

		//Assert
		Assertions.assertEquals(phoneNumber, debitor.getPhoneNumber());
	}

	@Test
	void test_getEmailAndSetEmail_shouldReturn_sameAsInput() {


		//Arrange
		String email = "email@mail";

		//Act
		debitor.setEmail(email);

		//Assert
		Assertions.assertEquals(email, debitor.getEmail());
	}

	@Test
	void test_equals_shouldReturn_true_withSameObject() {

		//Act
		boolean equality = debitor.equals(debitor);
		//Assert
		Assertions.assertTrue(equality);
	}

	@Test
	void test_equals_shouldReturn_false_withOtherObject() {

		//Act
		boolean unequal = debitor.equals("String");

		//Assert
		Assertions.assertFalse(unequal);
	}

	@Test
	void test_hashCode_shouldReturn_sameValue_onSameObject_allTheTime() {

		//Act
		int hashCode = debitor.hashCode();
		int sameHashCode = debitor.hashCode();

		//Assert
		Assertions.assertEquals(hashCode, sameHashCode);
	}

	@Test
	void test_toString_shouldContain_allProperties_asStringValues() {

		//Arrange
		String[] necessaryValues = {"id", "name", "location", "country", "postcode", "phoneNumber", "email"};

		//Act
		String resultString = debitor.toString();

		for (String necessaryValue : necessaryValues) {

			//Assert
			Assertions.assertTrue(resultString.contains(necessaryValue));
		}
	}
}
