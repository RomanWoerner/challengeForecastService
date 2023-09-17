package com.logicfreaks.challengeforecastservice.util;

import com.logicfreaks.challengeforecastservice.model.Forecast;
import com.logicfreaks.challengeforecastservice.model.Invoice;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * File:           InvoiceUtil.java
 * Version:        Revision: 0.1
 * Last changed:   16.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.util
 */
public class InvoiceUtil {

	/**
	 * A private constructor is used to hide the public constructor since method calls are static.
	 */
	private InvoiceUtil() {

	}

	/**
	 * If data is in the range of the Timeframe, they will stay in the list.
	 *
	 * @param invoiceList
	 * @param timeFrame   that represents data of the last months given in timeFrame value.
	 */
	public static void removeTooOldData(List<Invoice> invoiceList, int timeFrame) {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -timeFrame);

		invoiceList.removeIf(invoice -> !invoice.getInvoiceDate().after(calendar.getTime()));
	}

	/**
	 * Eliminates data from the list that is unsuitable for calculations or is either damaged or incomplete.
	 *
	 * @param invoiceList
	 */
	public static void adaptInvoices(List<Invoice> invoiceList) {

		invoiceList.removeIf(invoice -> !invoiceIsValid(invoice));

		for (Invoice invoice : invoiceList) {
			if (invoice.getStatus() != null && invoice.getStatus().equalsIgnoreCase("open")) {
				invoice.setBalance(invoice.getBruttoAmount());
			} else {
				invoice.setBalance(0);
			}
		}
	}

	/**
	 * Check for valid values in Invoice object.
	 *
	 * @param invoice
	 * @return true if some values of the given Object are null or invalid
	 */
	public static boolean invoiceIsValid(Invoice invoice) {
		return invoice.getInvoiceDate() != null && invoice.getBruttoAmount() > 0 && invoice.getNettoAmount() > 0;
	}


	/**
	 * The configured Timeframe comes as a String from application Properties. This function returnes
	 * a date format that takes care of the Configured value that needs to be parsed to an Integer before use it.
	 *
	 * @return Timeframe as date
	 */

	public static void sortListByDate(List<Invoice> invoiceList) {

		Comparator<Invoice> dataComparator = Comparator.comparing(Invoice::getInvoiceDate);

		Collections.sort(invoiceList, dataComparator);
	}

	/**
	 * Returns a chart that represents the invoices for the configured timeframe and a Forecast of the current month.
	 * The timeframe is configured in application.properties.
	 * The Data is based on the API-Billing Api.
	 *
	 * @param invoiceList
	 * @param timeFrame
	 * @param forecast
	 * @return
	 */
	public static JFreeChart createChart(List<Invoice> invoiceList, int timeFrame, Forecast forecast) {

		//For this graphic, only the given months are necessary for visualization.
		InvoiceUtil.removeTooOldData(invoiceList, timeFrame);

		//For the graphic, the List should be sorted
		sortListByDate(invoiceList);


		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM. yyyy");

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		//Iterate and set Data
		for (Invoice invoice : invoiceList) {
			dataset.addValue(invoice.getBruttoAmount(), "Brutto", dateFormat.format(invoice.getInvoiceDate()));
			dataset.addValue(invoice.getNettoAmount(), "Netto", dateFormat.format(invoice.getInvoiceDate()));
		}

		//Returnes the first Day of current month
		String startMonth = calculateMonthFromNow(0);

		//Return the first Day of next month
		String endMonth = calculateMonthFromNow(1);

		//Place forecast into graphic with timeFrame represents the Duration of the current month.
		dataset.addValue(forecast.getBrutto(), "Brutto Forecast", startMonth);
		dataset.addValue(forecast.getNetto(), "Netto Forecast", startMonth);
		dataset.setValue(forecast.getBrutto(), "Brutto Forecast", endMonth);
		dataset.setValue(forecast.getNetto(), "Netto Forecast", endMonth);

		return ChartUtil.getLineChart(dataset, "Invoice Statstic", "Timeframe", "Currency");
	}

	/**
	 * Add months to the current date in "Sep. 2023" format and returnes it as String.
	 *
	 * @param additionalTimeFrame represents the addition of Months to the current Date.
	 * @return String of the month that is increased or decreased with the value.
	 */
	public static String calculateMonthFromNow(int additionalTimeFrame) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM. yyyy");

		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, additionalTimeFrame);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		return dateFormat.format(calendar.getTime());
	}

}
