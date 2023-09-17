package com.logicfreaks.challengeforecastservice.unit.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.logicfreaks.challengeforecastservice.model.Forecast;
import com.logicfreaks.challengeforecastservice.service.ForecastService;
import com.logicfreaks.challengeforecastservice.service.InvoiceService;
import com.logicfreaks.challengeforecastservice.unit.testdata.InvoiceTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.when;

/**
 * File:           ForecastService.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.service
 */
@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ForecastServiceTest {

	@Mock
	private InvoiceService invoiceService;


	@Test
	void test_getForecast_shouldReturn_forecastObject() throws JsonProcessingException {

		ForecastService forecastService = new ForecastService(invoiceService, "12");
		//Arrange

		//Configute
		when(invoiceService.fetchAllActualInvoices()).thenReturn(InvoiceTestData.setUpValidInvoiceList());
		//Act
		Forecast forecast = forecastService.getForecast();

		//Assert
		Assertions.assertNotNull(forecast);
		Assertions.assertEquals(InvoiceTestData.setUpValidInvoiceTestData().getBruttoAmount(), forecast.getBrutto());
		Assertions.assertEquals(InvoiceTestData.setUpValidInvoiceTestData().getBruttoAmount(), forecast.getNetto());
	}
}
