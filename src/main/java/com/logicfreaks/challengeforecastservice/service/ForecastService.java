package com.logicfreaks.challengeforecastservice.service;

import com.logicfreaks.challengeforecastservice.model.Forecast;
import com.logicfreaks.challengeforecastservice.model.Invoice;
import com.logicfreaks.challengeforecastservice.service.exception.ForecastException;
import com.logicfreaks.challengeforecastservice.util.ForecastUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * File:           ForecastService.java
 * Version:        Revision: 0.1
 * Last changed:   16.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.service.impl
 */
@Service
@Slf4j
public class ForecastService {


	private final InvoiceService invoiceService;


	private final int timeFrame;


	//Dependency Injection
	public ForecastService(InvoiceService invoiceService, @Value("${forecast.timeframe}") String timeFrame) {
		this.invoiceService = invoiceService;
		this.timeFrame = Integer.parseInt(timeFrame);
	}

	/**
	 * Returns a Forecast for the current month - Statistic is based on the data from the API-Billing Api, that is
	 * requested in this function.
	 *
	 * @return actual Forecast.
	 */
	public Forecast getForecast() {
		try {
			//Call invoiceService function, to receive all invoices.
			List<Invoice> invoiceList = invoiceService.fetchAllActualInvoices();

			return ForecastUtil.calculateForecast(invoiceList, timeFrame);
		} catch (Exception ex) {
			throw new ForecastException("Cannot calculate Forecast ", ex);
		}
	}
}
