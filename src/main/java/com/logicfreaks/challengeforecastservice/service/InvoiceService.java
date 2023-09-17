package com.logicfreaks.challengeforecastservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.logicfreaks.challengeforecastservice.model.Forecast;
import com.logicfreaks.challengeforecastservice.model.Invoice;
import com.logicfreaks.challengeforecastservice.model.Page;
import com.logicfreaks.challengeforecastservice.util.ChartUtil;
import com.logicfreaks.challengeforecastservice.util.ForecastUtil;
import com.logicfreaks.challengeforecastservice.util.InvoiceUtil;
import com.logicfreaks.challengeforecastservice.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jfree.chart.JFreeChart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * File:           InvoiceService.java
 * Version:        Revision: 0.1
 * Last changed:   16.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.service.impl
 */
@Service
@Slf4j
public class InvoiceService {

	private final WebClientTokenService webClientTokenService;
	private final WebClientService webClientService;
	private final int graphicWidth;
	private final int graphicHeight;
	private final int timeFrame;
	@Value("${local.destination.path}")
	private String destinationPath;
	@Value("${local.destination.filename}")
	private String filename;
	@Value("${billing.api.url}")
	private String externalEndpointBaseUrl;
	@Value("${billing.api.invoiceListEndpoint}")
	private String invoicesListEndpoint;


	public InvoiceService(WebClientTokenService webClientTokenService,
	                      WebClientService webClientService,
	                      @Value("${invoice.graphic.width}") String graphicWidth,
	                      @Value("${invoice.graphic.width}") String graphicHeight,
	                      @Value("${forecast.timeframe}") String timeFrame) {
		this.webClientTokenService = webClientTokenService;
		this.webClientService = webClientService;
		this.graphicWidth = Integer.parseInt(graphicWidth);
		this.graphicHeight = Integer.parseInt(graphicHeight);
		this.timeFrame = Integer.parseInt(timeFrame);
	}

	public void exportInvoicesToExcel() throws IOException {

		List<Invoice> invoiceList = fetchAllActualInvoices();

		try (FileWriter writer = new FileWriter(destinationPath + filename);
		     CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
				     .withHeader("Id", "InvoiceNumber", "InvoiceDate", "BruttoAmount", "NettoAmount", "Status", "Balance", "Debitor_Id", "Debitor_Name", "Debitor_Location", "Debitor_Country", "Debitor_Postcode", "Debitor_PhoneNumber", "Debitor_Email")
				     .withDelimiter(';'))

		) {

			// Schreibe die Daten für jede Rechnung
			for (Invoice invoice : invoiceList) {
				csvPrinter.printRecord(
						invoice.getId(),
						invoice.getInvoiceNumber(),
						invoice.getInvoiceDate(),
						invoice.getBruttoAmount(),
						invoice.getNettoAmount(),
						invoice.getStatus(),
						invoice.getBalance(),
						invoice.getDebitor().getId(),
						invoice.getDebitor().getName(),
						invoice.getDebitor().getLocation(),
						invoice.getDebitor().getCountry(),
						invoice.getDebitor().getPostcode(),
						invoice.getDebitor().getPhoneNumber(),
						invoice.getDebitor().getEmail()

				);
			}
			csvPrinter.flush();
		}
	}

	public byte[] getInvoiceGraphic() throws IOException {


		List<Invoice> invoiceList = fetchAllActualInvoices();

		//Forecast is needed for the graphic too as additional visualization.
		Forecast forecast = ForecastUtil.calculateForecast(invoiceList, timeFrame);

		JFreeChart chart = InvoiceUtil.createChart(invoiceList, timeFrame, forecast);

		return ChartUtil.convertChartToPngBytes(chart, graphicWidth, graphicHeight);

	}

	public List<Invoice> fetchAllActualInvoices() throws JsonProcessingException {

		List<Invoice> invoiceList = new ArrayList<>();
		String resultString = webClientService.get(externalEndpointBaseUrl + invoicesListEndpoint, getHttpHeaders(), String.class).block();

		Page resultPage = JsonUtil.parseJsonToObject(resultString, Page.class);
		invoiceList.addAll(resultPage.getEmbedded().getInvoiceList());

		//Dynamic loop for making sure receiving all pages of Invoices
		for (int page = resultPage.getPage(); page <= resultPage.getPageCount(); page++) {

			resultString = webClientService.get(externalEndpointBaseUrl + invoicesListEndpoint + "?page=" + page, getHttpHeaders(), String.class).block();
			resultPage = JsonUtil.parseJsonToObject(resultString, Page.class);
			invoiceList.addAll(resultPage.getEmbedded().getInvoiceList());
		}
		InvoiceUtil.adaptInvoices(invoiceList);

		return invoiceList;
	}

	/**
	 * For the usage of the webClient postRequests.
	 *
	 * @return Configured HttpHeaders wrapping Consumer class.
	 */
	public Consumer<HttpHeaders> getHttpHeaders() {
		return httpHeaders -> {
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			httpHeaders.set(HttpHeaders.AUTHORIZATION, webClientTokenService.getToken());
		};
	}
}
