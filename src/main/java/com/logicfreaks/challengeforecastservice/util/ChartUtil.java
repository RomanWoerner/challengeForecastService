package com.logicfreaks.challengeforecastservice.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * File:           ChartUtil.java
 * Version:        Revision: 0.1
 * Last changed:   16.09.2023
 * Purpose:
 * Author:         roman.woerner
 * Product:        challengeForecastService
 * Package:        com.logicfreaks.challengeforecastservice.unit.util
 */
public class ChartUtil {

	/**
	 * Converts JFreeChart to an byte[] so it can be sent over Http.
	 *
	 * @param chart
	 * @param width
	 * @param height
	 * @return byte[] of the given Chart.
	 * @throws IOException
	 */
	public static byte[] convertChartToPngBytes(JFreeChart chart, int width, int height) throws IOException {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();
		chart.draw(g2d, new Rectangle(width, height));

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ChartUtilities.writeBufferedImageAsPNG(byteArrayOutputStream, image);
		return byteArrayOutputStream.toByteArray();
	}

	public static JFreeChart getLineChart(DefaultCategoryDataset dataset, String chartName, String categoryLabel, String valueLabel) {
		return ChartFactory.createLineChart(
				chartName,
				categoryLabel,
				valueLabel,
				dataset,
				PlotOrientation.VERTICAL,
				true,
				true,
				false
		);
	}
}
