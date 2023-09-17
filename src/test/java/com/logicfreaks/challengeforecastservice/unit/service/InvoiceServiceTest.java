package com.logicfreaks.challengeforecastservice.unit.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.logicfreaks.challengeforecastservice.model.Invoice;
import com.logicfreaks.challengeforecastservice.model.Page;
import com.logicfreaks.challengeforecastservice.service.InvoiceService;
import com.logicfreaks.challengeforecastservice.service.WebClientService;
import com.logicfreaks.challengeforecastservice.service.WebClientTokenService;
import com.logicfreaks.challengeforecastservice.unit.testdata.PageTestData;
import com.logicfreaks.challengeforecastservice.util.JsonUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * File:           InvoiceServiceTest.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.service
 */
@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
class InvoiceServiceTest {

	private InvoiceService invoiceService;
	@Mock
	private WebClientService webClientService;
	@Mock
	private WebClientTokenService webClientTokenService;

	@BeforeEach
	void setUp() {
		invoiceService = new InvoiceService(webClientTokenService, webClientService, "123", "1234", "12");
	}

	@Test
	void test_fetchAllActualInvoices_shouldReturn_invoiceList() throws JsonProcessingException {


		//Arrange
		String testToken = "Bearer testToken";
		Page page = PageTestData.setUpPageTestData();
		String pageAsJsonPayload = JsonUtil.paseObjectToJson(page);
		Mono payloadMono = Mono.just(pageAsJsonPayload);

		//Configure
		when(webClientTokenService.getToken()).thenReturn(testToken);
		when(webClientService.get(any(), any(), any())).thenReturn(payloadMono);

		List<Invoice> resultList = invoiceService.fetchAllActualInvoices();


		Assertions.assertNotNull(resultList);
	}

	@Test
	void test_getInvoiceGraphic_shouldReturn_byteArray() throws IOException {

		//Arrange
		String testToken = "Bearer testToken";
		Page page = PageTestData.setUpPageTestData();
		String pageAsJsonPayload = JsonUtil.paseObjectToJson(page);
		Mono payloadMono = Mono.just(pageAsJsonPayload);

		//Configure
		when(webClientTokenService.getToken()).thenReturn(testToken);
		when(webClientService.get(any(), any(), any())).thenReturn(payloadMono);

		//Act
		byte[] bytes = invoiceService.getInvoiceGraphic();

		//Assert
		Assertions.assertNotNull(bytes);
	}

}
