package com.logicfreaks.challengeforecastservice.unit.controller;

import com.logicfreaks.challengeforecastservice.controller.InvoiceController;
import com.logicfreaks.challengeforecastservice.service.InvoiceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


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
class InvoiceControllerTest {

	@Mock
	private InvoiceService invoiceService;

	@InjectMocks
	private InvoiceController invoiceController;

	@Test
	void test_exportInvoice_shouldCall_serviceFunction() throws IOException {

		//Act
		invoiceController.exportInvoice();

		//Assert
		verify(invoiceService, times(1)).exportInvoicesToExcel();
	}

	@Test
	void test_getInvoiceGraphic_shouldReturn_stubbedObject_andStatusCode200() throws IOException {

		//Arrange
		byte[] bytes = new byte[0];
		//Configure
		when(invoiceService.getInvoiceGraphic()).thenReturn(bytes);

		//Act
		ResponseEntity<byte[]> response = invoiceController.getInvoiceGraphic();

		//Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(bytes, response.getBody());
	}
}
