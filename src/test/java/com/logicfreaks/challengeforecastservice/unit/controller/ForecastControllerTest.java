package com.logicfreaks.challengeforecastservice.unit.controller;

import com.logicfreaks.challengeforecastservice.controller.ForecastController;
import com.logicfreaks.challengeforecastservice.model.Forecast;
import com.logicfreaks.challengeforecastservice.service.ForecastService;
import com.logicfreaks.challengeforecastservice.unit.testdata.ForeCastTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * File:           InvoiceControllerTest.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.controller
 */
@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ForecastControllerTest {

	@Mock
	private ForecastService forecastService;

	@InjectMocks
	private ForecastController forecastController;

	@Test
	void test_getForecast_shouldReturn_stubbedObject_andStatusCode_200() {

		//Arrange
		Forecast forecast = ForeCastTestData.setUpForecastTestData();

		//Configure
		when(forecastService.getForecast()).thenReturn(forecast);

		//Act
		ResponseEntity<Forecast> result = forecastController.getForecast();

		//Assert
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(forecast, result.getBody());
	}
}
