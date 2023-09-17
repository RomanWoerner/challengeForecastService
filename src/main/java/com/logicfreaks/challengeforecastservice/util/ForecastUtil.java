package com.logicfreaks.challengeforecastservice.util;

import com.logicfreaks.challengeforecastservice.model.Forecast;
import com.logicfreaks.challengeforecastservice.model.Invoice;

import java.util.List;

/**
 * File:           ForecastUtil.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.util
 */
public class ForecastUtil {

	/**
	 * A private constructor is used to hide the public constructor since method calls are static.
	 */
	private ForecastUtil() {

	}

	/**
	 * Formats double value to two placed after comma.
	 *
	 * @param value
	 * @return formated double value
	 */
	public static double roundValue(double value) {
		return Math.round(value * 100.0) / 100.0;
	}

	/**
	 * The Forecast is based on the data that is in the "invoceList" object.
	 *
	 * @param invoiceList
	 * @return Forecast
	 */
	public static Forecast calculateForecast(List<Invoice> invoiceList, int timeFrame) {

		//Guard clause
		if (invoiceList.isEmpty()) {
			throw new IllegalArgumentException("Invoice List is empty");
		}

		//Removes Data - because only the last 12 Months are necessary
		InvoiceUtil.removeTooOldData(invoiceList, timeFrame);

		int divisor = invoiceList.size();

		double bruttoAmount = 0;
		double nettoAmount = 0;

		for (Invoice invoice : invoiceList) {
			bruttoAmount += invoice.getBruttoAmount();
			nettoAmount += invoice.getNettoAmount();
		}

		//The number of Invoices represents the divisor for statistic average value
		bruttoAmount = roundValue(bruttoAmount / divisor);
		nettoAmount = roundValue(nettoAmount / divisor);

		return new Forecast.ForecastBuilder(timeFrame)
				.setBrutto(bruttoAmount)
				.setNetto(nettoAmount)
				.setTimeFrameUnit("Months")
				.build();
	}
}
