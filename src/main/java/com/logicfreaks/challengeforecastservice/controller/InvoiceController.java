package com.logicfreaks.challengeforecastservice.controller;

import com.logicfreaks.challengeforecastservice.service.InvoiceService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * File:           InvoiceController.java
 * Version:        Revision: 0.1
 * Last changed:   16.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.controller
 */
@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	private final InvoiceService invoiceService;

	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@PostMapping("/export")
	public ResponseEntity<String> exportInvoice() throws IOException {
		invoiceService.exportInvoicesToExcel();
		return ResponseEntity.ok("Successful");
	}

	@GetMapping(value = "/getInvoiceGraphic", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> getInvoiceGraphic() throws IOException {
		return ResponseEntity.ok(invoiceService.getInvoiceGraphic());
	}

}
