package com.logicfreaks.challengeforecastservice.unit.util;

import com.logicfreaks.challengeforecastservice.util.ChartUtil;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * File:           ChartUtilTest.java
 * Version:        Revision: 0.1
 * Last changed:   17.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.util
 */
class ChartUtilTest {

	@Test
	void test_getLineChart_shouldReturn_wellConfigured_jFreeChart() {

		//Arrange
		String chartName = "chartName";
		String categoryLabel = "categoryLabel";
		String valueLabel = "valueLabel";
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		JFreeChart chart = ChartUtil.getLineChart(dataset, chartName, categoryLabel, valueLabel);

		String chartTitle = chart.getTitle().getText();

		Assertions.assertNotNull(chart);
		Assertions.assertEquals(chartName, chartTitle);
	}

	@Test
	void test_converChartToPngBytes_shouldReturn_byteArray() throws IOException {

		//Arrange
		String chartName = "chartName";
		String categoryLabel = "categoryLabel";
		String valueLabel = "valueLabel";
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		JFreeChart chart = ChartUtil.getLineChart(dataset, chartName, categoryLabel, valueLabel);
		byte[] chartBytes = ChartUtil.convertChartToPngBytes(chart, 100, 100);

		Assertions.assertNotNull(chartBytes);

	}
}
